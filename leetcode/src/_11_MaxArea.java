public class _11_MaxArea {
    //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    //
    //说明：你不能倾斜容器。
    //
    // 
    //
    //示例 1：
    //
    //
    //
    //输入：[1,8,6,2,5,4,8,3,7]
    //输出：49
    //解释：图中垂直线代表输入数组 [2,3,4,5,18,17,6]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/container-with-most-water
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {

        System.out.println(maxArea1(new int[]{9, 6, 14, 11, 2, 2, 4, 9, 3, 8}));
    }
    //不需要找出最长的两个数
    private static int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int max = (right - left) * Math.min(height[right], height[left]);
        while (left < right) {
            max = Math.max((right - left) * Math.min(height[right], height[left]), max);
            if (height[right]<height[left]) {
                right--;
            }else{
                left++;
            }

        }
        return max;
    }


    private static int maxArea(int[] height) {

        //先找出最长的两个，向外移动最长的那根线

        int max, lIndex = 0, rIndex = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[rIndex]) {
                if (height[rIndex] > height[lIndex]) {
                    lIndex = rIndex;
                }
                rIndex = i;
            } else if (height[i] >= height[lIndex]) {
                lIndex = rIndex;
                rIndex = i;
            }

        }
        max = (rIndex - lIndex) * Math.min(height[rIndex], height[lIndex]);
        return Math.max(moveRitht(height, lIndex, rIndex, max), moveLeft(height, lIndex, rIndex, max));
    }

    private static int moveRitht(int[] height, int lIndex, int rIndex, int max) {
        for (int i = 1; i < height.length - rIndex; i++) {
            int temp = ((rIndex + i) - lIndex) * Math.min(height[rIndex + i], height[lIndex]);
            if (temp > max) {
                rIndex = rIndex + i;
                if (height[rIndex] > height[lIndex] || lIndex == 0) {
                    max = moveRitht(height, lIndex, rIndex, temp);
                } else {
                    max = moveLeft(height, lIndex, rIndex, temp);
                }
            }
        }
        return max;
    }

    private static int moveLeft(int[] height, int lIndex, int rIndex, int max) {
        for (int i = 1; lIndex - i >= 0; i++) {
            int temp = (rIndex - lIndex + i) * Math.min(height[rIndex], height[lIndex - i]);
            if (temp > max) {
                lIndex = lIndex - i;
                if (height[lIndex] > height[rIndex] || rIndex == height.length - 1) {
                    max = moveLeft(height, lIndex, rIndex, temp);
                } else {
                    max = moveRitht(height, lIndex, rIndex, temp);
                }
            }
        }
        if (rIndex != height.length - 1) {
            max = moveRitht(height, lIndex, rIndex, max);
        }
        return max;
    }
}
