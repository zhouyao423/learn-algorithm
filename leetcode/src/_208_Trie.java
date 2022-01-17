import java.util.HashMap;
import java.util.Map;

public class _208_Trie {
    //208. 实现 Trie (前缀树) https://leetcode-cn.com/problems/implement-trie-prefix-tree/
    //Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
    //
    //请你实现 Trie 类：
    //
    //Trie() 初始化前缀树对象。
    //void insert(String word) 向前缀树中插入字符串 word 。
    //boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
    //boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
    //
    //
    //示例：
    //
    //输入
    //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    //输出
    //[null, null, true, false, true, null, true]
    //
    //解释
    //Trie trie = new Trie();
    //trie.insert("apple");
    //trie.search("apple");   // 返回 True
    //trie.search("app");     // 返回 False
    //trie.startsWith("app"); // 返回 True
    //trie.insert("app");
    //trie.search("app");     // 返回 True
    public static void main(String[] args) {
        _208_Trie trie = new _208_Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");
        System.out.println(apple);
    }
    public _208_Trie() {

    }
    private Map<Character,Object> tree = new HashMap<>();
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Map<Character,Object> tempMap = tree;
        for (int i = 0; i < chars.length; i++) {
            Object o = tempMap.get(chars[i]);
            if (o == null){
               tempMap = buildTree(tempMap,chars,i);
                break;
            }
            tempMap = (Map<Character, Object>) o;
        }
        tempMap.put('#','#');
    }
    //从i开始构建trie树
    private Map<Character,Object> buildTree(Map<Character,Object> map,char[] chars,int index){
        for (int i = index; i < chars.length; i++) {
            HashMap<Character, Object> newMap = new HashMap<>();
            map.put(chars[i],newMap);
            map = newMap;
        }
        return map;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Map tempMap = tree;
        for (int i = 0; i < chars.length; i++) {
            Object o = tempMap.get(chars[i]);
            if (o == null) {
                return false;
            }
            tempMap = (Map) o;
        }
        return tempMap.get('#') != null;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Map tempMap = tree;
        for (int i = 0; i < chars.length; i++) {
            Object o = tempMap.get(chars[i]);
            if (o == null){
                return false;
            }
            tempMap = (Map) o;
        }
        return true;
    }
}
