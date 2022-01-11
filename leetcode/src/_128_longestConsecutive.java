import java.util.HashMap;
import java.util.Map;

public class _128_longestConsecutive {
    //128. 最长连续序列  https://leetcode-cn.com/problems/longest-consecutive-sequence/
    //给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    //
    //请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [100,4,200,1,3,2]
    //输出：4
    //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], null);
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                continue;
            }
            int j = 1;
            while (map.containsKey(nums[i] + j)) {
                j++;
            }
            longest = Math.max(longest, j - 1);
        }
        return longest;
    }
}
