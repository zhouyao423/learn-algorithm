import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _207_canFinish {
    //207. 课程表
    //你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
    //
    //在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
    //
    //例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
    //请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //输入：numCourses = 2, prerequisites = [[1,0]]
    //输出：true
    //解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1,0}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> integers = map.computeIfAbsent(prerequisite[0], key -> new ArrayList<>());
            integers.add(prerequisite[1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !valid(i,map,visited)) {
                return false;
            }
        }
        return true;
    }

    private static boolean valid(Integer key,Map<Integer, List<Integer>> map,int[] visited){
        if (visited[key] == 1){
            return false;
        }
        if (visited[key] == 2){
            return true;
        }
        List<Integer> list = map.get(key);
        if (list == null){
            visited[key] = 2;
            return true;
        }
        visited[key] = 1;
        for (Integer tKey : list) {
            if (visited[key] == 2){
                continue;
            }
            boolean valid = valid(tKey, map, visited);
            if (!valid){
                return false;
            }
        }
        visited[key] = 2;
        return true;
    }
}
