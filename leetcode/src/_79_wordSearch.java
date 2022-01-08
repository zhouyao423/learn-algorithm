public class _79_wordSearch {
    //79. 单词搜索 https://leetcode-cn.com/problems/word-search/
    //给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    //
    //单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    //示例 1：
    //
    //
    //输入：board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}}, word = "ABCCED"
    //输出：true
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (ex(board, word, 0, i, j, 0, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean ex(char[][] board, String word, int index, int x, int y, int up, int left, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (x + up < 0 || x + up >= board.length || y + left < 0 || y + left >= board[0].length || visited[x + up][y + left]) {
            return false;
        }
        x = x + up;
        y = y + left;

        boolean find = false;
        //没找到了
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        visited[x][y] = true;
        if (up >= 0) {
            find = ex(board, word, index + 1, x, y, 1, 0, visited);
        }
        if (up <= 0 && !find) {
            find = ex(board, word, index + 1, x, y, -1, 0, visited);
        }
        if (left >= 0 && !find) {
            find = ex(board, word, index + 1, x, y, 0, 1, visited);
        }
        if (left <= 0 && !find) {
           find = ex(board, word, index + 1, x, y, 0, -1, visited);
        }
        if (find) {
            return true;
        } else {
            //回退
            visited[x][y] = false;
            return false;
        }
    }

}
