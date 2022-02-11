import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_topKFrequent {
    //347. 前 K 个高频元素
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    //
    //
    //
    //示例 1:
    //
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //构造小顶堆 数组第一个元素为
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (priorityQueue.size() == k) {
                int[] peek = priorityQueue.peek();
                if (peek[1]<count){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num,count});
                }
            }else {
                priorityQueue.offer(new int[]{num,count});
            }
        }
        int[] rets = new int[k];
        for (int i = 0; i < k; i++) {
            rets[i] = priorityQueue.poll()[0];
        }
        return rets;
    }
}
