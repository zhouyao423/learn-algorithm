package sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author zhouyao
 * @date 2022/3/25 9:02 AM
 **/
public class _3_merge {

    //给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
    // 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
    // **注意：**最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
    // 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
    // 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
    //-----
    //Copyright by liweiwei1419.
    //Link: https://suanfa8.com/merge-sort/0088-merge-sorted-array/


    public static void main(String[] args) {
        _3_merge m = new _3_merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        m.merge(nums1, nums2, 6, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums = {33, 2, 5, 6, 8, 1, 0, 2, 5, 1, 0, 2, 6, 5, 69};
        m.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void merge(int[] nums1, int[] nums2, int m, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[n];
            }
            return;
        }
        int p1 = m - n - 1;
        int p2 = n - 1;
        int curIndex = m - 1;
        while (p1 >= 0 && p2 >= 0) {
            while (p1 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[curIndex] = nums1[p1];
                curIndex--;
                p1--;
                if (p1 < 0) {
                    for (int i = 0; i <= p2; i++) {
                        nums1[i] = nums2[i];
                    }
                    return;
                }
            }
            while (p2 >= 0 && nums1[p1] < nums2[p2]) {
                nums1[curIndex] = nums2[p2];
                curIndex--;
                p2--;
                if (p2 < 0) {
                    return;
                }
            }
        }
    }

    /**
     * 对[left,right] 范围内进行排序
     *
     * @param nums
     */
    public void sort(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        if (right - left < 16){
            insertSort(nums,left,right);
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        if (nums[mid+1] > nums[mid]){
            return;
        }
        mergeTwoArray(nums, left, mid, right);
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j >0 && temp < nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private void mergeTwoArray(int[] nums, int left, int mid, int right) {
        int[] tempArr = new int[right - left + 1];

        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = nums[left + i];
        }
        int p1 = 0;
        int p2 = mid - left + 1;
        int p1Max = p2;
        for (int i = 0; i < tempArr.length; i++) {
            if (p2 >= tempArr.length || (p1 < p1Max && tempArr[p1] <= tempArr[p2])) {
                nums[left] = tempArr[p1];
                left++;
                p1++;
            } else {
                nums[left] = tempArr[p2];
                left++;
                p2++;
            }
        }
    }

    /**
     * 归并排序的优化
     * 小数组的时候使用插入排序
     * 当数组已经有序的时候无需进行归并
     *
     * @param nums
     * @param left
     * @param right
     */
    private void mergeSort1(int[] nums, int left, int right) {

        mergeSort(nums, 0, nums.length - 1);

    }
}
