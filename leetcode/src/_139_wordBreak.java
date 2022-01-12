import java.lang.reflect.WildcardType;
import java.util.*;

public class _139_wordBreak {
    //139. 单词拆分 https://leetcode-cn.com/problems/word-break/
    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
    //
    //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    //
    //
    //
    //示例 1：
    //
    //输入: s = "leetcode", wordDict = ["leet", "code"]
    //输出: true
    //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    public static void main(String[] args) {
        List<String> wordDic = new ArrayList<>();
        wordDic.add("car");
        wordDic.add("ca");
        wordDic.add("rs");
        System.out.println(wordBreak("cars", wordDic));
        System.out.println(Arrays.toString("".split("1")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        return dfs(s, 0, wordDict, visited);
    }

    private static boolean dfs(String s, int index, List<String> wordDict, boolean[] visited) {
        if (index == s.length()) {
            return true;
        }
        for (String s1 : wordDict) {
            int subStartIndex = s1.length() + index;
            if (!visited[index] && subStartIndex <= s.length()) {
                String substring = s.substring(index, subStartIndex);
                if (substring.equalsIgnoreCase(s1)) {
                    if (dfs(s, subStartIndex, wordDict, visited)) {
                        return true;
                    }
                    visited[subStartIndex] = true;
                }
            }
        }
        return false;
    }

    public static boolean bfs(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] visited = new boolean[s.length()];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == length) {
                return true;
            }
            if (visited[poll]){
                continue;
            }
            visited[poll] = true;
            for (int i = poll + 1; i <= length; i++) {
                if (set.contains(s.substring(poll, poll + i))) {
                    queue.push(poll + i);

                }
            }
        }
        return false;
    }
}
