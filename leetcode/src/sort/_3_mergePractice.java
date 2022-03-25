package sort;

public class _3_mergePractice {

    //在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
    //
    //
    //示例 1:
    //
    //输入: [7,5,6,4]
    //输出: 5
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        _3_mergePractice m = new _3_mergePractice();
        int i = m.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }

    private int count = 0;

    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length - 1);
        return count;
    }

    private void merge(int[] nums, int start, int end) {
        if (start >= end){
            return;
        }
        int mid = (start + end)/2;
        merge(nums,start,mid);
        merge(nums,mid+1 ,end);
        mergeTwoArray(nums,start,mid,end);
    }

    private void mergeTwoArray(int[] nums, int start, int mid, int end) {
        int length = end - start +1;
        int[] tempArr = new int[length];
        for (int i = 0; i < length; i++) {
            tempArr[i] = nums[start + i];
        }
        int p1 = 0;
        int p1Len = mid - start +1;
        int p2 = mid - start +1;
        int p1Max = p2;
        for (int i = 0; i < length; i++) {
            if (p2>=length || (p1<p1Max && tempArr[p1]<=tempArr[p2])){
                nums[start] = tempArr[p1];
                start ++;
                p1++;
                p1Len--;
            }else {
                nums[start] = tempArr[p2];
                start ++;
                p2++;
                count +=p1Len;
            }
        }
    }
}
