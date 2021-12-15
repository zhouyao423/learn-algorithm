public class _5_LongestPalindrome {

//    给你一个字符串 s，找到 s 中最长的回文子串。
//    示例 1：
//    输入：s = "babad"
//    输出："bab"
//    解释："aba" 同样是符合题意的答案。
//    示例 2：
//    输入：s = "cbbd"
//    输出："bb"
//    示例 3：
//    输入：s = "a"
//    输出："a"
//    示例 4：
//
//    输入：s = "ac"
//    输出："a"
//    提示：
//
//            1 <= s.length <= 1000
//    s 仅由数字和英文字母（大写和/或小写）组成
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("ccc"));
    }
    //manacher算法
    private static String manacher(String x){

        return null;
    }
    //初始化数组 使用#在字符串中间填充 头尾使用^和$ 终止遍历
    private static char[] init(){

        return null;
    }

    //动态规划
    private static String longestPalindrome1(String x) {
        char[] xArray = x.toCharArray();
        int length = xArray.length;
        int max = 1;
        int maxLeftIdx = 0;
        boolean[][] dp = new boolean[length][length];
        //填充dp表
        for (int i = 0; i < xArray.length; i++) {
            dp[i][i] = true;
            if (i < xArray.length - 1) {
                if (xArray[i] == xArray[i + 1]) {
                    dp[i][i+1] = true;
                    max = 2;
                    maxLeftIdx = i;
                }
            }
        }

        for (int i = 2; i < length; i++) {
            for (int j = 0; j + i < xArray.length; j++) {
                if (dp[j + 1][j + i - 1] && (dp[j][j + i] = xArray[j] == xArray[j + i])) {
                    if (i + 1 > max) {
                        max = i + 1;
                        maxLeftIdx = j;
                    }
                }
            }
        }
        return x.substring(maxLeftIdx, maxLeftIdx + max);
    }

    //暴力解法
    private static String longestPalindrome(String x) {

        int max = 1;
        int lIndex = 0;
        char[] xArray = x.toCharArray();

        for (int i = 0; i < xArray.length; i++) {
            for (int j = i + max; j < xArray.length; j++) {
                if (xArray[i] == xArray[j] && checkPalindrome(xArray, i, j)) {
                    int len = j - i + 1;
                    if (len > max) {
                        max = len;
                        lIndex = i;
                    }
                }
            }
        }
        return x.substring(lIndex, lIndex + max);
    }

    private static boolean checkPalindrome(char[] xArray, int i, int j) {
        while (i < j) {
            if (xArray[i] != xArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
