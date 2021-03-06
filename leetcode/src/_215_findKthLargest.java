import java.util.Arrays;
import java.util.Random;

public class _215_findKthLargest {
    //给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    //
    //请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    //
    // 
    //
    //示例 1:
    //
    //输入: [3,2,1,5,6,4] 和 k = 2
    //输出: 5
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//    public static void main(String[] args) {
//        int[] nums = new int[]{8, 2, 4, 5, 0, 2, 3};
//        quicksort(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//    }

    public static int findKthLargest(int[] nums, int k) {

        return quicksort(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quicksort(int[] nums, int left, int right, int k) {
        int pos = randomPartition(nums, left, right);
        if (k == pos) {
            return nums[k];
        }
        if (k > pos) {
            return quicksort(nums, left, pos - 1, k);
        } else {
            return quicksort(nums, pos + 1, right, k);
        }
    }

    static Random random = new Random();

    private static int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + 1;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int pos = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, pos, i);
                pos++;
            }
        }
        swap(nums, pos, right);
        return pos;
    }


    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 6, 7, 1, 2, 3, 4, 2, 1, 0};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //堆排序
    private static void heapSort(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            deepHeap(nums, 0, i-1);
        }
    }

    //构建最大堆
    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >=0; i--) {
            deepHeap(nums, i, nums.length - 1);
        }
    }

    private static void deepHeap(int[] nums, int rootNode, int endIndex) {
        if (rootNode >= endIndex) {
            return;
        }
        int left = rootNode * 2 + 1;
        int right = rootNode * 2 + 2;
        int maxIndex = rootNode;
        if (left <= endIndex && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right <= endIndex && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        //说明子节点比父节点大
        if (maxIndex != rootNode) {
            swap(nums, rootNode, maxIndex);
            //继续对maxindex处的node进行建堆
            deepHeap(nums, maxIndex, endIndex);
        }
    }
}
