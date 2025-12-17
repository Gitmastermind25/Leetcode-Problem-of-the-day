public class problem13 {

    public static void main(String[] args) {

        // INPUT
        int[] prices = {1, 3, 2, 8, 4, 9};
        int k = 2;

        // Call the method
        MaxProfitDP obj = new MaxProfitDP();
        long ans = obj.maximumProfit(prices, k);

        // OUTPUT
        System.out.println(ans);
    }
}

class MaxProfitDP {

    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        // dp[day][transactionCount][state]
        // state: 0 = no stock, 1 = holding stock (bought), 2 = holding stock (shorted)
        long[][][] dp = new long[n][k + 1][3];

        // Initialize first day
        for (int txn = 1; txn <= k; txn++) {
            dp[0][txn][1] = -prices[0]; // buy
            dp[0][txn][2] = prices[0];  // short
        }

        // DP computation
        for (int day = 1; day < n; day++) {
            for (int txn = 1; txn <= k; txn++) {

                // No stock
                dp[day][txn][0] = Math.max(
                        dp[day - 1][txn][0],
                        Math.max(
                                dp[day - 1][txn][1] + prices[day],
                                dp[day - 1][txn][2] - prices[day]
                        )
                );

                // Holding bought stock
                dp[day][txn][1] = Math.max(
                        dp[day - 1][txn][1],
                        dp[day - 1][txn - 1][0] - prices[day]
                );

                // Holding shorted stock
                dp[day][txn][2] = Math.max(
                        dp[day - 1][txn][2],
                        dp[day - 1][txn - 1][0] + prices[day]
                );
            }
        }

        return dp[n - 1][k][0];
    }
}
