public class _148_sortList {
    //148. 排序链表 https://leetcode-cn.com/problems/sort-list/
    //给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：head = [4,2,1,3]
    //输出：[1,2,3,4]
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        sortList(listNode);
    }

    public static ListNode sortList(ListNode head) {

        return sort(head,null);
    }

    private static ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail&&fast!=null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode next = mid.next;
        ListNode left = sort(head, mid);
        ListNode right = sort(next, tail);
        //合并两个链表
        return mergeLinkList(left,right);
    }

    private static ListNode mergeLinkList(ListNode node1, ListNode node2) {
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return  node1;
        }
        ListNode head = node1.val < node2.val ? node1 : node2;
        if (head == node1){
            node1 = node1.next;
        }else {
            node2 = node2.next;
        }
        ListNode tempNode = head;
        while (node1 != null || node2 != null) {
            if (node1==null){
                tempNode.next = node2;
                break;
            }
            if (node2 == null){
                tempNode.next = node1;
                break;
            }
            if (node1.val<node2.val){
                tempNode.next = node1;
                node1=node1.next;
            }else {
                tempNode.next = node2;
                node2 = node2.next;
            }
            tempNode = tempNode.next;

        }
        return head;
    }
}
