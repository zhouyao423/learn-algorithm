import java.util.ArrayList;
import java.util.List;

public class _78_subset {
    //78. 子集
    //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    //
    //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        sub1(nums, new ArrayList<>(), lists, 0);
        return lists;
    }

    private static void sub(int[] nums, List<Integer> list, List<List<Integer>> lists, int index) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        sub(nums, list, lists, index + 1);
        list.remove(list.size() - 1);
        sub(nums, list, lists, index + 1);
    }

    private static void sub1(int[] nums, List<Integer> list, List<List<Integer>> lists, int index) {

        lists.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            sub1(nums, list, lists, i + 1);
            list.remove(list.size() - 1);
        }
    }
    //start表示这次遍历从哪里开始
    public static void dfs(int[] nums, int start) {
        //树之中的每个节点都要保存，所以我们一上来就直接添加到结果。
        res.add(new ArrayList<>(path));
        //从上一层的节点之后（start）开始遍历到结尾
        for (int i = start; i < nums.length; i++) {
            //添加到当前路径
            path.add(nums[i]);
            //从下一个节点开始，递归下一层
            dfs(nums, i + 1);
            //回溯
            path.remove(path.size() - 1);
        }
    }


    //存放结果
    static List<List<Integer>> res = new ArrayList<>();
    //存放当前路径
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> subsets1(int[] nums) {
        dfs(nums, 0);
        return res;
    }



}
