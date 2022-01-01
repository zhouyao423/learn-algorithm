public class _53_maxSubArray {
    //53. 最大子数组和
    //给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //子数组 是数组中的一个连续部分。
    //
    //示例 1：
    //
    //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    //输出：6
    //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{-1}));
    }

    //分治法
    public static int maxSubArray2(int[] nums) {

        return findMax(nums, 0, nums.length - 1);
    }

    private static int findMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int max = Math.max(findMax(nums, left, mid), findMax(nums, mid + 1, right));
        max = Math.max(max, findAcrossMid(nums, left, mid, right));
        return max;
    }

    private static int findAcrossMid(int[] nums, int left, int mid, int right) {
        //mid处一定包含
        int max = Integer.MIN_VALUE;
        int sum = 0;
        //从mid向两端扩展
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
        }
        sum = max;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }


    //动态规划
    public static int maxSubArray1(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < 0) {
                if (sum + nums[i] < 0) {
                    sum = 0;
                    continue;
                }
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
