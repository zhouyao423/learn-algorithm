import java.util.*;

public class _102_levelOrder {
    //102. 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [3,9,20,null,null,15,7]
    //输出：[[3],[9,20],[15,7]]
    public static void main(String[] args) {

    }
    //dfs
    public  List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return  list;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        queue1.add(root);
        while (!queue1.isEmpty()){
            int size = queue1.size();
            List<Integer> list1= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue1.poll();
                list1.add(poll.val);
                if (poll.left != null) {
                    queue1.add(poll.left);
                }
                if (poll.right != null) {
                    queue1.add(poll.right);
                }
            }
            list.add(list1);
        }
        return list;
    }


        public  List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root==null){
            return  list;
        }
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            List<Integer> list1 = nextLevel(queue2, queue1);
            if (!list1.isEmpty()){
                list.add(list1);
            }
            List<Integer> list2 = nextLevel(queue1, queue2);
            if (!list2.isEmpty()){
                list.add(list2);
            }
        }
        return list;
    }

    private  List<Integer> nextLevel(Queue<TreeNode> queue1, Queue<TreeNode> queue2) {
        List<Integer> list1 = new ArrayList<>();
        while (!queue2.isEmpty()) {
            TreeNode poll = queue2.poll();
            list1.add(poll.val);
            if (poll.left != null) {
                queue1.add(poll.left);
            }
            if (poll.right != null) {
                queue1.add(poll.right);
            }
        }
        return list1;
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
