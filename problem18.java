import java.util.*;

class problem18 {

    public static int minDeletionSize(String[] strs) {
        int columnCount = strs[0].length();

        // dp[i] = length of longest valid sequence ending at column i
        int[] dp = new int[columnCount];
        Arrays.fill(dp, 1);

        for (int currentCol = 1; currentCol < columnCount; currentCol++) {
            for (int previousCol = 0; previousCol < currentCol; previousCol++) {

                boolean isNonDecreasing = true;
                for (String str : strs) {
                    if (str.charAt(previousCol) > str.charAt(currentCol)) {
                        isNonDecreasing = false;
                        break;
                    }
                }

                if (isNonDecreasing) {
                    dp[currentCol] = Math.max(dp[currentCol], dp[previousCol] + 1);
                }
            }
        }

        int maxIncreasingLength = 0;
        for (int val : dp) {
            maxIncreasingLength = Math.max(maxIncreasingLength, val);
        }

        return columnCount - maxIncreasingLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of strings
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input strings
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        int result = minDeletionSize(strs);
        System.out.println(result);

        sc.close();
    }
}
