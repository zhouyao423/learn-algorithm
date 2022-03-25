package realquestion;

import java.lang.annotation.Target;
import java.util.TreeMap;

/**
 * 二分查找的递归和递推写法
 * @author zhouyao
 * @date 2022/3/25 5:18 PM
 **/
public class _0_find {
    public static void main(String[] args) {
        _0_find f = new _0_find();
        boolean b = f.find(new int[]{0, 1, 3, 5, 7, 9, 11}, 98);
        System.out.println(b);
    }


    public boolean find(int[] nums,int n){

      return  find(nums,n,0,nums.length-1);

    }

    private boolean find(int[] nums, int n, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] == n) {
            return true;
        }
        if (left >= right) {
            return false;
        }

        return n < nums[mid] ? find(nums, n, left, mid - 1) : find(nums, n, mid+1, right);
    }

    //递归
    public boolean find1(int[] nums, int n) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == n) {
                return true;
            }

            if (nums[mid] < n) {
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
