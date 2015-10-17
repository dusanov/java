public class dodeadlock {

  public static void main (String[] args){
   
    final deadlock dl = new deadlock();

    Thread t1 = new Thread () {

      public void run (){
       try {
        dl.method1();
      } catch (Exception e)
      {
        System.out.format("omg something happend in thread 1 %1", e.toString()); 
      }
      }
    };

    Thread t2 = new Thread () {
      public void run () {
       try {
         dl.method2();
      } catch (Exception e)
      {
        System.out.format("omg something happend in thread 2 %1", e.toString());
      }

      }
    };

    t1.start();
    t2.start(); 
  }
}
