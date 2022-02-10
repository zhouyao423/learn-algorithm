import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _337_rob {
    //小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
    //
    //除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
    //
    //给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
    //
    // 
    //
    //示例 1:
    //
    //
    //
    //输入: root = [3,2,3,null,3,null,1]
    //输出: 7
    //解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/house-robber-iii
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        dfs(nodes, 0);
        return maxTotal;
    }

    int maxTotal = 0;
    Map<TreeNode,Integer> cache = new HashMap<>();
    private int dfs1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        Integer cacheValue = cache.get(node);
        if (cacheValue != null){
            return cacheValue;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        int current = node.val + (left == null ? 0 : dfs1(left.left) + dfs1(left.right)) + (right == null ? 0 : dfs1(right.left) + dfs1(right.right));
        int children = dfs1(left) + dfs1(right);
        int max = Math.max(current, children);
        cache.put(node,max);
        return max;
    }

    private void dfs(List<TreeNode> nodes, int total) {
        if (nodes.isEmpty()) {
            maxTotal = Math.max(maxTotal, total);
            return;
        }
        List<TreeNode> newNodes = new ArrayList<>();
        int newTotal = total;
        for (TreeNode node : nodes) {
            newTotal += node.val;
            if (node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
        }
        dfs(newNodes, total);
        List<TreeNode> treeNodes = new ArrayList<>();
        for (TreeNode node : newNodes) {
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
        }
        dfs(treeNodes, newTotal);
    }
}
