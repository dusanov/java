import java.util.*;

enum Title {

	MR("Mr."),
	MS("Ms."),
	MRS("Mrs.");
	
	public String format(String last, String first){return first+last;};
	private final String title;
    	Title(String title) { this.title = title; }
    	public String title() { return title; }
}

/* abstract */ class Class2 implements Base {

	public boolean m1 (){return false;}
	public byte m2 (short s){return 42;}
	
	void main (){
		int i = 1;
		while (i>1); 	
	}

	public void method(int i, String[] ... argz){System.out.println(" args: " + Arrays.toString(argz));}
	public static void main(String ... args){
		List list = Arrays.asList(args);
		long l = 23453344;//56;
		int i = (int)l;
		System.out.println(l);
		Class2 clazz = new Class2();
		clazz.method(1);
	}
}

final class A{}
abstract class B{}
/*public */ class C{}


