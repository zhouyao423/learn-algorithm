import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class _84_largestRectangleArea {
    //84. 柱状图中最大的矩形 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
    //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    //
    //求在该柱状图中，能够勾勒出来的矩形的最大面积。
    //示例 1:
    //
    //
    //
    //输入：heights = [2,1,5,6,2,3]
    //输出：10
    //解释：最大的矩形为图中红色区域，面积为 10
    public static void main(String[] args) {
        System.out.println(largestRectangleArea1(new int[]{2, 1, 2}));
    }

    //用两个数组存储i处刚好小于i处高度的位置
    public static int largestRectangleArea1(int[] heights) {
        int[] leftArray = new int[heights.length];
        int[] rightArray = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() >= 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftArray[i] = stack.peek();

            stack.push(i);
        }
        stack.clear();
        stack.push(heights.length);
        for (int i = heights.length -1; i >=0; i--) {
            while (stack.peek() < heights.length && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightArray[i] = stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = rightArray[i] - leftArray[i] -1;
            maxArea = Math.max(maxArea,height*width);
        }
        return maxArea;
    }


    public static int largestRectangleArea(int[] heights) {
        //将原数组添加两个哨兵
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 1; i <= heights.length; i++) {
            newHeights[i] = heights[i - 1];
        }
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                //peek 位置是高点
                Integer height = newHeights[stack.pop()];
                Integer width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, width * height);

            }
            stack.push(i);
        }
        return maxArea;
    }
}
