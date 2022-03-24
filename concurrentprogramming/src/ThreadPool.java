import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {

    private LinkedList<Runnable> jobs = new LinkedList<>();
    private List<Runnable> workers = Collections.synchronizedList(new ArrayList<>());

    public ThreadPool() {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker();
            worker.setName("worker-" + i);
            workers.add(worker);
            worker.start();
        }
    }

    public void execute(Runnable job){
        synchronized (jobs){
            jobs.addLast(job);
            jobs.notify();
        }
    }
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                int i1 = atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+i1);
            });
            Thread.sleep(100);
        }
    }


    private class Worker extends Thread{
        @Override
        public void run() {
            System.out.println(getName() + "start");
            while (true){
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Runnable runnable = jobs.removeFirst();
                    runnable.run();
                }
            }

        }
    }

}
