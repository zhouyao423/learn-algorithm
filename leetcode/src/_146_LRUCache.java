import java.util.HashMap;
import java.util.Map;

public class _146_LRUCache {
    //146. LRU 缓存  https://leetcode-cn.com/problems/lru-cache/
    //请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
    //实现 LRUCache 类：
    //LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
    //int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    //void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
    //函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
    //
    //
    //
    //示例：
    //
    //输入
    //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    //输出
    //[null, null, null, 1, null, -1, null, -1, 3, 4]
    //
    //解释
    //LRUCache lRUCache = new LRUCache(2);
    //lRUCache.put(1, 1); // 缓存是 {1=1}
    //lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    //lRUCache.get(1);    // 返回 1
    //lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    //lRUCache.get(2);    // 返回 -1 (未找到)
    //lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    //lRUCache.get(1);    // 返回 -1 (未找到)
    //lRUCache.get(3);    // 返回 3
    //lRUCache.get(4);    // 返回 4
    //
    //
    //提示：
    //
    //1 <= capacity <= 3000
    //0 <= key <= 10000
    //0 <= value <= 105
    //最多调用 2 * 105 次 get 和 put
    //["LRUCache","get","get","put","get","put","put","put","put","get","put"]
    //[[1],[6],[8],[12,1],[2],[15,11],[5,2],[1,15],[4,2],[5],[15,15]]
    public static void main(String[] args) {
        _146_LRUCache lruCache = new _146_LRUCache(1);
        lruCache.get(1);
        lruCache.get(6);
        lruCache.get(8);
        lruCache.put(12,1);
        lruCache.get(2);
        lruCache.put(15,11);
        lruCache.put(5,2);
        lruCache.get(15);
        lruCache.get(14);
        lruCache.get(13);
    }

    private Map<Integer, LinkNode> map;
    private int capacity;
    private LinkNode head;
    private LinkNode tail;

    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        LinkNode linkNode = map.get(key);
        if (linkNode == null) {
            return -1;
        }
        if (linkNode == head) {
            return linkNode.val;
        }
        moveNodeToHead(linkNode);
        return linkNode.val;
    }

    private void moveNodeToHead(LinkNode linkNode) {
        LinkNode pre = linkNode.pre;
        LinkNode next = linkNode.next;
        if (pre != null) {
            pre.next = next;
            if(linkNode == tail){
                tail = pre;
            }
        }
        if (next != null) {
            next.pre = pre;
        }
        linkNode.pre = null;
        linkNode.next = head;
        head.pre = linkNode;
        head = linkNode;

    }

    public void put(int key, int value) {
        LinkNode linkNode = map.get(key);
        if (linkNode == null) {
            if (map.size() == capacity) {
                int removeKey = removeLast();
                map.remove(removeKey);
            }
            LinkNode newNode = new LinkNode(key, value);
            map.put(key, newNode);
            newNode.next = head;
            if (head == null){
                head = newNode;
                tail = newNode;
            }else{
                head.pre = newNode;
                head = newNode;
            }
            return;
        }
        linkNode.setVal(value);
        if (linkNode!=head){
            moveNodeToHead(linkNode);
        }
    }

    private int  removeLast(){
        if (tail ==head){

        }
        if (tail.pre !=null){
            tail.pre.next = null;
        }
        LinkNode linkNode = tail;
        tail = tail.pre;
        linkNode.pre  = null;
        if (linkNode == head){
            head = null;
        }
        return linkNode.key;
    }

    class LinkNode {
        public LinkNode(int key,int value) {
            this.key = key;
            this.val = value;
        }

        public LinkNode pre;
        public LinkNode next;
        private int val;
        private int key;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }
}
