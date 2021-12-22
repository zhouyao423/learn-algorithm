import java.util.Stack;

public class _32_longestValidParentheses {
    //给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "(()"
    //输出：2
    //解释：最长有效括号子串是 "()"
    //示例 2：
    //
    //输入：s = ")()())"
    //输出：4
    //解释：最长有效括号子串是 "()()"
    //示例 3：
    //
    //输入：s = ""
    //输出：0
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/longest-valid-parentheses
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()))())("));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int count = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (stack.empty()) {
                    startIndex = i;
                    stack.push(-1);
                }
                stack.push(i);
                count++;
            } else {
                if (!stack.empty()) {
                    Integer pop = stack.pop();
                    if (pop >= 0) {
                        count++;
                    } else {
                        max = Math.max(max, count);
                        count = 0;
                    }
                }
            }
        }
        if (stack.size() == 1) {
            max = Math.max(max, count);
            return max;
        }
        int last = s.length() - 1;
        while (stack.size() > 1) {
            int pop = stack.pop();
            if (last - pop >= 2) {
                max = Math.max(max, (last - pop)/2*2);
            }
            last = pop;
            if (stack.size() == 1) {
                max = Math.max(max, last - startIndex );
            }
        }
        return max;
    }

}
