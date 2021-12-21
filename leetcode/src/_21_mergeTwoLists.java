public class _21_mergeTwoLists {
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //示例 1：
    //
    //
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //示例 2：
    //
    //输入：l1 = [], l2 = []
    //输出：[]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val > list2.val) {
            head = list2;
            head.next = mergeTwoLists1(list1, list2.next);
        } else {
            head = list1;
            head.next = mergeTwoLists1(list1.next, list2);
        }

        return head;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            return forList(list1, list2);
        }
        return forList(list2, list1);
    }

    private static ListNode forList(ListNode list1, ListNode list2) {
        ListNode head = list1;
        ListNode temp = list1;
        while (list1 != null) {
            if (list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
                if (list2 != null && list2.val < list1.val) {
                    temp.next.next = list2;
                } else {
                    temp.next.next = list1;
                }

                forList(list2, list1);
                break;
            }
            if (list1 == null) {
                temp.next = list2.next;
                list2.next = temp;
            }
        }
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
