import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_combinationSum {
    //39. 组合总和
    //给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
    //
    //candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
    //
    //对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    //
    //
    //
    //示例 1：
    //
    //输入：candidates = [2,3,6,7], target = 7
    //输出：[[2,2,3],[7]]
    //解释：
    //2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    //7 也是一个候选， 7 = 7 。
    //仅有这两种组合。
    //示例 2：
    //
    //输入: candidates = [2,3,5], target = 8
    //输出: [[2,2,2,2],[2,3,3],[3,5]]
    //示例 3：
    //
    //输入: candidates = [2], target = 1
    //输出: []
    public static void main(String[] args) {
        System.out.println(combinationSum1(new int[]{2, 3, 5}, 8));
    }

    private static List<List<Integer>> combinationSum1(int[] candidates, int target) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        dfs(candidates,target,0,new ArrayList<>(), list);
        return list;
    }

    private static void dfs(int[] candidates, int target, int index, List<Integer> list1, List<List<Integer>> list) {
        if (index >= candidates.length) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(list1));
            return;
        }


        //选择当前的数
        if (target > 0) {
            list1.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, list1, list);
            list1.remove(list1.size() - 1);
        }
        //跳过当前数
        dfs(candidates, target, index + 1, list1, list);
    }


    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        huisu(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private static void huisu(List<List<Integer>> list, List<Integer> list1, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            return;
        }
        if (candidates[index] > target) {
            return;
        }

        int sum = 0;
        int count = 0;
        while (sum < target) {
            sum += candidates[index];
            count++;
            list1.add(candidates[index]);
            if (sum == target) {
                list.add(new ArrayList<>(list1));
            }
        }
        while (!list1.isEmpty() && count > 0) {
            sum -= candidates[index];
            list1.remove(list1.size() - 1);
            count--;
            if (list1.isEmpty()) {
                huisu(list, new ArrayList<>(), candidates, target, index + 1);
            } else {
                huisu(list, list1, candidates, target - sum, index + 1);
            }
        }
    }
}
