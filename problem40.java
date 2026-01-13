import java.util.*;

public class problem40 {

    public static double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        // Calculate total area and bounds
        for (int[] sq : squares) {
            double y = sq[1];
            double side = sq[2];
            totalArea += side * side;
            low = Math.min(low, y);
            high = Math.max(high, y + side);
        }

        double target = totalArea / 2.0;

        // Binary search
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] sq : squares) {
                double y = sq[1];
                double side = sq[2];

                if (mid <= y) {
                    continue;
                } else if (mid >= y + side) {
                    areaBelow += side * side;
                } else {
                    areaBelow += (mid - y) * side;
                }
            }

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] squares = new int[n][3];

        for (int i = 0; i < n; i++) {
            squares[i][0] = sc.nextInt(); // x
            squares[i][1] = sc.nextInt(); // y
            squares[i][2] = sc.nextInt(); // side
        }

        double result = separateSquares(squares);
        System.out.printf("%.5f%n", result);

        sc.close();
    }
}
