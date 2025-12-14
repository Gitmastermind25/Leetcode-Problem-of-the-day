public class problem10 {
    public static void main(String[] args) {
        // Example input array
        int[] balance = {2, -5, 3, 1};

        long result = minMoves(balance);
        System.out.println("Minimum moves needed: " + result);
    }

    public static long minMoves(int[] balance) {
        int n = balance.length;
        int culpritIndex = -1;
        long sum = 0;

        // Find last negative index and total sum
        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                culpritIndex = i;
            }
        }

        // No negative balance
        if (culpritIndex == -1) return 0;

        // Impossible case
        if (sum < 0) return -1;

        long moves = 0;
        int dist = 1;

        // Fix negative balance
        while (balance[culpritIndex] < 0) {
            int right = (culpritIndex + dist) % n;
            int left = (culpritIndex - dist + n) % n;

            long available = balance[left] + balance[right];
            if (left == right) available -= balance[right]; // avoid double counting

            long needed = -balance[culpritIndex];
            long taken = Math.min(needed, available);

            moves += taken * dist;
            balance[culpritIndex] += taken;

            dist++;
        }

        return moves;
    }
}
