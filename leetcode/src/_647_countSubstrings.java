public class _647_countSubstrings {
    //647. 回文子串
    //给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
    //
    //回文字符串 是正着读和倒过来读一样的字符串。
    //
    //子字符串 是字符串中的由连续字符组成的一个序列。
    //
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
    public int countSubstrings(String s) {
        int length = s.length();
        int[][] dp = new int[length+1][length+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (j - i <= 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + (check(s, i, j) ? 1 : 0);
                }else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1] + (check(s, i, j) ? 1 : 0);
                }
            }
        }

        return dp[0][length - 1];
    }

    public boolean check(String s, int start, int end) {

        while (end > start) {
            if (s.charAt(end) == s.charAt(start)) {
                end--;
                start++;
            } else {
                return false;
            }
        }
        return true;
    }
}
