public class _221_maximalSquare {
    //221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
    //在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    //输出：4
    public static void main(String[] args) {

        System.out.println(maximalSquare1(new char[][]    {{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}}
        ));
    }

    public static int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='1'){
                    int count = 1;
                    //扩展
                    while (expend(matrix,i,j,count)){
                        count ++;
                    }
                    maxLen = Math.max(maxLen,count);
                }
            }
        }
        return maxLen*maxLen;
    }


    private static boolean expend(char[][] matrix, int i, int j,int count) {
        int length = matrix.length;
        if (i+count>=length||j+count>=matrix[0].length){
            return false;
        }
        for (int k = 0; k <= count + 1; k++) {
            if (matrix[i+count][j+k]=='0' || matrix[i+k][j+count] == '0'){
                return false;
            }
        }

        return true;
    }

    //正确dp
    public static int maximalSquare2(char[][] matrix){
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    //错
    public static int maximalSquare1(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){
                    if (i-1>=0&&j-1>=0){
                        if (dp[i-1][j-1]==0){
                            dp[i][j] = 1;
                        }else {
                            int upCount = dp[i-1][j-1];
                            boolean plus = true;
                            for (int k = 1; k <= upCount; k++) {
                                if (matrix[i - k][j] == '0' || matrix[i][j - k] == '0') {
                                    if(k>1){
                                        dp[i][j]=2;
                                    }else{
                                        dp[i][j] =1;
                                    }
                                    plus = false;
                                    break;
                                }
                                dp[i][j]=2;
                            }
                            if (plus){
                                dp[i][j] = dp[i-1][j-1]+1;
                            }
                        }
                    }else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[0].length; i1++) {
                max = Math.max(dp[i][i1],max);
            }
        }
        return max*max;
    }
}
