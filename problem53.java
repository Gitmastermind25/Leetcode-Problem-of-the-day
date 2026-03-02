import java.util.*;

public class problem53 {

    public static int minSwaps(int[][] grid) {

        int n = grid.length; // rows == columns

        int[] endZeros = new int[n];
        // endZeros[i] = count of consecutive 0s from the end of ith row

        for (int i = 0; i < n; i++) {
            int j = n - 1; // start from end

            int count = 0;
            while (j >= 0 && grid[i][j] == 0) {
                count++;
                j--;
            }

            endZeros[i] = count;
        }

        int steps = 0;

        for (int i = 0; i < n; i++) {

            int need = n - i - 1;

            int j = i;

            while (j < n && endZeros[j] < need) {
                j++;
            }

            if (j == n) {
                return -1;
            }

            steps += (j - i);

            while (j > i) {
                int temp = endZeros[j];
                endZeros[j] = endZeros[j - 1];
                endZeros[j - 1] = temp;
                j--;
            }
        }

        return steps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (size of grid): ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter grid values (0 or 1):");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = minSwaps(grid);

        System.out.println("Minimum Swaps: " + result);

        sc.close();
    }
}