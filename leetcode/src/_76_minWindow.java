import java.util.*;

public class _76_minWindow {
    //76. 最小覆盖子串
    //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //注意：
    //
    //对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //如果 s 中存在这样的子串，我们保证它是唯一的答案。
    //
    //
    //示例 1：
    //
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = t.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        char[] sCharArray = s.toCharArray();
        int left = 0;
        Map<Character, Integer> sMap = new HashMap<>();

        int right = left-1;
        int leftAns = left;
        int rightAns = left-1;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            right++;
            if (right < s.length() && map.containsKey(sCharArray[right])) {
                sMap.put(sCharArray[right], sMap.getOrDefault(sCharArray[right], 0) + 1);
            }
            //左指针移动
            while (contains(sMap, map) && left <= right) {
                char sLeftChar = sCharArray[left];
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    leftAns = left;
                    rightAns = right;
                }
                if (sMap.containsKey(sLeftChar)) {
                    sMap.put(sLeftChar, sMap.get(sLeftChar) - 1);
                }
                left++;
            }
        }
        return left == -1 ? "" :s.substring(leftAns, rightAns + 1);
    }


    private static boolean contains(Map<Character, Integer> sMap, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
            Character key = mapEntry.getKey();
            Integer value = mapEntry.getValue();
            if (sMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
