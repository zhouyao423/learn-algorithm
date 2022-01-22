public class _240_searchMatrix {
    //240. 搜索二维矩阵 II https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
    //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
    //
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列。
    //
    //
    //示例 1：
    //
    //
    //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    //输出：true
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));


    }

    //Z字查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

    public static boolean searchMatrix1(int[][] matrix ,int target){
        for (int i = 0; i < matrix.length; i++) {
            if (search(matrix[i],target)){
                return true;
            }
        }
        return false;
    }

    private static  boolean search(int[] arr,int target){
        int left = 0 ;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if (arr[mid] == target){
                return true;
            }
            if(arr[mid]>target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return false;
    }

}
