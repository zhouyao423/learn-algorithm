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
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //动态规划
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

    private void calc1(int[] height, int left, int right, int count) {
        if (right - left <= 1) {
            return;
        }
        if (height[left] < height[left + 1]) {
            calc(height, left++, right, count);
            return;
        }
        for (int i = left; i < right - 1; i++) {
            for (int j = left + 2; j <= right; j++) {

            }
        }


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
