package leetcode;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    static int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        Map<Integer, Integer> num = new Hashtable<>();
        int[] result = new int[2];
        for (int i = 0; i < l; i++) {
            if (num.containsKey(target - nums[i])) {
                result[0] = num.get(target - nums[i]);
                result[1] = i;
            }
            num.put(nums[i], i);
        }
        return result;
    }
}
