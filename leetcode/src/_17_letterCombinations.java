import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_letterCombinations {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param
     * @return
     */
    public static void main(String[] args) {
        System.out.println(letterCombinations1("23"));
    }

    //穷举所有可能的解，想到使用回溯

    private static List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(phoneMap,digits,0,combinations,new StringBuffer());
        return combinations;
    }

    private static void backtrack(Map<Character, String> phoneMap, String digits, int index, List<String> combinations, StringBuffer sb) {
        if (index == digits.length()){
            combinations.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String s = phoneMap.get(c);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(phoneMap, digits, index + 1, combinations, sb);
            sb = sb.deleteCharAt(sb.length() - 1);
        }
    }


    //
    private static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char a = 'a';
        String[] split = digits.split("");
        int length = 1;
        //存储起始字符和长度
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int d = Integer.parseInt(s);
            int count = 3;
            if (d == 7 || d == 9) {
                count = 4;
            }
            length *= count;
            char start = (char) (a + (d - 2) * 3);
            if (d > 7) {
                start++;
            }
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                list.add((char) (start + i));
            }
            lists.add(list);
        }

        for (int i = 0; i < length; i++) {

        }

        return null;
    }
}
