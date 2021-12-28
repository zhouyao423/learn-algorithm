import java.util.Arrays;

public class _48_rotate {
    //48. 旋转图像
    //给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
    //
    //你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
    //输出：[[7,4,1],[8,5,2],[9,6,3]]
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        //矩阵的层数
        int floor = matrix.length / 2;

        for (int i = 0; i < floor; i++) {
            //第i层从（i，i）开始
            for (int j = i; j < len - i - 1; j++) {
                int left = j;
                int right = len - i - 1;
                int temp = matrix[i][j];
                int temp2;
                int indexTemp;
                while (left != i || right != j) {
                    temp2 = matrix[left][right];
                    matrix[left][right] = temp;
                    temp = temp2;
                    indexTemp = right;
                    right = len - left - 1;
                    left = indexTemp;
                }
                matrix[i][j] = temp;
            }
        }

    }
}
