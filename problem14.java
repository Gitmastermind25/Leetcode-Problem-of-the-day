import java.util.*;

public class problem14 {

    // Method to calculate maximum profit
    public static long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        // dp[day][transactionCount][state]
        // state: 0 = no stock, 1 = holding stock
        long[][][] dp = new long[n][k + 1][2];

        // Initialization
        for (int t = 0; t <= k; t++) {
            dp[0][t][0] = 0;
            dp[0][t][1] = -prices[0];
        }

        // DP computation
        for (int day = 1; day < n; day++) {
            for (int t = 0; t <= k; t++) {

                // Not holding stock
                dp[day][t][0] = dp[day - 1][t][0];
                if (t > 0) {
                    dp[day][t][0] = Math.max(
                            dp[day][t][0],
                            dp[day - 1][t - 1][1] + prices[day]
                    );
                }

                // Holding stock
                dp[day][t][1] = Math.max(
                        dp[day - 1][t][1],
                        dp[day - 1][t][0] - prices[day]
                );
            }
        }

        long ans = 0;
        for (int t = 0; t <= k; t++) {
            ans = Math.max(ans, dp[n - 1][t][0]);
        }
        return ans;
    }

    // Main method with input
    public static void main(String[] args) {

        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;

        long result = maximumProfit(prices, k);
        System.out.println("Maximum Profit = " + result);
    }
}
