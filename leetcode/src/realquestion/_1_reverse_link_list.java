package realquestion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转链表
 * @author zhouyao
 * @date 2022/3/25 5:42 PM
 **/
public class _1_reverse_link_list {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null)))));
        _1_reverse_link_list l = new _1_reverse_link_list();
        ListNode reverse = l.reverse1(listNode);
        while (reverse!=null){
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    /**
     * 递推
     * @param node
     * @return
     */
    public ListNode reverse1(ListNode node){
        Deque<ListNode> stack = new ArrayDeque<>();
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        ListNode peek = stack.peek();
        while (!stack.isEmpty()){
            ListNode pop = stack.pop();
            ListNode p = stack.peek();
            pop.next = p;
        }

        return peek;
    }


        /**
         * 递归
         * @param node
         * @return
         */
    public ListNode reverse(ListNode node){
        dfs(node);
        node.next = null;
        return tail;
    }
    ListNode tail = null;
    private ListNode dfs(ListNode node) {
        if (node == null){
            return null;
        }
        ListNode nextNode = dfs(node.next);
        if (nextNode!=null){
            nextNode.next = node;
        }else {
            tail = node;
        }
        return node;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
