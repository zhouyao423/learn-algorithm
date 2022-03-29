import java.util.Arrays;

public class _1_twoSum {
    //给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //
    //你可以按任意顺序返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    //示例 2：
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/two-sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int find = findNum(nums,i+1,nums.length-1, target - nums[i]);
            if (find > 0){
                return new int[]{i,find};
            }
        }
        return new int[2];
    }

    private int findNum(int[] nums, int start, int end,int target) {
        if (start >end){
            return -1;
        }
        if (start == end){
            return nums[start] == target ? start : -1;
        }
        int mid = (start + end) /2;
        if (nums[mid] == target){
            return mid;
        }
        int num = findNum(nums, start, mid - 1, target);
        if (num < 0){
            return findNum(nums,mid +1,end,target);
        }
        return num;
    }
}
