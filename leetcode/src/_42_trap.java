public class _42_trap {
    //42. 接雨水
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //输出：6
    //解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    //示例 2：
    //
    //输入：height = [4,2,0,3,2,5]
    //输出：9
    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //双指针
    private static int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int count = 0;

        while (left < right){
            leftMax  = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (rightMax > leftMax){
                count += leftMax - height[left];
                left ++;
            }else{
                count += rightMax - height[right];
                right --;
            }
        }
        return count;
    }

    //动态规划 分别计算当前位置的左边最大值和右边的最大值
    private static int trap1(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length - 1) {
                leftMax[i] = height[i];
                continue;
            }
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == 0 || i == height.length - 1) {
                rightMax[i] = height[i];
                continue;
            }
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int count = 0;
        for (int i = 1; i < height.length - 1; i++) {
            count += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return count;
    }


    public static int trap(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i + 1] > height[i]) {
                continue;
            }
            int heightSum = 0;
            for (int j = i + 1; j <= height.length - 1; j++) {
                if (height[j] < height[j - 1]) {
                    if (j - 1 - i > 1) {
                        //计算i 到 j-1的中间的值
                        count += Math.min(height[i], height[j - 1]) * (j - 1 - i - 1) - heightSum + height[j - 1];
                        i = j - 2;
                        break;
                    }
                }
                heightSum += height[j];
            }
        }
        return count;
    }
}
