public class _200_numIslands {
    //200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
    //给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    //
    //岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    //
    //此外，你可以假设该网格的四条边均被水包围。
    //
    //
    //
    //示例 1：
    //
    //输入：grid = [
    //  ["1","1","1","1","0"],
    //  ["1","1","0","1","0"],
    //  ["1","1","0","0","0"],
    //  ["0","0","0","0","0"]
    //]
    //输出：1
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1', '1'}}));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    expend(grid, i, j, visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void expend(char[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length) {
            return;
        }
        if (j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            visited[i][j] = true;
        } else {
            return;
        }
        int[][] forward = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] ints : forward) {
            int i1 = ints[0];
            int j1 = ints[1];
            if (i + i1 >= 0 && i + i1 < grid.length && j + j1 >= 0 && j + j1 < grid[0].length && !visited[i + i1][j + j1]) {
                expend(grid, i + i1, j + j1, visited);
            }
        }
    }
}
