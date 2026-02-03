import java.util.*;

class Solution {

    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Phase 1: Increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;

        if (i == 0 || i == n - 1) return false;

        // Phase 2: Decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) i++;

        if (i == n - 1) return false;

        // Phase 3: Increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;

        return i == n - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements (space separated):");
        String line = sc.nextLine();

        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        if (isTrionic(nums))
            System.out.println("Trionic array");
        else
            System.out.println("Not a trionic array");

        sc.close();
    }
}
