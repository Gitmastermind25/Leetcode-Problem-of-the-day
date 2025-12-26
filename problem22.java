import java.util.Scanner;
public class problem22 {

    public static int bestClosingTime(String customers) {
        int n = customers.length();

        // Prefix sum to count 'Y'
        int[] prefixY = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixY[i + 1] = prefixY[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        int bestHour = 0;
        int minPenalty = Integer.MAX_VALUE;

        // Check every possible closing hour
        for (int hour = 0; hour <= n; hour++) {
            int penalty =
                    (hour - prefixY[hour])      // 'N' before closing
                            + (prefixY[n] - prefixY[hour]); // 'Y' after closing

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = hour;
            }
        }
        return bestHour;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example input: YYNY
        System.out.print("Enter customer sequence (Y/N): ");
        String customers = sc.nextLine();

        System.out.println("Best Closing Hour: " + bestClosingTime(customers));
        sc.close();
    }
}
