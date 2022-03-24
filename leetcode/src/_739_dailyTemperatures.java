import java.util.*;

public class _739_dailyTemperatures {
    //给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
    //
    //
    //
    //示例 1:
    //
    //输入: temperatures = [73,74,75,71,69,72,76,73]
    //输出:[1,1,4,2,1,1,0,0]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/daily-temperatures
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] newArr = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(temperatures[i]);
        }
        list.sort(Comparator.comparing(x -> x));
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (temperatures[i] == list.get(list.size() - 1)) {
                result[i] = 0;
                list.remove(list.size() - 1);
            }
            for (int j = i + 1; j < length; j++) {

                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    //单调栈解法
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {

            while (stack.peek() != null && temperatures[i] > temperatures[stack.peek()] ){
                Integer pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.push(i);

        }

        return result;

    }
}
