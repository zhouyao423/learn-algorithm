import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _46_permute {
    //46. 全排列
    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //示例 2：
    //
    //输入：nums = [0,1]
    //输出：[[0,1],[1,0]]
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    //全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums,new boolean[nums.length],new ArrayList<>(),0,list);
        return list;
    }

    private static void dfs(int[] nums, boolean[] record, List<Integer> list, int depth, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!record[i]) {
                list.add(nums[i]);
                record[i] = true;
                dfs(nums, record, list, depth + 1, result);
                list.remove(list.size()-1);
                record[i] = false;
            }
        }
    }
}
