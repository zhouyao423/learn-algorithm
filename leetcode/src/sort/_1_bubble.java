package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zhouyao
 * @date 2022/3/24 5:00 PM
 **/
public class _1_bubble {
    public static void main(String[] args) {
        int[] ints = {3, 5, 6, 9, 4, 1, 2, 3, 5, 2, 1, 2, 2, 4, 0, 2, 5, 1, 0, 5};
        _1_bubble bubble = new _1_bubble();
        bubble.sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void sort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            boolean sorted = true;
            for (int j = 1; j < length - i ; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
        }

    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
