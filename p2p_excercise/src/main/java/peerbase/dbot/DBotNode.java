package peerbase.dbot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import peerbase.HandlerInterface;
import peerbase.LoggerUtil;
import peerbase.Node;
import peerbase.PeerConnection;
import peerbase.PeerInfo;
import peerbase.PeerMessage;
import peerbase.RouterInterface;
import peerbase.util.SimplePingStabilizer;

@SpringBootApplication
public class DBotNode extends Node/* implements CommandLineRunner*/ {
	
	/* MESSAGE TYPES */
	public static final String JOINPEER = "JOIN";
	public static final String LISTPEER = "LIST";
	public static final String PEERNAME = "NAME";
	public static final String QUERY = "QUER";
	public static final String QRESPONSE = "RESP";
	public static final String SOME_MESSAGE = "SOME";
	public static final String PEERQUIT = "QUIT";
	public static final String REPLY = "REPL";
	public static final String ERROR = "ERRO";
	public static final String PING = "PING";
	public static final String PONG = "PONG";
	
	public DBotNode(int maxPeers, PeerInfo myInfo) {
		super(maxPeers, myInfo);
		
		this.addRouter(new Router(this));
		
		this.addHandler(JOINPEER, new JoinHandler(this));
		this.addHandler(LISTPEER, new ListHandler(this));
		this.addHandler(PEERNAME, new NameHandler(this));
		this.addHandler(QUERY, new QueryHandler(this));
		this.addHandler(QRESPONSE, new QResponseHandler(this));
		this.addHandler(SOME_MESSAGE, new SomeMessageHandler(this));
		this.addHandler(PEERQUIT, new QuitHandler(this));
		this.addHandler(PING, new PingHandler(this));
		
	}
	
	//private static ConfigurableApplicationContext sctx;

	public static void main(String[] args) throws IOException
	{
		
		/*
		sctx = SpringApplication.run(DBotNode.class, args);
	}
	
	@Override
	public void run(String[] args) throws IOException {
		*/
		
		int port = 9001;
		String host = "localhost";
		
		System.out.println(" === args size: " + args.length + ", items: ");
		for (String arg : args) System.out.println(arg);		
		
		if (args.length != 2) {
			System.out.println("Usage: java ... DBotNode <pid> <host-port>");
		}
		else {
			host = args[0];
			port = Integer.parseInt(args[1]);
		}

		LoggerUtil.setHandlersLevel(Level.FINER);
		
		DBotNode peer = new DBotNode(5, new PeerInfo(host, port));
		peer.buildPeers("localhost", 8080, 2);

		(new Thread() { public void run() { peer.mainLoop(); LoggerUtil.getLogger().fine(" !!! main thread finished !!! "); }}).start();		

		peer.startStabilizer(new SimplePingStabilizer(peer), 13000);
		
/*
        String line;
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ((line = reader.readLine()) != null) {
            if (line.equals("QUIT")) {
    */        	
            	/*
            	 int exitCode = SpringApplication.exit(sctx, new ExitCodeGenerator() {
                     @Override
                     public int getExitCode() {
                         // no errors
                         return 0;
                     }
                 });
                 System.exit(exitCode);     
            	 */
  /*                           	
            	System.exit(0);
                break;
            } else if (line.equals("BUILD")){
            	peer.buildPeers("localhost", 9000, 2);
            }else if (line.equals("LIST")){
            	
            	for (String pid : peer.getPeerKeys()) {
    				LoggerUtil.getLogger().fine( String.format("%s %s %d", pid, peer.getPeer(pid).getHost(),
    								peer.getPeer(pid).getPort()) );
            	}
            } else if (line.startsWith("SEND")) {
            	
            	String[] splitline = line.split(" ");
            	peer.connectAndSend(peer.getPeer(splitline[1]), DBotNode.SOME_MESSAGE, splitline[2], false);
            	//peer.sendToPeer(splitline[1], DBotNode.SOME_MESSAGE, splitline[2], false);
            	
            } else {
            	LoggerUtil.getLogger().fine(" === "+line+" === ");
                LoggerUtil.getLogger().fine(" ---==== " + peer.getHost());
                LoggerUtil.getLogger().fine(" ---==== " + peer.getPeerKeys());
            }
        }

*/
	}	
	
	public void buildPeers(String host, int port, int hops) {
		LoggerUtil.getLogger().fine("build peers");
		
		if (this.maxPeersReached() || hops <= 0)
			return;
		
		PeerInfo pd = new PeerInfo(host, port);
		List<PeerMessage> resplist = this.connectAndSend(pd, PEERNAME, "", true);
		if (resplist == null || resplist.size() == 0){
			LoggerUtil.getLogger().fine(" ===  no response on PEERNAME");
			return;
		}
		String peerid = resplist.get(0).getMsgData();
		LoggerUtil.getLogger().fine(" ==== contacted " + peerid);
		pd.setId(peerid);
		
		String resp = this.connectAndSend(pd, JOINPEER,
				String.format("%s %s %d", this.getId(), this.getHost(), this.getPort()), true).get(0).getMsgType();
		if (!resp.equals(REPLY) || this.getPeerKeys().contains(peerid))
			return;
		
		this.addPeer(pd);
		
		// do recursive depth first search to add more peers
		resplist = this.connectAndSend(pd, LISTPEER, "", true);
		
		if (resplist.size() > 1) {
			resplist.remove(0);
			for (PeerMessage pm : resplist) {
				String[] data = pm.getMsgData().split("\\s");
				String nextpid = data[0];
				String nexthost = data[1];
				int nextport = Integer.parseInt(data[2]);
				if (!nextpid.equals(this.getId()))
					buildPeers(nexthost, nextport, hops - 1);
			}
		}
	}
	
	
	
	
	/* INNER CLASSES */
	
	/* msg syntax: JOIN pid host port */
	private class JoinHandler implements HandlerInterface {
		private Node peer;
		
		public JoinHandler(Node peer) { this.peer = peer; }
				
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			if (peer.maxPeersReached()) {
				LoggerUtil.getLogger().fine("maxpeers reached " + 
									peer.getMaxPeers());
				peerconn.sendData(new PeerMessage(ERROR, "Join: " +
									"too many peers"));
				return;
			}
			
			// check for correct number of arguments
			String[] data = msg.getMsgData().split("\\s");
			if (data.length != 3) {
				peerconn.sendData(new PeerMessage(ERROR, "Join: " +
									"incorrect arguments"));
				return;
			}
			
			// parse arguments into PeerInfo structure
			PeerInfo info = new PeerInfo(data[0], data[1],
										 Integer.parseInt(data[2]));
			
			if (peer.getPeer(info.getId()) != null) 
				peerconn.sendData(new PeerMessage(ERROR, "Join: " +
										"peer already inserted"));
			else if (info.getId().equals(peer.getId())) 
				peerconn.sendData(new PeerMessage(ERROR, "Join: " +
										"attempt to insert self"));
			else {
				peer.addPeer(info);
				peerconn.sendData(new PeerMessage(REPLY, "Join: " +
										"peer added: " + info.getId()));
			}
		}
	}

	/* msg syntax: LIST */
	private class PingHandler implements HandlerInterface {
		private Node peer;
		
		public PingHandler(Node peer) { this.peer = peer; }
		
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			peerconn.sendData(new PeerMessage(REPLY,PONG));

		}
	}	
	
	
	
	/* msg syntax: LIST */
	private class ListHandler implements HandlerInterface {
		private Node peer;
		
		public ListHandler(Node peer) { this.peer = peer; }
		
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			peerconn.sendData(new PeerMessage(REPLY, 
					String.format("%d", peer.getNumberOfPeers())));
			for (String pid : peer.getPeerKeys()) {
				peerconn.sendData(new PeerMessage(REPLY, 
						String.format("%s %s %d", pid, peer.getPeer(pid).getHost(),
								peer.getPeer(pid).getPort())));
			}
		}
	}
	
	/* msg syntax: NAME */
	private class NameHandler implements HandlerInterface {
		private Node peer;
		
		public NameHandler(Node peer) { this.peer = peer; }
		
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			peerconn.sendData(new PeerMessage(REPLY, peer.getId()));
		}
	}

	/* msg syntax: QUER return-pid key ttl */
	private class QueryHandler implements HandlerInterface {
		private DBotNode peer;
		public QueryHandler(DBotNode peer) { this.peer = peer; }
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			String[] data = msg.getMsgData().split("\\s");
			if (data.length != 3) {
				peerconn.sendData(new PeerMessage(ERROR, "Query: incorrect arguments"));
				return;
			}
			
			String ret_pid = data[0].trim();
			String key = data[1].trim();
			int ttl = Integer.parseInt(data[2].trim());
			peerconn.sendData(new PeerMessage(REPLY, "Query: ACK"));
			/* After acknowledging the query, this connection will be closed. A
			 * separate thread will be started to actually perform the task of the
			 * query...
			 */ 
			
			QueryProcessor qp = new QueryProcessor(peer, ret_pid, key, ttl);
			qp.start();
		}
	}

	private class QueryProcessor extends Thread {
		private DBotNode peer;
		private String ret_pid;
		private String key;
		private int ttl;
		
		public QueryProcessor(DBotNode peer, String ret_pid, 
								String key, int ttl) {
			this.peer = peer;
			this.ret_pid = ret_pid;
			this.key = key;
			this.ttl = ttl;
		}
		
		public void run() {
			// search through this node's list of files for a filename 
			// containing the key
			/*
			for (String filename : peer.files.keySet()) {
				if (filename.toUpperCase().indexOf(key.toUpperCase()) >= 0) {
					String fpid = peer.files.get(filename);
					String[] data = ret_pid.split(":");
					String host = data[0];
					int port = Integer.parseInt(data[1]);
					peer.connectAndSend(new PeerInfo(ret_pid, host, port), 
							QRESPONSE, filename + " " + fpid, true);
					LoggerUtil.getLogger().fine("Sent QRESP " 
							+ new PeerInfo(ret_pid, host, port) 
							+ " " + filename + " " + fpid);
					return;
				}
			}
			*/
			
			// will only reach here if key not found... 
			// in which case propagate query to neighbors, if there is still
			// time-to-live for the query
			if (ttl > 0) {
				String msgdata = String.format("%s %s %d", ret_pid, key, ttl - 1);
				for (String nextpid : peer.getPeerKeys())
					peer.sendToPeer(nextpid, QUERY, msgdata, true);
			}
		}
	}

	/* msg syntax: RESP file-name pid */
	private class QResponseHandler implements HandlerInterface {
		@SuppressWarnings("unused")
		private Node peer;
		
		public QResponseHandler(Node peer) { this.peer = peer; }
		
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			String[] data = msg.getMsgData().split("\\s");
			if (data.length != 2) {
				peerconn.sendData(new PeerMessage(ERROR, "Resp: "
						+ "incorrect arguments"));
				return;
			}
			
			/*
			String filename = data[0];
			String pid = data[1];
			if (files.containsKey(filename)) {
				peerconn.sendData(new PeerMessage(ERROR, "Resp: " 
						+ "can't add duplicate file " + filename));
				return;
			}
			
			files.put(filename, pid);
			peerconn.sendData(new PeerMessage(REPLY, "Resp: "
					+ "file info added " + filename));
					
			*/
		}
	}

	/* msg syntax: FGET file-name */
	private class SomeMessageHandler implements HandlerInterface {
		@SuppressWarnings("unused")
		private Node peer;
		
		public SomeMessageHandler(Node peer) { this.peer = peer; }
		
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			String someMessage = msg.getMsgData().trim();
			
			LoggerUtil.getLogger().fine(" ==== got this message : " + someMessage);
			
			/*
			if (!files.containsKey(filename)) {
				peerconn.sendData(new PeerMessage(ERROR, "Fget: "
						+ "file not found " + filename));
				return;
			}
			
			byte[] filedata = null;
			try {
				FileInputStream infile = new FileInputStream(filename);
				int len = infile.available();
				filedata = new byte[len];
				infile.read(filedata);
				infile.close();
			}
			catch (IOException e) {
				LoggerUtil.getLogger().info("Fget: error reading file: " + e);
				peerconn.sendData(new PeerMessage(ERROR, "Fget: "
						+ "error reading file " + filename));
				return;
			}
			
			peerconn.sendData(new PeerMessage(REPLY, filedata));
			*/
		}
	}

	/* msg syntax: QUIT pid */
	private class QuitHandler implements HandlerInterface {
		private Node peer;
		
		public QuitHandler(Node peer) { this.peer = peer; }
		
		public void handleMessage(PeerConnection peerconn, PeerMessage msg) {
			String pid = msg.getMsgData().trim();
			if (peer.getPeer(pid) == null) {
				peerconn.sendData(new PeerMessage(ERROR, "Quit: peer not found: " + pid));
			} 
			else {
				peer.removePeer(pid);
				peerconn.sendData(new PeerMessage(REPLY, "Quit: peer removed: " + pid));
			}
		}
	}
	
	private class Router implements RouterInterface {
		private Node peer;
		
		public Router(Node peer) {
			this.peer = peer;
		}
		
		public PeerInfo route(String peerid) {
			if (peer.getPeerKeys().contains(peerid)) return peer.getPeer(peerid);
			else return null;
		}
	}
	
}
