import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_merge {
    //56. 合并区间
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
    //示例 1：
    //
    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public static void main(String[] args) {
        // {{1,3},{2,6},{8,10},{15,18}}
        int[][] ints = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge1(ints)));
    }

    public static int[][] merge1(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = list.get(list.size() - 1);
            if (intervals[i][0] > ints[1]) {
                list.add(intervals[i]);
                continue;
            }
            if (intervals[i][1] > ints[1]) {
                ints[1] = intervals[i][1];
            }
        }
        return list.toArray(new int[][]{});
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> mergeList = new ArrayList<>();
        mergeList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            boolean merged = false;
            for (int j = 0; j < mergeList.size(); j++) {
                int[][] merge = merge(intervals[i], mergeList.get(j));
                if (merge.length == 1) {
                    mergeList.set(j, merge[0]);
                    merged = true;
                    break;
                }
            }
            //遍历完未合并
            if (!merged) {
                mergeList.add(intervals[i]);
            }
        }
        return mergeList.toArray(new int[][]{});
    }

    private static int[][] merge(int[] inter1, int[] inter2) {
        int[] minInter = null;
        int[] maxInter = null;
        if (inter1[0] < inter2[0]) {
            minInter = inter1;
            maxInter = inter2;
        } else {
            minInter = inter2;
            maxInter = inter1;
        }
        //能合并
        if (maxInter[0] <= minInter[1]) {
            int end = Math.max(minInter[1], maxInter[1]);
            int[][] ints = new int[1][2];
            ints[0][0] = minInter[0];
            ints[0][1] = end;
            return ints;
        }
        int[][] ints = new int[2][2];
        ints[0] = minInter;
        ints[1] = maxInter;
        return ints;
    }

}
