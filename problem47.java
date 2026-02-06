import java.util.*;

public class problem47 {

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            ans[i] = nums[(i + nums[i] % n + n) % n];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: space-separated numbers
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");

        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int[] result = constructTransformedArray(nums);

        // Output
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
