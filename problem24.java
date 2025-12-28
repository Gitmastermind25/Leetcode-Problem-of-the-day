import java.util.Scanner;

public class problem24 {

    /**
     * Count negative numbers in a sorted matrix.
     * Uses binary search on each row to find the first negative.
     *
     * Time Complexity: O(m log n)
     * Space Complexity: O(1)
     */
    public static int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalCount = 0;

        // Apply binary search on each row
        for (int row = 0; row < rows; row++) {
            int left = 0;
            int right = cols - 1;
            int firstNegativeIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (grid[row][mid] < 0) {
                    firstNegativeIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (firstNegativeIndex != -1) {
                totalCount += cols - firstNegativeIndex;
            }
        }

        return totalCount;
    }

    // Main method with input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter matrix elements (row-wise):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = countNegatives(grid);
        System.out.println("Total negative numbers: " + result);

        sc.close();
    }
}
