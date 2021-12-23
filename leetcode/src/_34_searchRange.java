public class _34_searchRange {

    //34. 在排序数组中查找元素的第一个和最后一个位置
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    //
    //进阶：
    //
    //你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
    //
    //
    //示例 1：
    //
    //输入：nums = [5,7,7,8,8,10], target = 8
    //输出：[3,4]
    //示例 2：
    //
    //输入：nums = [5,7,7,8,8,10], target = 6
    //输出：[-1,-1]
    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{1,1,2},1));
    }

    private static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = -1, rightIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                rightIndex = mid;
                leftIndex = mid;
                while (rightIndex + 1 < nums.length && nums[rightIndex + 1] == target) {
                    rightIndex++;
                }
                while (leftIndex - 1 >= 0 && nums[leftIndex - 1] == target) {
                    leftIndex--;
                }
                return new int[]{leftIndex, rightIndex};
            }
            if (target > nums[mid]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return new int[]{-1, -1};
    }
}
