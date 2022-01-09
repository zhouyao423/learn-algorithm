import java.util.ArrayDeque;
import java.util.Deque;

public class _104_maxDepth {
    //104. 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
    //给定一个二叉树，找出其最大深度。
    //
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]，
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null){
            return depth;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
        }
        return depth;
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

        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
