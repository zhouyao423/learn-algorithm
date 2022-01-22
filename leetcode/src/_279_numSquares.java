public class _279_numSquares {
    //279. 完全平方数 https://leetcode-cn.com/problems/perfect-squares/
    //给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    //
    //给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
    //
    //完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 12
    //输出：3
    //解释：12 = 4 + 4 + 4
    //示例 2：
    //
    //输入：n = 13
    //输出：2
    //解释：13 = 4 + 9
    public static void main(String[] args) {
        numSquares(12);
    }

    private static int count = Integer.MAX_VALUE;

    public static int numSquares(int n) {
        int k = 1;
        while (n >= k * k) {
            k++;
        }
        k--;
        int[] arr = new int[k];
        for (int i = 0; i <k; i++) {
            arr[i] = (k-i) * (k-i);
        }
        dfs(arr, 0, n, 0);
        return count;
    }

    private static void dfs(int[] arr, int index, int n, int depth) {
        if(depth>=count){
            return;
        }
        if (index >=arr.length){
            return;
        }
        if (n - arr[index] == 0) {
            depth++;
            count = Math.min(count, depth);
            return;
        }
        if (n - arr[index] < 0) {
            dfs(arr, index + 1, n, depth);
            return;
        }
        dfs(arr, index, n - arr[index], depth+1);
        dfs(arr, index + 1, n, depth);
    }
}
