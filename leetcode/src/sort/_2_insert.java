package sort;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;

/**
 * 插入排序
 *
 * @author zhouyao
 * @date 2022/3/24 5:40 PM
 **/
public class _2_insert {
    public static void main(String[] args) {
        int[] ints = {3, 5, 6, 9, 4, 1, 2, 3, 5, 2, 1, 2, 2, 4, 0, 2, 5, 1, 0, 5};
        _2_insert bubble = new _2_insert();
        bubble.sort2(ints);
        System.out.println(Arrays.toString(ints));
    }

        /**
         * 基于交换的插入排序
         *
         * 插入排序在数组基本有序的情况下非常快,这时时间复杂度可以接近 O(n)
         * 所以插入排序在短数组性能表现好
         *
         * @param nums
         */
    public void sort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 插入排序的优化
     * @param nums
     */
    public void sort1(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            int swapIndex = i;
            for (int j = i-1; j >= 0; j--) {
                if (temp < nums[j]) {
                    swapIndex = j;
                }else {
                    break;
                }
            }
            if (swapIndex !=i){
                //将i到j-1之间的元素后移
                for (int j = i; j >swapIndex; j--) {
                    nums[j] = nums[j-1];
                }
                nums[swapIndex] = temp;
            }

        }
    }

    /**
     * 插入排序优化2
     * @author zhouyao
     * @date 2022/3/25 8:53 AM
     **/
    public void sort2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            int j = i;
            while (j>0 && temp<nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
