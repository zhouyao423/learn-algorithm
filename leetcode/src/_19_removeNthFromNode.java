import java.util.ArrayList;
import java.util.List;

public class _19_removeNthFromNode {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     *
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode temp = head;
        ListNode right = head;
        ListNode left = head;
        for (int i = 0; i < n - 1; i++) {
            right = right.next;
        }
        ListNode pre = null;
        while (right.next != null) {
            pre = left;
            left = left.next;
            right = right.next;
        }
        if (pre== null){
            temp = left.next;
        }else{
            pre.next = left.next;
        }
        left.next = null;
        return temp;
    }


    private static ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(head);
        while (head.next != null) {
            head = head.next;
            lists.add(head);
        }
        int x = lists.size() - n - 1;
        if (x == 0) {
            lists.get(0).next = null;
            lists.remove(0);
            return lists.size() > 0 ? lists.get(0) : null;
        }
        if (n == 1) {
            lists.get(lists.size() - 2).next = null;
            return lists.get(0);
        }
        lists.get(x - 1).next = lists.get(x + 1);
        lists.get(x).next = null;
        return head;
    }


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
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
