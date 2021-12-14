/**
 * 最长公共子串
 *
 * @author zhouyao
 * @date 2021/11/30 5:37 下午
 **/
public class _3_LCS_01 {
    public static void main(String[] args) {
        System.out.println(lcs1("acdaccceaaadcafaab", "aacadca"));
        System.out.println(lcs2("acdaccceaaadcafaab", "aacadca"));
    }

    private static int lcs1(String x, String y) {
        //求两个字符串的最长公共子串
        int xlen = x.length();
        int ylen = y.length();
        char[] xArray = x.toCharArray();
        char[] yArray = y.toCharArray();
        int max = 0;
        int xLastIndex = 0;
        int[][] array = new int[xlen + 1][ylen + 1];

        for (int i = 0; i <= xlen; i++) {
            for (int j = 0; j <= ylen; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                    continue;
                }
                if (xArray[i - 1] != yArray[j - 1]) {
                    array[i][j] = 0;
                    continue;
                }
                if (xArray[i - 1] == yArray[j - 1]) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                }
                if (array[i][j] > max) {
                    max = array[i][j];
                    xLastIndex = i;
                }
            }
        }
        System.out.println(x.substring(xLastIndex - max, xLastIndex));
        return max;
    }

    //最长公共子串
    private static int lcs2(String x, String y) {
        char[] xArray = x.toCharArray();
        char[] yArray = y.toCharArray();
        int max = 0;
        //用一个数组保存上一步计算的公共字符串长度
        int[][] tempArray = new int[xArray.length][yArray.length];
        for (int i = 0; i < xArray.length; i++) {
            for (int j = 0; j < yArray.length; j++) {
                if (i == 0 || j == 0) {
                    tempArray[i][j] = xArray[i] == yArray[j] ? 1 : 0;
                } else {
                    if (xArray[i] == yArray[j]) {
                        tempArray[i][j] = tempArray[i - 1][j - 1] + 1;
                    }
                }
                max = Math.max(max, tempArray[i][j]);
            }
        }
        return max;
    }
}
