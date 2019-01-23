package org.day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockDeque {//阻塞队列
    private static LinkedBlockingDeque<Integer> concurrentLinkedQueue = new LinkedBlockingDeque<Integer>();



    //生产者
    static class Producer implements Runnable{
        private String name;

        public Producer(String name){
            this.name = name;

        }
        @Override
        public void run() {
            for (int i = 0; i <15 ; i++) {
                System.out.println(name+"成产"+i);
                try {
                    concurrentLinkedQueue.put(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //消费者
    static class Consumer implements Runnable{

        private String name ;
        public Consumer(String name){
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                try {
                    System.out.println(name+"消费："+concurrentLinkedQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new Producer("P1"));
        es.submit(new Consumer("C1"));
        es.submit(new Consumer("C2"));
        es.submit(new Producer("P2"));

    }
}
