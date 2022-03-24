import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JstackTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.SECONDS.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        countDownLatch.countDown();

    }
}
