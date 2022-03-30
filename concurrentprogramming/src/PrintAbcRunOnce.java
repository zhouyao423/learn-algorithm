import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class PrintAbcRunOnce {
    //顺序打印ABC 每个线程只执行一次

    public static void main(String[] args) throws InterruptedException {
        String[] strings = new String[]{"A","B","C"};
        Semaphore s0 = new Semaphore(1);
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);

        Semaphore[] semaphores = new Semaphore[3];
        semaphores[0] = s0;
        semaphores[1] = s1;
        semaphores[2] = s2;
        for (int i = 0; i < 3; i++) {
            String str = strings[i];
            Semaphore nextSemaphore = semaphores[(i + 1) % 3];
            Semaphore curSemaphore = semaphores[i];
            new Thread(()->{
                int count = 10;
                while (count > 0) {
                    try {
                        curSemaphore.acquire();
                        System.out.println(Thread.currentThread().getName());
                        System.out.println(str);
                        count --;
                        nextSemaphore.release(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
