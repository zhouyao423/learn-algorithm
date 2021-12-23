public class _33_search {

    //33. 搜索旋转排序数组
    //整数数组 nums 按升序排列，数组中的值 互不相同 。
    //
    //在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
    //
    //给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [4,5,6,7,0,1,2], target = 0
    //输出：4
    //时间复杂度为 O(log n)
    public static void main(String[] args) {
        System.out.println(search1(new int[]{3,1}, 1));
    }

    private static int search1(int[] nums, int target) {
        int right = nums.length - 1;
        if (right == -1) {
            return -1;
        }
        if (right == 0) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] < nums[mid]) {
                if (nums[mid] > target && target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    public static int search(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
                break;
            }
        }
        return Math.max(search(nums, 0, index, target), search(nums, index + 1, nums.length - 1, target));

    }

    private static int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
