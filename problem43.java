import java.util.*;

public class problem43 {

    public static boolean carPooling(int[][] trips, int capacity) {

        int[] diff = new int[1001];

        for (int[] trip : trips) {
            int count = trip[0];
            int start = trip[1];
            int end = trip[2];

            diff[start] += count;
            diff[end] -= count;
        }

        int cumSum = 0;

        for (int i = 0; i < 1001; i++) {
            cumSum += diff[i];
            if (cumSum > capacity) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // number of trips
        int n = sc.nextInt();

        int[][] trips = new int[n][3];

        // input trips
        for (int i = 0; i < n; i++) {
            trips[i][0] = sc.nextInt(); // passengers
            trips[i][1] = sc.nextInt(); // start
            trips[i][2] = sc.nextInt(); // end
        }

        // capacity input
        int capacity = sc.nextInt();

        boolean ans = carPooling(trips, capacity);

        System.out.println(ans);

        sc.close();
    }
}
