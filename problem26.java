import java.util.Scanner;

public class problem26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(numMagicSquaresInside(grid));
        sc.close();
    }

    public static int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isMagic(int[][] g, int r, int c) {
        boolean[] seen = new boolean[10];

        // check 1 to 9 and uniqueness
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        // rows
        for (int i = 0; i < 3; i++)
            if (g[r+i][c] + g[r+i][c+1] + g[r+i][c+2] != 15) return false;

        // columns
        for (int j = 0; j < 3; j++)
            if (g[r][c+j] + g[r+1][c+j] + g[r+2][c+j] != 15) return false;

        // diagonals
        return g[r][c] + g[r+1][c+1] + g[r+2][c+2] == 15 &&
                g[r][c+2] + g[r+1][c+1] + g[r+2][c] == 15;
    }
}
