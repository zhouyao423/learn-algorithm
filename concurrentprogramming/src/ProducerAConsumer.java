import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAConsumer {
    static LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2000);

    public static void main(String[] args) throws InterruptedException {
       Producer producer = new Producer(blockingQueue);
       new Thread(producer).start();
       new Thread(producer).start();
       Thread.sleep(5000L);
       Consumer consumer = new Consumer(blockingQueue);
        for (int i = 0; i < 5; i++) {
            new Thread(consumer).start();
        }



    }

    static class Producer implements Runnable{
        LinkedBlockingQueue<Integer> blockingQueue;
        Producer(LinkedBlockingQueue<Integer> blockingQueue){
            this.blockingQueue = blockingQueue;
        }
        int c = 0;
        @Override
        public void run() {
            while (true){

                try {
                    blockingQueue.put(++c);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   static class Consumer implements Runnable{
        LinkedBlockingQueue<Integer> blockingQueue;
        Consumer(LinkedBlockingQueue<Integer> blockingQueue){
            this.blockingQueue = blockingQueue;
        }
        @Override
        public void run() {
            while (true){
                Integer poll = null;
                try {
                    poll = blockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "-" + poll);
            }
        }
    }
}
