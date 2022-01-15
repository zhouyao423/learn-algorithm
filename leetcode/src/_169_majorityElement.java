public class _169_majorityElement {
    //169. 多数元素 https://leetcode-cn.com/problems/majority-element/
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    //
    //
    //
    //示例 1：
    //
    //输入：[3,2,3]
    //输出：3
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        int count = 1;
        int n = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if (count ==0){
                n = nums[i];
                count++;
            }else {
                if (n == nums[i]){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return n;
    }
}
