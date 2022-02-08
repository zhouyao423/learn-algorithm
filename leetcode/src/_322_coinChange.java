import java.util.Arrays;

public class _322_coinChange {
    //322. 零钱兑换
    //给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    //
    //计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    //
    //你可以认为每种硬币的数量是无限的。
    //
    //
    //
    //示例 1：
    //
    //输入：coins = [1, 2, 5], amount = 11
    //输出：3
    //解释：11 = 5 + 5 + 1
    public static void main(String[] args) {
        _322_coinChange coinChange = new _322_coinChange();
        coinChange.coinChange(new int[]{186,419,83,408},6249);
        System.out.println();
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 ){
            return 0;
        }
        Arrays.sort(coins);
        for (int i = coins.length-1; i >=0 ; i--) {
            int depth = dfs(coins, i, amount, 0);
            if (depth >0) {
                return depth;
            }
        }
        return -1;
    }

    private int dfs(int[] coins, int startIndex, int amount, int depth) {

        int newAmount = amount - coins[startIndex];
        if (newAmount == 0) {
            return depth + 1;
        }

        if (newAmount<0){
            if (startIndex == 0){
                return -1;
            }
            return dfs(coins,startIndex-1,amount,depth);
        }
        int dfs = dfs(coins, startIndex, newAmount, depth + 1);
        if (dfs<0 && startIndex>0){
            return dfs(coins,startIndex-1,amount,depth);
        }
        return dfs;
    }
}
