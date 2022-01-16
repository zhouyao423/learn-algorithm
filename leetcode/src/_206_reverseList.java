import java.util.ArrayDeque;
import java.util.Deque;

public class _206_reverseList {
    //206. 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5]
    //输出：[5,4,3,2,1]
    public static void main(String[] args) {

    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        while (!stack.isEmpty()){
            if (stack.size() == size){
                tail = stack.peek();
            }
            ListNode tail = stack.pop();
            tail.next = stack.peek();
        }
        return tail;
    }


    private ListNode tail;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        head.next = null;
        return tail;
    }

    private void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        head = head.next;
        if (head == null) {
            tail = temp;
        }
        dfs(head);
        if (head != null) {
            head.next = temp;
        }
    }
}
