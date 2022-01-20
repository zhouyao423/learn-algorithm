public class _238_productExceptSelf {
    //238. 除自身以外数组的乘积 https://leetcode-cn.com/problems/product-of-array-except-self/
    //给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
    //
    //
    //
    //示例:
    //
    //输入: [1,2,3,4]
    //输出: [24,12,8,6]
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            } else {
                result[i] = nums[i - 1] * result[i - 1];
            }
        }
        int s = nums[nums.length-1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * s;
            s = s*nums[i];
        }
        return result;
    }
}
