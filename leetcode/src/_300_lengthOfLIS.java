public class _300_lengthOfLIS {
    //300. 最长递增子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    //
    //
    //示例 1：
    //
    //输入：nums = [10,9,2,5,3,7,101,18]
    //输出：4
    //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
