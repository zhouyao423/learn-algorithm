import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过condition实现有界队列
 * @author zhouyao
 * @date 2022/3/22 1:41 PM
 **/
public class BoundedQueue<T> {
    private Object[] array;
    //当前数组的数量
    private int count;
    //当前索引
    private int index;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmptyCondition = lock.newCondition();
    private Condition notFullCondition = lock.newCondition();

    public BoundedQueue(int size){
        array = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            //队列已满
            while (count == array.length){
                notFullCondition.await();
            }
            index++;
            count++;
            array[index] = t;
            if (index == array.length){
                index = 0;
            }
            notEmptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }
}
