public class problem2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution sol = new Solution();
        int result = sol.countPartitions(nums);
        System.out.println("Valid partitions = " + result);
    }
}
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i=0; i<=n-2; i++){
            sum+= nums[i];
        }
        int result = 0;
        int leftSum = 0;
        for (int i = 0; i <= n - 2; i++) {
            leftSum += nums[i];

            int rightSum = sum - leftSum;

            if ((leftSum - rightSum) % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}
