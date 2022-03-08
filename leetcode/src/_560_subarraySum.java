import java.util.HashMap;
import java.util.Map;

public class _560_subarraySum {
    //给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
    public int subarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, k);
        }
        return count;
    }

    private int count = 0;

    private void dfs(int[] nums, int index, int k) {
        if (index >= nums.length) {
            return;
        }
        int left = k - nums[index];
        if (left == 0) {
            count++;
        }
        dfs(nums, index + 1, left);
    }

    //前缀和
    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int count = 0;
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
