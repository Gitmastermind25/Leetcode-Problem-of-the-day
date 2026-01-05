import java.util.*;

public class problem32 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of matrix
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        // Input matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        long sum = 0;
        int countNegatives = 0;
        int smallestAbsoluteValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];

                sum += Math.abs(val);

                if (val < 0) {
                    countNegatives++;
                }

                smallestAbsoluteValue = Math.min(
                        smallestAbsoluteValue,
                        Math.abs(val)
                );
            }
        }

        // Output result
        if (countNegatives % 2 == 0) {
            System.out.println(sum);
        } else {
            System.out.println(sum - 2L * smallestAbsoluteValue);
        }

        sc.close();
    }
}
