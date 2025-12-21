import java.util.*;

public class problem17 {

    public static int minDeletionSize(String[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }

        int n = A.length;
        int m = A[0].length();
        int deletedColumns = 0;

        // sorted[i] means A[i] < A[i+1] already confirmed
        boolean[] sorted = new boolean[n - 1];

        // Check column by column
        columnLoop:
        for (int col = 0; col < m; col++) {

            // Check if this column violates order
            for (int row = 0; row < n - 1; row++) {
                if (!sorted[row] && A[row].charAt(col) > A[row + 1].charAt(col)) {
                    deletedColumns++;
                    continue columnLoop;
                }
            }

            // Update sorted status
            for (int row = 0; row < n - 1; row++) {
                if (A[row].charAt(col) < A[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }

        return deletedColumns;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] A = new String[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLine();
        }

        System.out.println(minDeletionSize(A));
        sc.close();
    }
}
