public class _23_mergeKLists {
    //23. 合并K个升序链表
    //给你一个链表数组，每个链表都已经按升序排列。
    //
    //请你将所有链表合并到一个升序链表中，返回合并后的链表。
    //
    //
    //
    //示例 1：
    //
    //输入：lists = [[1,4,5],[1,3,4],[2,6]]
    //输出：[1,1,2,3,4,4,5,6]
    //解释：链表数组如下：
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //将它们合并到一个有序链表中得到。
    //1->1->2->3->4->4->5->6
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, null);
        listNode.next = new ListNode(4, null);
        listNode.next.next = new ListNode(5, null);

        ListNode listNode1 = new ListNode(1, null);
        listNode.next = new ListNode(3, null);
        listNode.next.next = new ListNode(4, null);

        ListNode listNode2 = new ListNode(2, null);
        listNode.next = new ListNode(6, null);
        System.out.println(mergeKLists1(new ListNode[]{listNode, listNode1, listNode2}));
    }

    //使用分治法优化
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeLists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] lists1 = new ListNode[mid];
        ListNode[] lists2 = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            lists1[i] = lists[i];
        }
        for (int i = 0; i < lists.length - mid; i++) {
            lists2[i] = lists[i + mid];
        }
        return mergeLists(mergeKLists1(lists1),mergeKLists1(lists2));
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode node = mergeLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            node = mergeLists(node, lists[i]);
        }
        return node;
    }

    private static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            head.next = mergeLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeLists(list1, list2.next);
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
