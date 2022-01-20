import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class _239_maxSlidingWindow {
    //239. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
    //给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    //
    //返回滑动窗口中的最大值。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    //解释：
    //滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    //示例 2：
    //
    //输入：nums = [1], k = 1
    //输出：[1]
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{2,-1,2,5,4,-2,7},3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArr = new int[nums.length - k + 1];
        //单调队列
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k ; i++) {
            push(nums, queue, i);
        }
        for (int i = 0; i <= nums.length - k; i++) {
            Integer peek = queue.peek();
            maxArr[i] = nums[peek];
            if (peek ==i){
                queue.pop();
            }
            push(nums, queue, k + i );
        }
        return maxArr;
    }

    private static void push(int[] nums, Deque<Integer> queue, int i) {
        if (i>=nums.length){
            return;
        }
        if (queue.isEmpty()) {
            queue.push(i);
        } else {
            while (queue.peekLast() != null) {
                Integer lastIndex = queue.peekLast();
                if (nums[i] > nums[lastIndex]) {
                    queue.removeLast();
                } else {
                    break;
                }
            }
            queue.addLast(i);
        }
    }
}
