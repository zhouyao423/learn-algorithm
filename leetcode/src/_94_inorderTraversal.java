import org.omg.CORBA.IRObject;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _94_inorderTraversal {
    //94. 二叉树的中序遍历
    //给定一个二叉树的根节点 root ，返回它的 中序 遍历。
    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty()){
            while (root.left!=null){
                stack.push(root);
                root = root.left;
            }
            list.add(stack.pop().val);
            root = stack.peek().right;
        }
        return list;
    }


        public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        mid(list,root);
        return list;
    }

    private static void mid(List<Integer> list,TreeNode node){
        if (node == null){
            return ;
        }
        mid(list,node.left);
        list.add(node.val);
        mid(list,node.right);
    }

    protected class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
