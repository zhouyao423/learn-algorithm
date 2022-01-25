import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;

public class _297_serialize {
    //297. 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
    //序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    //
    //请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    //
    //提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：root = [1,2,3,null,null,4,5]
    //输出：[1,2,3,null,null,4,5]

    public static void main(String[] args) {
        _297_serialize s = new _297_serialize();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(-3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        String serialize = s.serialize(treeNode);
        System.out.println(serialize);
        s.deserialize(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null){
            return sb.toString();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            int i = queue.size();
            while (i > 0) {
                i--;
                TreeNode pop = queue.pollLast();
                if (pop.val==Integer.MIN_VALUE){
                    sb.append("*");
                }else {
                    sb.append(pop.val);
                    if (pop.left == null){
                        queue.push(new TreeNode(Integer.MIN_VALUE));
                    }else {
                        queue.push(pop.left);
                    }
                    if (pop.right == null){
                        queue.push(new TreeNode(Integer.MIN_VALUE));
                    }else {
                        queue.push(pop.right);
                    }
                }
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("#");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] split = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        for (int i = 1; i < split.length; i++) {
            String[] sigleDgt = split[i].split(",");
            int size = queue.size();
            int j = 0;
            while (size > 0) {
                size--;
                TreeNode treeNode = queue.pollLast();
                String leftChar = sigleDgt[j * 2];
                String rightChar = sigleDgt[j * 2 + 1];
                j++;
                treeNode.left = Objects.equals(leftChar, "*") ? null : new TreeNode(Integer.parseInt(leftChar));
                treeNode.right = Objects.equals(rightChar, "*") ? null : new TreeNode(Integer.parseInt(rightChar));
                if (treeNode.left != null) {
                    queue.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.push(treeNode.right);
                }
            }
        }
        return root;
    }

}
