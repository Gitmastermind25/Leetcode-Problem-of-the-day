import java.util.*;

public class problem33 {

    // Function for LeetCode Problem 33
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // 🔹 INPUT (hardcoded)
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        // 🔹 FUNCTION CALL
        int result = search(nums, target);

        // 🔹 OUTPUT
        System.out.println("Index of target: " + result);
    }
}
