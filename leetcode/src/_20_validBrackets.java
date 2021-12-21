import java.util.Stack;

public class _20_validBrackets {
    //给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
    //
    //有效字符串需满足：
    //
    //左括号必须用相同类型的右括号闭合。
    //左括号必须以正确的顺序闭合。
    //
    //
    //示例 1：
    //
    //输入：s = "()"
    //输出：true
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/valid-parentheses
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(isValid("()[]"));
    }

    private static boolean isValid1(String s) {
        if ((s.length() & 1) != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            }else
            if (s.charAt(i) == '{') {
                stack.push( '}');
            }else
            if (s.charAt(i) == '[') {
                stack.push( ']');
            }else if (stack.empty() || stack.pop() !=s.charAt(i)){
                return false;
            }
        }
        return stack.empty();
    }


    private static boolean isValid(String s) {
        if ((s.length() & 1) != 0) {
            return false;
        }
        String openBrackets = "([{";
        String closeBrackets = ")]}";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (openBrackets.contains(((Character) c).toString())) {
                stack.push(c);
            } else if (closeBrackets.contains(((Character) c).toString())) {
                if (stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
                if (!match(pop,c)){
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean match(char left, char right) {
        if (left == '(') {
            return right == ')';
        }
        if (left == '{') {
            return right == '}';
        }
        if (left == '[') {
            return right == ']';
        }
        return false;
    }
}
