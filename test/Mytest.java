package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Mytest {

    public static void main(String[] args) {
        Mycallable mycall = new Mycallable();
        try {
            for (int i = 0; i <10 ; i++) {
                FutureTask<Integer> f = new FutureTask<Integer>(mycall);

                Thread t = new Thread(f);
                t.start();
                System.out.println(f.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
