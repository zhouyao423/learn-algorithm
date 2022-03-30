import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    //三个程序顺序打印abc
    private static volatile Integer state = 0;

    public static void main(String[] args) throws InterruptedException {
        char[] chars = new char[]{'A', 'B', 'C'};
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        for (int i = 0; i < 3; i++) {
            new Thread(new Printer(chars[i], lock,condition,i)).start();
        }
    }

    static class Printer implements Runnable {
        private final Character printStr;
        private ReentrantLock lock;
        private final Condition condition;
        private final Integer curState;
        private Integer max = 10;

        Printer(Character printStr, ReentrantLock lock, Condition condition, Integer state) {
            this.printStr = printStr;
            this.lock = lock;
            this.condition = condition;
            this.curState = state;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    if (state.equals(curState)) {
                        System.out.println(printStr);
                        max--;
                        state = (state+1)%3;
                        condition.signalAll();
                        if (max <= 0) {
                            break;
                        }
                    } else {
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
