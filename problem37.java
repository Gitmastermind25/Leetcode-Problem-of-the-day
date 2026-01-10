import java.util.Scanner;

public class problem37 {

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] represents the minimum ASCII sum of deleted characters
        // to make s1[0...i-1] and s2[0...j-1] equal
        int[][] dp = new int[m + 1][n + 1];

        // Initialize first column (delete all chars from s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // Initialize first row (delete all chars from s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + s1.charAt(i - 1), // delete from s1
                            dp[i][j - 1] + s2.charAt(j - 1)  // delete from s2
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two strings
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        // Output result
        System.out.println(minimumDeleteSum(s1, s2));

        sc.close();
    }
}
