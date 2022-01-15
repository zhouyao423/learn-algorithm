public class _152_maxProduct {
    //152. 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/
    //给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
    //
    //
    //
    //示例 1:
    //
    //输入: [2,3,-2,4]
    //输出: 6
    //解释: 子数组 [2,3] 有最大乘积 6。
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
    }


    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < length; i++) {
            int tempMax = nums[i] * max;
            int tempMin = nums[i] * min;
            max = Math.max(Math.max(nums[i], tempMax),tempMin);
            min = Math.min(Math.min(nums[i], tempMax),tempMin);
            ans = Math.max(ans,max);
        }
        return ans;
    }

    private static void max(int[] nums, int index, Integer[][] dp) {

    }
}
