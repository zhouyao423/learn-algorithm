public class _160_getIntersectionNode {
    //160. 相交链表 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    //
    //图示两个链表在节点 c1 开始相交：
    //
    //
    //
    //题目数据 保证 整个链式结构中不存在环。
    //
    //注意，函数返回结果后，链表必须 保持其原始结构 。
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALen = 0;
        int headBLen = 0;
        ListNode temp = headA;
        while (temp != null) {
            headALen++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            headBLen++;
            temp = temp.next;
        }
        while (headALen > headBLen) {
            headA = headA.next;
            headALen--;
        }
        while (headBLen > headALen) {
            headB = headB.next;
            headBLen--;
        }

        while (headA != headB) {
            headA = headB.next;
            headB = headB.next;
            if (headA == headB){
                return headA;
            }
        }
        return null;
    }
}
