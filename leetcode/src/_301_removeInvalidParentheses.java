import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class _301_removeInvalidParentheses {
    //301. 删除无效的括号
    //给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
    //
    //返回所有可能的结果。答案可以按 任意顺序 返回。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "()())()"
    //输出：["(())()","()()()"]
    public static void main(String[] args) {
        _301_removeInvalidParentheses removeInvalidParentheses = new _301_removeInvalidParentheses();
        List<String> strings = removeInvalidParentheses.removeInvalidParentheses1(")())()");
        System.out.println(strings);
    }

    //深度优先搜索
    public List<String> removeInvalidParentheses(String s) {
        //先计算出要删除的左括号和右括号的数量
        char[] chars = s.toCharArray();
        int lremeve = 0;
        int rremove = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                lremeve++;
            }
            if (chars[i] == ')') {
                if (lremeve == 0) {
                    rremove++;
                } else {
                    lremeve--;
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        dfs(s, 0, set, lremeve, rremove);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int startIndex, HashSet<String> set, int lremeve, int rremove) {
        if (lremeve < 0 || rremove < 0 || lremeve + rremove > s.length()) {
            return;
        }
        if (lremeve == 0 && rremove == 0) {
            if (isValid(s)) {
                set.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //遇到相同的括号跳过
            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (lremeve + rremove > s.length() - i) {
                return;
            }
            //尝试移除左括号
            if (lremeve > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), startIndex, set, lremeve - 1, rremove);
            }
            if (rremove > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), startIndex, set, lremeve, rremove - 1);
            }
        }
    }

    private boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int leftCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                leftCount++;
            }
            if (chars[i] == ')') {
                if (leftCount == 0) {
                    return false;
                }
                leftCount--;
            }
        }
        return leftCount == 0;
    }

    //广度优先搜索
    public List<String> removeInvalidParentheses1(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> resultSet = new HashSet<>();
        set.add(s);
        while (!set.isEmpty()) {
            for (String s1 : set) {
                if (isValid(s1)) {
                    resultSet.add(s1);
                }
            }
            if (!resultSet.isEmpty()) {
                return new ArrayList<>(resultSet);
            }
            HashSet<String> newSet = new HashSet<>();
            for (String s1 : set) {
                for (int i = 0; i < s1.length(); i++) {
                    if (i > 0 && s1.charAt(i) == s1.charAt(i - 1)) {
                        continue;
                    }
                    if (s1.charAt(i) == '(' || s1.charAt(i) == ')') {
                        newSet.add(s1.substring(0, i) + s1.substring(i + 1));
                    }
                }
            }

            set = newSet;
        }
        return new ArrayList<>();
    }

}
