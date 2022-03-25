package sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author zhouyao
 * @date 2022/3/24 4:49 PM
 **/
public class _0_select {
    public static void main(String[] args) {
        int[] ints = {3, 5, 6, 9, 4, 1, 2, 3, 5, 2, 1, 2, 2, 4, 0, 2, 5, 1, 0, 5};
        _0_select select = new _0_select();
        select.sort(ints);
        System.out.println(Arrays.toString(ints));
    }


    public void sort(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            swap(nums,i,minIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
