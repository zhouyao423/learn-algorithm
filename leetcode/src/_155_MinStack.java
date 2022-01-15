import java.util.ArrayDeque;
import java.util.Deque;

public class _155_MinStack {
    //155. 最小栈 https://leetcode-cn.com/problems/min-stack/
    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    //push(x) —— 将元素 x 推入栈中。
    //pop() —— 删除栈顶的元素。
    //top() —— 获取栈顶元素。
    //getMin() —— 检索栈中的最小元素。
    public static void main(String[] args) {

    }


    public _155_MinStack() {

    }
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()){
            minStack.push(val);
        }else {
            int min = Math.min(minStack.peek(), val);
            minStack.push(min);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
