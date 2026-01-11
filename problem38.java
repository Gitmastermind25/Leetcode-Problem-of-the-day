import java.util.*;

public class problem38 {

    /**
     * Finds the largest rectangle containing only 1's in a binary matrix.
     */
    public static int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        // Build histogram row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    /**
     * Largest rectangle in histogram using monotonic stack.
     */
    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

    /**
     * MAIN METHOD – input handling added
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read dimensions
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine(); // consume newline

        char[][] matrix = new char[rows][cols];

        // Read matrix
        for (int i = 0; i < rows; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        // Compute and print result
        int result = maximalRectangle(matrix);
        System.out.println(result);

        sc.close();
    }
}
