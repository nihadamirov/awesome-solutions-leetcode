package leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int index = search(nums, target);
        System.out.println(index);
    }

        static int search(int[] nums, int target) {
            int mid = 0, low = 0;
            int high = nums.length - 1;
            while(low <= high) {
                mid = (low + high)/2;
                if(target == nums[mid])
                    return mid;
                else
                if(nums[mid] > target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            return -1;
        }
}
