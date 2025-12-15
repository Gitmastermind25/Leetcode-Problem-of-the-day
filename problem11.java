public class problem11 {

    public static void main(String[] args) {

        // INPUT IN CODE
        int[] prices = {3, 2, 1, 4};

        long result = getDescentPeriods(prices);
        System.out.println(result);
    }

    public static long getDescentPeriods(int[] prices) {

        long result = 1;
        long count = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count++;
            } else {
                count = 1;
            }
            result += count;
        }

        return result;
    }
}
