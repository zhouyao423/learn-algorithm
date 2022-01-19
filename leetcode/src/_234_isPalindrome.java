public class _234_isPalindrome {
    //回文链表
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        isPalindrome(listNode);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode point = head;
        for (int i = 1; i <= (length - 1) / 2; i++) {
            point = point.next;
        }
        reverse(point);
        int count = 0;
        while (count<=(length-1)/2){
            if (head.val!=tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
            count ++;
        }
        return true;
    }
    static ListNode tail = null;
    //翻转链表
    private static ListNode reverse(ListNode node){
        if (node == null){
            return null;
        }
        ListNode pre = reverse(node.next);
        if (pre!=null){
            pre.next = node;
        }else {
            tail = node;
        }
        return node;
    }
}
