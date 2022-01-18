public class _226_invertTree {
    //翻转一棵二叉树。 https://leetcode-cn.com/problems/invert-binary-tree/

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    private void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        reverse(root.left);
        reverse(root.right);
        TreeNode temp = root.left;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
