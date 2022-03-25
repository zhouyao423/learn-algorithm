public class _50_myPow {
    //50. Pow(x, n)
    //实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
    //
    //
    //
    //示例 1：
    //
    //输入：x = 2.00000, n = 10
    //输出：1024.00000

    public static void main(String[] args) {
        _50_myPow m = new _50_myPow();
        double v = m.myPow(2.00000,-2147483648);
        System.out.println(v);
    }

    public double myPow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return x;
        }
        if (n == -1){
            return 1.0/x;
        }

        //奇数
        if ((n&1)==1){

            return myPow(x*x,n/2) * (n>0?x:1/x);
        }else {
            return myPow(x*x,n/2);
        }

    }
}
