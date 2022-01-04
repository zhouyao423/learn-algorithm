public class _70_climbStairs {
    //70. 爬楼梯
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //
    //注意：给定 n 是一个正整数。
    //示例 1：
    //
    //输入： 2
    //输出： 2
    //解释： 有两种方法可以爬到楼顶。
    //1.  1 阶 + 1 阶
    //2.  2 阶
    public static void main(String[] args) {
        System.out.println(climbStairs1(100));
    }


    public static int climbStairs1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n - 1];
    }

    public static int climbStairs(int n) {
        dfs(n, 0, 0);
        return count;
    }

    private static int count = 0;

    private static void dfs(int n, int current, int step) {
        current += step;
        if (current == n) {
            count++;
            return;
        }
        if (current > n) {
            return;
        }
        dfs(n, current, 1);
        dfs(n, current, 2);
    }
}
