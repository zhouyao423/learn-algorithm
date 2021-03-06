public class _142_detectCycle {
    //142. 环形链表 II https://leetcode-cn.com/problems/linked-list-cycle-ii/
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    //
    //不允许修改 链表。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：head = [3,2,0,-4], pos = 1
    //输出：返回索引为 1 的链表节点
    //解释：链表中有一个环，其尾部连接到第二个节点。
    public static void main(String[] args) {

    }
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        ListNode temp = head;
        while (slow!=null&&quick!=null){
            if (slow==quick){
                while (temp!=slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
            slow = slow.next;
            if (quick.next!=null){
                quick = quick.next.next;
            }else {
                return null;
            }
        }
        return null;
    }
}
