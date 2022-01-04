public class _62_uniquePaths {
    //62. 不同路径
    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    //
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    //
    //问总共有多少条不同的路径？

    //示例 1：
    //输入：m = 3, n = 7
    //输出：28
    public static void main(String[] args) {
        System.out.println(uniquePaths1(3, 7));
    }
    //动归
    public static int uniquePaths1(int m, int n) {
        if (m==1 || n ==1){
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }



    public static int uniquePaths(int m, int n) {
        walk(m, n, 0, 0);
        return count;
    }

    private static int count = 0;

    private static void walk(int m, int n, int left, int right) {
        if (m - 1 == left && n - 1 == right) {
            count++;
            return;
        }
        if (left > m - 1 || right > n - 1) {
            return;
        }
        if (left == m - 1) {
            walk(m, n, left + 1, right);
        }
        if (right == n - 1) {
            walk(m, n, left, right + 1);
        }
        walk(m, n, left + 1, right);
        walk(m, n, left, right + 1);
    }
}
