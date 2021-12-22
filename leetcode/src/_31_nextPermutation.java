import java.util.Arrays;
import java.util.LinkedList;


public class _31_nextPermutation {
    //实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
    //
    //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    //
    //必须 原地 修改，只允许使用额外常数空间。
    //
    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[1,3,2]
    //示例 2：
    //
    //输入：nums = [3,2,1]
    //输出：[1,2,3]
    //示例 3：
    //
    //输入：nums = [1,1,5]
    //输出：[1,5,1]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/next-permutation
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
//        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        int[] nums = {2, 3, 1};
        nextPermutation2(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation2(int[] nums) {
        //先找到右边大于左边的数
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        //找[index+1,)区间内大于index的最小数
        if (index >= 0) {
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, index, i);
                    break;
                }
            }
        }
        //将[index+1,) 翻转
        reverse(nums, index + 1);
    }

    private static void reverse(int[] nums,int left) {
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void nextPermutation1(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        fun(nums, list, nums.length - 1);
        for (int i = 0; i < list.size(); i++) {
            nums[nums.length - list.size() + i] = list.get(i);
        }
    }

    private static void fun(int[] nums, LinkedList<Integer> list, int index) {
        if (index < 0) {
            return;
        }
        if (list.isEmpty() || nums[index] >= list.getLast()) {
            list.add(nums[index]);
            fun(nums, list, index - 1);
        } else {
            //循环判断
            for (int i = list.size() - 2; i >= 0; i--) {
                Integer listi = list.get(i);
                if (nums[index] >= listi) {
                    listi = list.get(i + 1);
                    int temp = nums[index];
                    nums[index] = listi;
                    list.set(i + 1, temp);
                    return;
                }
//                if (nums[index] > listi) {
//                    int temp = nums[index];
//                    nums[index] = listi;
//                    list.set(i, temp);
//                    return;
//                }
            }
            //index 最小
            int temp = nums[index];
            nums[index] = list.getFirst();
            list.set(0, temp);
        }
    }


    private static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    //将j+1后的部分从小到大排序
                    for (int k = j + 1; k < nums.length; k++) {
                        for (int l = k + 1; l < nums.length; l++) {
                            if (nums[k] > nums[l]) {
                                temp = nums[k];
                                nums[k] = nums[l];
                                nums[l] = temp;
                            }
                        }
                    }
                    return;
                }
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}
