import java.util.ArrayList;
import java.util.List;

public class _437_pathSum {
    //437. 路径总和 III
    //给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
    //
    //路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return count;
    }

    private int count = 0;

    private void dfs(TreeNode node, List<Integer> valList, int targetSum) {
        if (node == null) {
            return;
        }
        valList.add(0);
        for (int i = 0; i < valList.size(); i++) {
            valList.set(i, valList.get(i) + node.val);
            if (valList.get(i) == targetSum) {
                count++;
            }
        }
        dfs(node.left, valList, targetSum);

        //回溯
        dfs(node.right, valList, targetSum);
        for (int i = 0; i < valList.size(); i++) {
            valList.set(i, valList.get(i) - node.val);
        }
        valList.remove(valList.size() - 1);
    }
}
