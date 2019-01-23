package org.day2;

public class MyThread {
    public static void main(String[] args) {
        Ticked t = new Ticked();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t2.start();
        t1.start();



    }

}
class Ticked implements Runnable{
   private int tick = 10;
    @Override
    public void run() {
       synchronized (Ticked.class){//把run函数锁了

              while (tick>0){
                  try {
                      Thread.sleep(10);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(Thread.currentThread().getName()+"======"+tick--);
              }
              System.out.println(Thread.currentThread().getName()+"没有tick了");
          }

        }


    }
