import java.util.*;

public class _49_groupAnagrams {
    //49. 字母异位词分组
    //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    //
    //字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
    //
    //
    //
    //示例 1:
    //
    //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static void main(String[] args) {
        System.out.println(groupAnagrams1(new String[]{"abc", "cba"}));
    }

    //字母异位词排序之后相同
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> stringList = map.getOrDefault(key, new ArrayList<>());
            stringList.add(str);
            map.put(key,stringList);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs.length <= 1) {
            List<String> strings = Arrays.asList(strs);
            lists.add(strings);
            return lists;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(strs[0]);
        lists.add(list);
        check(strs, lists, 1);
        return lists;
    }

    private static void check(String[] strs, List<List<String>> lists, int index) {
        if (index == strs.length) {
            return;
        }
        for (int k = 0; k < lists.size(); k++) {
            List<String> list = lists.get(k);
            String s = list.get(0);
            String s1 = strs[index];
            if (s.length() != s1.length()) {
                continue;
            }
            if ("".equals(s) && "".equals(s1)) {
                list.add(strs[index]);
                check(strs, lists, index + 1);
                return;
            }

            boolean[] s1check = new boolean[s1.length()];
            boolean hint = false;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s1.length(); j++) {
                    if (s.charAt(i) == s1.charAt(j) && !s1check[j]) {
                        s1check[i] = true;
                        if (i == s.length() - 1) {
                            list.add(strs[index]);
                            check(strs, lists, index + 1);
                            return;
                        }
                        hint = true;
                        break;
                    } else if (j == s1.length() - 1) {
                        break;
                    }
                }
                if (!hint) {
                    break;
                }
            }
        }
        List<String> strings = new ArrayList<>();
        strings.add(strs[index]);
        lists.add(strings);
        check(strs, lists, index + 1);
        return;
    }
}
