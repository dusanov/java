public class deadlock {

    public void method1() throws InterruptedException {
        synchronized (String.class) {
            System.out.println("Aquired lock on String.class object");
              Thread.sleep(1000);
//            synchronized (Integer.class) {
  //              System.out.println("Aquired lock on Integer.class object");
     //       }
        }
    }


   public void method2() throws InterruptedException {
        synchronized (String.class /*Integer.class*/)  {
            System.out.println("Aquired lock on STRING Integer.class object");
              Thread.sleep(1000);
    //        synchronized (String.class) {
      //          System.out.println("Aquired lock on String.class object");
        //    }
        }
    }
}
