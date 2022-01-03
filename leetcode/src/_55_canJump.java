public class _55_canJump {
    //55. 跳跃游戏
    //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //判断你是否能够到达最后一个下标。
    //示例 1：
    //
    //输入：nums = [2,3,1,1,4]
    //输出：true
    //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length==1) {
            return true;
        }
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && far <= i) {
                return false;
            }
            int dis = nums[i] + i;
            far = Math.max(far,dis);
            if (far >= nums.length-1){
                return true;
            }
        }
        return true;
    }
}
