package test;

import java.util.concurrent.Callable;

public class Mycallable implements Callable<Integer> {
    private  int res = 0;
    @Override
    public Integer call() throws Exception {
//        int i = 0;
//        for ( i= 0; i <10 ; i++) {
//           // System.out.println(i);
//        }
        res++;
        return res;
    }
}
