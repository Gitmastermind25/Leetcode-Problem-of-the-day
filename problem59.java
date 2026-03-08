import java.util.*;

public class problem59 { // file name must match class name
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] nums = new String[n];
        System.out.println("Enter the binary strings (one per line):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLine();
        }

        String ans = findDifferentBinaryString(nums);
        System.out.println("Unique binary string: " + ans);
    }

    // Diagonal method: find a binary string different from all given strings
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = nums[i].charAt(i);
            result.append(ch == '0' ? '1' : '0');
        }

        return result.toString();
    }
}