public class _494_findTargetSumWays {
    //494. 目标和
    //给你一个整数数组 nums 和一个整数 target 。
    //
    //向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
    //
    //例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
    //返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, nums.length - 1, target);
    }

    private int find(int[] nums, int i, int target) {
        if (i == 0) {
          return  (nums[0] == target?1:0) + (nums[0] == -target?1:0);
        }
        if (i<0){
            return 0;
        }
        return find(nums, i - 1, target - nums[i]) + find(nums, i - 1, target + nums[i]);
    }
    public int findTargetSumWays1(int[] nums, int target) {
        int max = target;
        for (int i = 0; i < nums.length; i++) {
            max +=nums[i];
        }
        int[][] dp = new int[nums.length][max];
        dp[0][nums[0]] = 1;


        return dp[nums.length-1][target];
    }

}
