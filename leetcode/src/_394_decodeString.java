import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _394_decodeString {
    //394. 字符串解码
    //给定一个经过编码的字符串，返回它解码后的字符串。
    //
    //编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    //
    //你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    //
    //此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "3[a]2[bc]"
    //输出："aaabcbc"
    public static void main(String[] args) {
        System.out.println(decodeString1("3[a10[bc]]"));
    }

    static Deque<Integer>  stack = new ArrayDeque<>();
    static Deque<Integer> countStack = new ArrayDeque<>();

    public static String decodeString1(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                i = push(s, chars, i);
                for (int j = i + 1; j < chars.length; j++) {
                    if (Character.isDigit(chars[j])) {
                        j= push(s,chars,j);
                    } else if (chars[j] == ']') {
                        Integer pop = stack.pop();
                        int count = countStack.pop();
                        StringBuilder newSb = new StringBuilder();
                        String substring = s.substring(pop, j);
                        for (int k = 0; k < count; k++) {
                            newSb.append(substring);
                        }
                        int length = String.valueOf(count).length();
                        return decodeString1(s.substring(0, pop - 1-length) + newSb + s.substring(j + 1));
                    }
                }
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    private static  int push(String s, char[] chars, int i) {
        for (int j = i + 1; j < chars.length; j++) {
            if (!Character.isDigit(chars[j])) {
                String substring = s.substring(i, j);
                countStack.push(Integer.parseInt(substring));
                stack.push(j + 1);
                return j;
            }
        }
        return 0;
    }

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                char timesChar = chars[i];
                int times = Integer.parseInt(String.valueOf(timesChar));
                int endIndex = i;
                for (int j = i + 2; j < chars.length; j++) {
                    if (chars[j] == ']') {
                        endIndex = j;
                        break;
                    }
                }
                String substring = s.substring(i + 2, endIndex);
                for (int j = 0; j < times; j++) {
                    sb.append(substring);
                }
                i = endIndex + 1;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }


}
