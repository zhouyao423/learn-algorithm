import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个n*m（n,m<=8）的格子，要求从左上角走到右下角，求方案数。
 * @author zhouyao
 * @date 2021/11/30 2:09 下午
 **/
public class _1_matrix_ways_count {
    public static void main(String[] args) {
        System.out.println(waysCount(2,6));

    }
    private static HashMap<String,Integer> map = new HashMap<>();

    private static int waysCount(int i,int j){
        //记路径总数为f(n,m),到达中间某点（i，j）路径数为f（i，j）
        // 从点（i-1，j-1）到达（i，j）有两种方式，从（i-1,j） 或从（i，j-1）
//        所以 f(i,j) = f(i-1,j) + f(i,j-1)
        if (i<0 || j<0){
            return 0;
        }
        //1.限定边界
        if (i==0 && j==0){
            return 1;
        }
        //2. 偏序关系
        //3. 存储计算
        String key = getKey(i, j);
        Integer integer = map.get(key);
        if (integer != null){
            return integer;
        }
        //4. 递归
        int ways = waysCount(i - 1, j) + waysCount(i, j - 1);

        map.put(key, ways);
        return ways;
    }

    private static String getKey(int i, int j) {
        return String.valueOf(i) + j;
    }
}
