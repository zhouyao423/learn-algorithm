import com.sun.source.tree.IfTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class _581_findUnsortedSubarray {
//581. 最短无序连续子数组
//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
//请你找出符合题意的 最短 子数组，并输出它的长度。
//
//
//
//示例 1：
//
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

    public static void main(String[] args) {
        _581_findUnsortedSubarray f = new _581_findUnsortedSubarray();
        f.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        Deque<Integer> headStack = new ArrayDeque<>();
        int left = length -1;
        int right = 0;
        headStack.push(0);
        Deque<Integer> tailStack = new ArrayDeque<>();
        tailStack.push(length - 1);
        for (int i = 0; i < length; i++) {
            Integer peek = headStack.peek();
            if (peek!=null &&nums[i] >= nums[peek]) {
                headStack.push(i);
            } else {
                Integer peek1;
                while ((peek1 = headStack.peek()) != null && nums[peek1] > nums[i]) {
                    Integer pop = headStack.pop();
                    left = Math.min(left,pop);
                }
            }

            Integer tailPeek = tailStack.peek();
            int j = length - i - 1;
            if (tailPeek != null && nums[j] < nums[tailPeek]) {
                tailStack.push(j);
            } else {
                Integer peek1;
                while ((peek1 = tailStack.peek()) != null && nums[peek1] < nums[j]) {
                    Integer pop = tailStack.pop();
                    right = Math.max(pop,right);
                }
            }

        }

        return right - left >0 ? right - left-1 :0;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        //从左到右最大值的索引
        int end = 0;
        //从右到左最小值的索引
        int start = length -1;
        //左侧最大值的值
        int maxNum = Integer.MIN_VALUE;
        //右侧最小值的索引
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum){
                maxNum = nums[i];
            }else {
                end = i;
            }
            int j = length - i -1;
            if (nums[j] <minNum){
                minNum = nums[j];
            }else {
                start = j;
            }
        }
        return end - start <0?0:end - start -1;
    }

}
