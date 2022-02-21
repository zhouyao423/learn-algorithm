public class _416_canPartition {
    //416. 分割等和子集
    //给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,5,11,5]
    //输出：true
    //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max,num);
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        if (max>sum){
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][sum + 1];
    }

    private boolean dfs(int[] nums, int sum, int i) {
        if (nums[i] > sum) {
            return false;
        }
        if (sum == nums[i]) {
            return true;
        }
        sum = sum - nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            if (sum == nums[j]) {
                return true;
            }
            if (sum < nums[j]) {
                continue;
            }
            if (dfs(nums, sum, j)) {
                return true;
            }
        }

        return false;
    }
}
