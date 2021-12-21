public class __DFS {
    //如果我每一步只能迈上1个或2个台阶。先迈左脚，
    // 然后左右交替，最后一步是迈右脚，
    // 也就是说一共要走偶数步。
    // 那么，上完39级台阶，有多少种不同的上法呢？
    public static void main(String[] args) {

        dfs(0, 0, 39);
        System.out.println(count);
    }
    private static int count = 0;
    private static void dfs( int left, int right, int n) {
        if (left == right && n == 0) {
            count++;
            return;
        }
        if (n > 0) {
            if (left == right) {
                left++;
            } else {
                right++;
            }
            dfs( left, right, n - 1);
            dfs( left, right, n - 2);
        }
    }
}
