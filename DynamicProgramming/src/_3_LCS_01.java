/**
 * 最长公共子串
 * @author zhouyao
 * @date 2021/11/30 5:37 下午
 **/
public class _3_LCS_01 {
    public static void main(String[] args) {
        System.out.println(lcs1("acdaccceaaadcafaab","aacada"));
    }

    private static int lcs1(String x,String y){
        //求两个字符串的最长公共子串
        int xlen = x.length();
        int ylen = y.length();
        char[] xArray = x.toCharArray();
        char[] yArray = y.toCharArray();
        int max = 0;
        int xLastIndex = 0;
        int[][] array = new int[xlen+1][ylen+1];

        for (int i = 0; i <=xlen ; i++) {
            for (int j = 0; j <= ylen ; j++) {
                if (i==0 || j==0){
                    array[i][j] = 0;
                    continue;
                }
                if (xArray[i-1] != yArray[j-1]){
                    array[i][j] = 0;
                    continue;
                }
                if (xArray[i-1] == yArray[j-1]){
                    array[i][j] = array[i-1][j-1] +1;
                }
                if (array[i][j] >max){
                    max = array[i][j];
                    xLastIndex = i;
                }
            }
        }
        System.out.println(x.substring(xLastIndex-max,xLastIndex));
        return max;
    }
}
