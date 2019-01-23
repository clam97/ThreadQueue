package org.day2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class NoQueue {
    private static LinkedBlockingDeque<Integer> concurrentLinkedQueue = new LinkedBlockingDeque<Integer>();



    //生产者
    static class Producer implements Runnable{

        private String name;

        public Producer(String name){
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println(name+"生产了：======"+i+"这个产品");
                concurrentLinkedQueue.add(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者
    static class Consumer implements Runnable{

        private String name;

        public Consumer(String name){
            this.name = name;
        }
        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                System.out.println(name+"开始消费：++++++"+concurrentLinkedQueue.poll());
                if (concurrentLinkedQueue.poll()==null){
                    System.out.println(name+"第"+i+"次没有消费到东西   ～～～嘤嘤嘤");
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(new Producer("生产者1"));
        es.submit(new Producer("生产者2"));
        es.submit(new Producer("生产者3"));
        es.submit(new Consumer("消费者1"));
        es.shutdown();
        es.submit(new Consumer("消费者2"));
    }
}
