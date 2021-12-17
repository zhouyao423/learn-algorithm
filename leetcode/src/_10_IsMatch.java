public class _10_IsMatch {

    //给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
    //
    //'.' 匹配任意单个字符
    //'*' 匹配零个或多个前面的那一个元素
    //所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/regular-expression-matching
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(isMatch1("aaaasdfdfasdfab", ".*."));
    }


    //动态规划求解
    private static boolean isMatch1(String s, String p) {
        //状态定义
        //f(x,y) 表示 s[0到x-1] 匹配 p[0到y-1]
        //状态转移

        //定义dp数组
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {

                if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                //难点在于*
                if (p.charAt(j - 1) == '*') {
                    if (i == 0 || ((s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.'))) {
                        //匹配0个
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    private static boolean charEq(char pChar, char sChar) {
        return pChar == '.' || sChar == pChar;
    }


    public static boolean isMatch(String s, String p) {
        String dot = ".";
        String asterisk = "*";

        if (!p.contains(asterisk)) {
            if (!p.contains(dot)) {
                return s.equals(p);
            }
            //当不包含*号时，两个字符串的长度需要相等
            if (s.length() != p.length()) {
                return false;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
                        return false;
                    }
                }
                return true;
            }
        }

        if (s.length() == 0) {
            //s为空时 *前面只能有一个非*字符

            return matchEmpty(p);
        }
        int sIndex = 0;
        for (int i = 0; i < p.length(); i++) {

            if (p.charAt(i) == '.' || p.charAt(i) == s.charAt(sIndex)) {
                if (sIndex == s.length() - 1) {
                    if (i != p.length() - 1) {
                        //判断p剩余的是否匹配空
                        return matchEmpty(p.substring(i + 1));
                    } else {
                        return true;
                    }
                }
                sIndex++;
                continue;
            }
            if (p.charAt(i) == '*') {
                if (p.charAt(i - 1) == '.') {
                    continue;
                }
                if (p.charAt(i - 1) != s.charAt(sIndex)) {
                    continue;
                }
                while (p.charAt(i - 1) == s.charAt(sIndex) || p.charAt(i - 1) == '.') {
                    if (sIndex == s.length() - 1 && i != p.length() - 1) {
                        //判断p剩余的是否匹配空
                        return matchEmpty(p.substring(i + 1));
                    }
                    sIndex++;
                }


            } else if (p.charAt(i + 1) == '*' && i + 1 < p.length()) {
                i++;
            } else {
                return false;
            }
        }
        return sIndex == s.length();
    }

    private static boolean matchEmpty(String p) {
        if (!p.contains("*")) {
            return false;
        }
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && (i - 2 > 0 && p.charAt(i - 2) != '*')) {
                return false;
            }
        }
        return true;
    }
}
