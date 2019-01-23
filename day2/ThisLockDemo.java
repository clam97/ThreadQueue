package org.day2;

class Ticket implements Runnable
{
    private int tick = 100;
  //  Object obj = new Object();
    boolean flag = true;
    public void run()
    {
        if(flag)
        {
            while(true)
            {
               synchronized(this)    /*同步函数的锁*/
                {
                    if(tick>0)
                    {
                        try
                        {
                           Thread.sleep(10);
                        }catch(Exception e){}
                        System.out.println(Thread.currentThread().getName()+"....code : "+ tick--);
                    }
                }
            }
        }
        else
            while(true)
                show();           /*使用this锁*/
    }
    public synchronized void show()//this
    {
        if(tick>0)
        {
            try{Thread.sleep(10);}catch(Exception e){}
            System.out.println(Thread.currentThread().getName()+"....show.... : "+ tick--);
        }
    }
}


class  ThisLockDemo
{
    public static void main(String[] args)
    {

        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);


        t1.start();
        try{
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10);
            System.out.println("saaaaaaaaaaaaaaaa");}

        catch(Exception e){}
        t.flag = false;
        t2.start();
        try{Thread.sleep(10);}
        catch(Exception e){}


//        Thread t3 = new Thread(t);
//        Thread t4 = new Thread(t);
//        t3.start();
//        t4.start();


    }
}


