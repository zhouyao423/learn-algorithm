public class _98_isValidBST {
    //98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    //
    //有效 二叉搜索树定义如下：
    //
    //节点的左子树只包含 小于 当前节点的数。
    //节点的右子树只包含 大于 当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。
    //
    //
    //示例 1：
    //
    //
    //输入：root = [2,1,3]
    //输出：true
    public static void main(String[] args) {

    }
    private static long preval = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        boolean left = isValidBST(root.left);
        if (root.val<= preval){
            return false;
        }
        preval = root.val;
        return left && isValidBST(root.right);
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
