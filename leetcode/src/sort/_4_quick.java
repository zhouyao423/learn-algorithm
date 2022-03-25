package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快排
 *
 * @author zhouyao
 * @date 2022/3/25 2:25 PM
 **/
public class _4_quick {
    public static void main(String[] args) {
        _4_quick q = new _4_quick();
        int[] nums = {0, 4, 5, 0, 5, 0, 25, 6, 2, 0, 1, 4, 8, 9, 5, 12, 0, 5};
        q.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        partition(nums, 0, nums.length - 1);
    }

    private void partition(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //以第一个元素为pivot，将数组分为两个部分
        int end = left;
        //优化 随机pivot
        Random random = new Random();
        int pivot = random.nextInt(right - left) + left;
        swap(nums,pivot,left);
        System.out.println(left + " " + right + " " + pivot);
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                end++;
                swap(nums, end, i);
            }
        }
        swap(nums, left, end);
        partition(nums, left,end-1);
        partition(nums,end+1,right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
