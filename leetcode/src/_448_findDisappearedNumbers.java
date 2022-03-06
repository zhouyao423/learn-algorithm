import java.util.ArrayList;
import java.util.List;

public class _448_findDisappearedNumbers {
    public static void main(String[] args) {
        _448_findDisappearedNumbers a = new _448_findDisappearedNumbers();
        List<Integer> disappearedNumbers = a.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(disappearedNumbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            nums[(num-1)%nums.length] +=nums.length;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<nums.length){
                res.add(i+1);
            }
        }
        return res;
    }
}
