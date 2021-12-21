import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _22_generateParenthesis {
    //数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 3
    //输出：["((()))","(()())","(())()","()(())","()()()"]
    //示例 2：
    //
    //输入：n = 1
    //输出：["()"]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/generate-parentheses
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }

    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        generate(list, new StringBuffer(), 0, 0, n);
        return list;
    }

    private static void generate(List<String> list, StringBuffer sb, int openSize, int closeSize, int n) {

        if (sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }
        if (openSize < n) {
            sb.append('(');
            generate(list, sb, openSize + 1, closeSize, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (openSize > closeSize) {
            sb.append(')');
            generate(list, sb, openSize, closeSize + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.insert(0, '(');
            sb.append(')');
        }
        String string = sb.toString();
        result.add(string);
        move(result, string, n - 1, n);
        return new ArrayList<>(result);
    }

    private static void move(Set<String> result, String str, int index, int n) {
        if (n - 1 == 0) {
            return;
        }
        StringBuffer sb = new StringBuffer(str);
        char c = sb.charAt(index);
        sb.setCharAt(index, sb.charAt(index + 1));
        sb.setCharAt(index + 1, c);
        String newSb = sb.toString();
        result.add(newSb);
        move(result, newSb, n - 2, n - 1);
        if (index - 1 > 0) {
            move(result, newSb, n + index, n - 1);
        }
    }

}
