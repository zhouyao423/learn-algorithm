import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_threeSum {
    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/3sum
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 如果得到的解是有顺序的，那么就能过滤掉重复解
     * 所以考虑先将数组排序
     *
     * @author zhouyao
     * @date 2021/12/20 3:08 下午
     **/
    private static List<List<Integer>> threeSum1(int[] sums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(sums);
        if (sums.length < 3) {
            return new ArrayList<>();
        }
        for (int i = 0; i < sums.length; i++) {
            int left = i + 1;
            int right = sums.length - 1;
            //重复值不需要遍历
            if (i > 0 && sums[i] == sums[i - 1]) {
                continue;
            }
            //当前两项之和大于0，向后遍历一定无解
            if (sums[i] + sums[i + 1] > 0) {
                return lists;
            }
            //需要找到 left + right = -sums[i]
            while (left < right) {
                int n = sums[i] + sums[left] + sums[right];
                if (n == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(sums[i]);
                    list.add(sums[left]);
                    list.add(sums[right]);
                    lists.add(list);
                    right -- ;
                } else if (n > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return lists;
    }

    /**
     * 普通的三层循环时间复杂度高，而且没有解决解的重复问题
     *
     * @param sums
     * @return
     */
    private static List<List<Integer>> threeSum(int[] sums) {

        //n1+n2+n3 = 0 转换为问题，指定n2 + n3 = -n1变为两数之和问题
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                for (int k = j + 1; k < sums.length; k++) {
                    if (sums[i] + sums[j] + sums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(sums[i]);
                        list.add(sums[j]);
                        list.add(sums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}
