public class _283_moveZeroes {
    //283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //
    //示例:
    //
    //输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]

    public static void main(String[] args) {

    }
    public void moveZeroes(int[] nums) {
        int point = 0;
        int next = 0;
        while (nums[point] !=0){
            point++;
        }
        next = point+1;
        while (next<nums.length){
            if (nums[next] !=0){
                swap(nums,point,next);
                point++;
            }
            next++;
        }

    }

    private void swap(int[] nums,int point ,int next){
        int t = nums[point];
        nums[point] = nums[next];
        nums[next] = t;
    }

}
