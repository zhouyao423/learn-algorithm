import java.util.Arrays;

public class _75_sortColors {
    //75. 颜色分类
    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    //
    //此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,0,2,1,1,0]
    //输出：[0,0,1,1,2,2]
    //示例 2：
    //
    //输入：nums = [2,0,1]
    //输出：[0,1,2]

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = 0;
                nums[i] = temp;
                //存在1
                if (p1 > p0) {
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                }
                p1++;
                p0++;
            } else if (nums[i] == 1) {
                int temp = nums[p1];
                nums[p1] = 1;
                nums[i] = temp;
                p1++;
            }
        }
    }
}
