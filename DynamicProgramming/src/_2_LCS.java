/**
 * 最长公共子序列
 *
 * @author zhouyao
 * @date 2021/11/30 5:26 下午
 **/
public class _2_LCS {
    public static void main(String[] args) {
        System.out.println(lcs1("aacab", "aaacaaabd"));
    }

    private static int lcs(String x, String y) {
//        最长公共子序列（Longest Common Subsequence）
//   （1）子序列：一个序列X ＝ x1x2...xn,中任意删除若干项，剩余的序列叫做A的一个子序列。也可以认为是从序列A按原顺序保留任意若干项得到的序列。
//        例如：对序列 1,3,5,4,2,6,8,7来说，序列3,4,8,7 是它的一个子序列。对于一个长度为n的序列，它一共有2^n 个子序列，有(2^n – 1)个非空子序列。
//        在这里需要提醒大家，子序列不是子集，它和原始序列的元素顺序是相关的。
//   （2）公共子序列：如果序列Z既是序列X的子序列，同时也是序列Y的子序列，则称它为序列X和序列Y的公共子序列。空序列是任何两个序列的公共子序列。
//   （3）最长公共子序列：X和Y的公共子序列中长度最长的（包含元素最多的）叫做X和Y的最长公共子序列。
//        这个问题如果用穷举法时间，最终求出最长公共子序列时，时间复杂度是Ο（2mn），是指数级别的复杂度，对于长序列是不适用的。因此我们使用动态规划法来求解。

        char[] xArray = x.toCharArray();
        char[] yArray = y.toCharArray();

        int m = xArray.length;
        int n = yArray.length;
        if (m == 0 || n == 0) {
            return 0;
        }

        if (xArray[m - 1] == yArray[n - 1]) {
            return lcs(x.substring(0, m - 1), y.substring(0, n - 1)) + 1;
        }
        //不相等
        return Math.max(lcs(x.substring(0, m - 1), y), lcs(x, y.substring(0, n - 1)));
    }

    private static int lcs1(String x, String y) {
        //最长公共子序列的

        int[][] array = new int[x.length()+1][y.length()+1];
        int max = 0;

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                } else if (x.charAt(i-1) == y.charAt(j-1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]);
                }
                max = Math.max(max,array[i][j]);
            }
        }
        return max;
    }
}
