public class problem2 {

    public static void main(String[] args) {

        // ▼▼▼  PUT YOUR INPUT ARRAY HERE  ▼▼▼
        int[] nums = {1, 2, 3, 4};
        // ▲▲▲  Change values for testing  ▲▲▲

        Solution sol = new Solution();
        int result = sol.countPartitions(nums);

        System.out.println("Valid partitions = " + result);
    }
}

class Solution {

    /**
     * Counts number of valid prefix partitions
     * where |leftSum - rightSum| is even.
     */
    public int countPartitions(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        // calculate total sum
        for (int num : nums) {
            rightSum += num;
        }

        int partitionCount = 0;

        // split positions from 0 to n-2
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if ((leftSum - rightSum) % 2 == 0) {
                partitionCount++;
            }
        }

        return partitionCount;
    }
}
