public class _312_maxCoins {
    //312. 戳气球
    //有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
    //
    //现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
    //
    //求所能获得硬币的最大数量。
    //
    //
    //
    //示例 1：
    //输入：nums = [3,1,5,8]
    //输出：167
    //解释：
    //nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
    //coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
    public static void main(String[] args) {
        _312_maxCoins maxCoins = new _312_maxCoins();
        int i = maxCoins.maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }

    public int maxCoins(int[] nums) {
        if (nums.length<=0){
            return 0;
        }
        int[] aNums = new int[nums.length + 2];
        aNums[0] = 1;
        aNums[aNums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            aNums[i + 1] = nums[i];
        }
        //dp[i][j] 表示在不戳破i,j的情况下，最大分值
        int[][] dp = new int[aNums.length][aNums.length];
        for (int i = aNums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < aNums.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + aNums[i] * aNums[k] * aNums[j]);
                }
            }
        }
        return dp[0][aNums.length-1];
    }
}
