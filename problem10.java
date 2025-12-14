import java.util.Scanner;

public class problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of balances: ");
        int n = sc.nextInt();

        int[] balance = new int[n];
        System.out.println("Enter the balances (space-separated, can be negative):");
        for (int i = 0; i < n; i++) {
            balance[i] = sc.nextInt();
        }

        long result = minMoves(balance);

        System.out.println("Minimum moves needed: " + result);

        sc.close();
    }

    // Function directly inside the public class
    public static long minMoves(int[] balance) {
        int n = balance.length;
        int culpritIndex = -1;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                culpritIndex = i;
            }
        }

        if (culpritIndex == -1) return 0;  // No negative balance
        if (sum < 0) return -1;            // Impossible to fix

        long moves = 0;
        int distance = 1;

        while (balance[culpritIndex] < 0) {
            int right = (culpritIndex + distance) % n;
            int left = (culpritIndex - distance + n) % n;

            long leftVal = balance[left];
            long rightVal = balance[right];

            long available = leftVal + rightVal;
            if (left == right) available = rightVal;

            long needed = -balance[culpritIndex];
            long taken = Math.min(needed, available);

            moves += taken * distance;
            balance[culpritIndex] += taken;

            distance++;
        }

        return moves;
    }
}
