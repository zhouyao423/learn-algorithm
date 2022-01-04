public class _64_minPathSum {
    //64. 最小路径和
    //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    //示例 1：
    //
    //
    //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
    //输出：7
    //解释：因为路径 1→3→1→1→1 的总和最小。
    public static void main(String[] args) {
        System.out.println(minPathSum1(new int[][]{{1, 2, 3}, {4, 5, 5}}));
    }


    public static int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =Math.min(dp[i][j - 1],dp[i - 1][j])  + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int minPathSum(int[][] grid) {
        sum(grid, 0, 0, 0);
        return min;
    }

    private static int min = -1;

    private static void sum(int[][] grid, int left, int right, int sum) {
        if (left > grid.length - 1 || right > grid[0].length - 1) {
            return;
        }
        sum += grid[left][right];
        if (min > 0 && sum > min) {
            return;
        }
        if (left == grid.length - 1 && right == grid[0].length - 1) {
            min = sum;
        }
        if (left == grid.length - 1) {
            sum(grid, left, right + 1, sum);
        }
        if (right == grid[0].length - 1) {
            sum(grid, left + 1, right, sum);
        }
        sum(grid, left, right + 1, sum);
        sum(grid, left + 1, right, sum);
    }
}
