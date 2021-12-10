/**
 * 两个有序数组的中位数
 *
 * @author zhouyao
 * @date 2021/12/1 4:25 下午
 **/
public class _4_MedianOfTwoSortArrays {
//    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//    算法的时间复杂度应该为 O(log (m+n)) 。
//    示例 1：
//
//    输入：nums1 = [1,3], nums2 = [2]
//    输出：2.00000
//    解释：合并数组 = [1,2,3] ，中位数 2
//    示例 2：
//
//    输入：nums1 = [1,2], nums2 = [3,4]
//    输出：2.50000
//    解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 5, 6, 7, 9, 10}, 5));

        System.out.println(findMedian(new int[]{1}, new int[]{1}));
        System.out.println(recursiveFind(new int[]{}, new int[]{ 4}));
    }

    //不用二分法找中位数
    private static float ordinal(int[] a, int[] b) {
        int totalLength = a.length + b.length;
        int aindex = 0;
        int bindex = 0;
        int left = -1;
        int right = -1;
        for (int i = 0; i <= totalLength / 2; i++) {
            left = right;
            if (aindex < a.length && (bindex >= b.length || a[aindex] < b[bindex])) {
                right = a[aindex];
                aindex++;
            } else {
                right = b[bindex];
                bindex++;
            }
        }
        if ((totalLength & 1) == 0) {
            return (left + right) / 2f;
        } else {
            return right;
        }
    }

    //利用二分法的思想找中位数
    private static float findMedian(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        //中位数的位置固定
        int totalLength = a.length + b.length;
        int mid = totalLength / 2;
        int aindex = 0;
        int bindex = 0;
        int left = 0;
        int right = 0;
        //假如中位数位置为k，那么必然有一个数组的前k/2的数据小于等于中位数，不需要比较
        //x表示要删除的个数前k/2个元素

        int y = mid;
        int x = 0;
        if (y == 1) {
            x = 1;
        } else {
            x = (y) / 2;
        }
        if (y == 0) {
            right = b[bindex + y];
        } else {
            while (x > 0) {
                left = right;
                //a集合无元素时直接取b集合
                if (aindex == a.length) {
                    left = b[bindex + y - 1];
                    right = b[bindex + y];
                    break;
                }

                if (aindex + x <= a.length && (x + bindex > b.length || a[aindex + x - 1] < b[bindex + x - 1])) {
                    aindex += x;
                } else {
                    bindex += x;
                }
                if (aindex == a.length) {
                    left = a[aindex - 1];
                    right = b[bindex];
                } else if (bindex == b.length) {
                    left = b[bindex - 1];
                    right = a[aindex];
                } else {
                    right = Math.min(a[aindex], b[bindex]);
                }
                y = y - x;
                if (y == 1) {
                    x = 1;
                } else {
                    x = (y) / 2;
                }
            }

        }

        if ((totalLength & 1) == 0) {
            return (left + right) / 2f;
        } else {
            return right;
        }
    }

    //递归查询
    private static float recursiveFind(int[] a, int[] b) {
        //找两个有序数组中的第K大的数（数量为奇数需要找第K大，数量为偶数需要找第K和第K+1大）
        //在两个数组中先找 0 到K/2个数字，直到K/2为0
        int totalLength = a.length + b.length;
        int k = totalLength / 2;
        int x = k == 1 ? 1 : k / 2;
        if ((totalLength & 1) == 0) {
            return (recursive(a, 0, b, 0, x, k - 1) + recursive(a, 0, b, 0, x, k)) / 2.0f;
        }
        return recursive(a, 0, b, 0, x, k);
    }

    // x 表示两个数组中要向后移动的个数
    private static int recursive(int[] a, int aStart, int[] b, int bStart, int x, int k) {
        if (k == 0) {
            x = 0;
        }
        //边界减枝
        if (aStart == a.length) {
            return b[bStart + k];
        }
        if (bStart == b.length) {
            return a[aStart + k];
        }
        if (x == 0) {
            return Math.min(a[aStart], b[bStart]);
        }
        //偏序关系
        if (aStart + x <= a.length && (bStart + x > b.length || a[aStart + x - 1] < b[bStart + x - 1])) {
            aStart += x;
        } else {
            bStart += x;
        }
        k = k - x;
        x = k == 1 ? 1 : k / 2;
        return recursive(a, aStart, b, bStart, x, k);
    }

    //二分查找的时间复杂度为O(log2n)
    //先复习一下二分查找算法 寻找一个数x
    private static int binarySearch(int[] array, int x) {
        int left = 0;
        int mid = (array.length + 1) / 2;
        int right = array.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (x == array[mid]) {
                return mid;
            } else if (x > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("no");
        return 0;
    }

}
