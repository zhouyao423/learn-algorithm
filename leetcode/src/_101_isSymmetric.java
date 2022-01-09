import java.util.*;

public class _101_isSymmetric {
    //101. 对称二叉树
    //给你一个二叉树的根节点 root ， 检查它是否轴对称。
    //示例 1：
    //
    //
    //输入：root = [1,2,2,3,4,4,3]
    //输出：true
    public static void main(String[] args) {

    }

    //使用递推
    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        TreeNode root1 = root;
        TreeNode root2 = root;
        while (!(stack1.isEmpty() && stack2.isEmpty()) || (root1 != null && root2 != null)) {
            while (root1 !=null && root2!=null){
                if (root1.val != root2.val){
                    return false;
                }
                stack1.push(root1);
                stack2.push(root2);
                root1 = root1.left;
                root2 = root2.right;
                if ((root1 == null && root2 !=null)||(root1!=null && root2==null)){
                    return false;
                }

            }
            TreeNode pop1 = stack1.pop();
            TreeNode pop2 = stack2.pop();
            root1 = pop1.right;
            root2 = pop2.left;
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return min(root, root);
    }

    private static boolean min(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2 == null;
        }
        if (root2 == null) {
            return false;
        }
        boolean left = min(root1.left, root2.right);
        if (root1.val != root2.val) {
            return false;
        }
        boolean right = min(root1.right, root2.left);
        return left && right;

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
