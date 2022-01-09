import java.util.Queue;

public class _105_buildTree {
    //105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    //给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
    //
    //
    //
    //示例 1:
    //
    //
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{1,2},new int[]{2,1}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序确定根节点  中序确定左右子树
        int[] preArea = new int[]{0, preorder.length - 1};
        int[] inArea = new int[]{0, inorder.length - 1};
        return getNode(preorder, inorder, preArea, inArea);
    }

    private static TreeNode getNode(int[] preorder, int[] inorder, int[] preArea, int[] inArea) {
        int inStart = inArea[0];
        int inEnd = inArea[1];
        if (inStart == inEnd) {
            return new TreeNode(inorder[inStart]);
        }

        int preStart = preArea[0];
        int preEnd = preArea[1];
        if (inStart < 0 || preEnd >= preorder.length || inStart>inEnd || preStart>preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int leftTreeSize = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] != rootVal) {
                leftTreeSize++;
            } else {
                break;
            }
        }
        inArea[1] = inStart + leftTreeSize - 1;
        preArea[0] = preStart + 1;
        preArea[1] = preStart + leftTreeSize;

        root.left = getNode(preorder, inorder, preArea, inArea);
        preArea[0] = preArea[1] + 1;
        preArea[1] = preEnd;
        inArea[0] = inStart + leftTreeSize + 1;
        inArea[1] = inEnd;
        root.right = getNode(preorder, inorder, preArea, inArea);
        return root;
    }

    protected static class TreeNode {
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
