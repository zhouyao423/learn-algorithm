import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 同一时间只允许两个线程获取锁，多余两个线程则阻塞
 *
 * @author zhouyao
 * @date 2022/3/21 5:53 PM
 **/
public class TwinsLock  {

    private TLock tLock = new TLock();
    private  class TLock extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryRelease(int arg) {
            int state = getState();
            if (state<=0){
                throw new IllegalStateException("lock state error.");
            }
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(()->{

            });
            return compareAndSetState(state,state-arg);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state < 2) {
                return compareAndSetState(state, state + arg);
            }
            return false;
        }
    }
    public void lock(){
        tLock.acquire(1);
        System.out.println("get lock");
    }

    public void unlock(){
        tLock.release(1);
        System.out.println("release lock");
    }



    public static void main(String[] args) {
        TwinsLock twinsLock = new TwinsLock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                twinsLock.lock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                twinsLock.unlock();
            }).start();
        }

    }
}
