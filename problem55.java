import java.util.Scanner;

public class problem55 {

    // Solution method
    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count number of 1s in each row and column
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int result = 0;

        // Check special positions
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 1 &&
                        rowCount[row] == 1 &&
                        colCount[col] == 1) {

                    result++;
                }
            }
        }

        return result;
    }

    // Main method (Input handling)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows:");
        int m = sc.nextInt();

        System.out.println("Enter number of columns:");
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        System.out.println("Enter matrix elements (0 or 1):");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int result = numSpecial(mat);

        System.out.println("Number of special positions: " + result);

        sc.close();
    }
}