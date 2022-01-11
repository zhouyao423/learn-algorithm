public class _124_maxPathSum {
    //124. 二叉树中的最大路径和 https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
    //路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    //
    //路径和 是路径中各节点值的总和。
    //
    //给你一个二叉树的根节点 root ，返回其 最大路径和 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [1,2,3]
    //输出：6
    //解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        maxGen(root);
        return max;
    }

    private static int max = Integer.MIN_VALUE;

    private static int maxGen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGen = Math.max(maxGen(root.left), 0);
        int rightGen = Math.max(maxGen(root.right), 0);
        int path = root.val + leftGen + rightGen;
        max = Math.max(max, path);
        root.val = root.val + Math.max(leftGen, rightGen);
        return root.val;
    }
}
