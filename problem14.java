import java.util.*;

class Solution {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long actualProfit = 0;
        long[] profit = new long[n]; // original profit of each day

        // Calculate original profit
        for (int i = 0; i < n; i++) {
            profit[i] = (long) strategy[i] * prices[i];
            actualProfit += profit[i];
        }

        long originalWindowProfit = 0;
        long modifiedWindowProfit = 0;
        long maxGain = 0;

        int i = 0, j = 0;

        // Sliding window
        while (j < n) {

            // Add current element to original window
            originalWindowProfit += profit[j];

            // Second half of window → SELL
            if (j - i + 1 > k / 2) {
                modifiedWindowProfit += prices[j];
            }

            // Shrink window if size exceeds k
            if (j - i + 1 > k) {
                originalWindowProfit -= profit[i];
                modifiedWindowProfit -= prices[i + k / 2];
                i++;
            }

            // Evaluate window of exact size k
            if (j - i + 1 == k) {
                maxGain = Math.max(
                    maxGain,
                    modifiedWindowProfit - originalWindowProfit
                );
            }

            j++;
        }

        return actualProfit + maxGain;
    }
}
