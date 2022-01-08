import java.util.ArrayDeque;
import java.util.Deque;

public class _85_maximalRectangle {
    //85. 最大矩形 https://leetcode-cn.com/problems/maximal-rectangle/
    //给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    //输出：6
    //解释：最大矩形如上图所示。
    //示例 2：
    //
    //输入：matrix = []
    //输出：0
    public static void main(String[] args) {

        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}
        ));
    }

    public static int maximalRectangle(char[][] matrix) {
        //先求出每一行的高度
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    heights[i][j] = matrix[0][j] == '1' ? 1 : 0;
                } else {
                    heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i - 1][j] + 1;
                }
            }
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea =  Math.max(maxArea, largestRectangleArea(heights[i]));
        }
        return maxArea;
    }


    private static int largestRectangleArea(int[] heights) {
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
