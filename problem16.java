import java.util.*;

public class problem16 {

    public static int minDeletionSize(String[] strs) {
        // Get dimensions
        int columnCount = strs[0].length();
        int rowCount = strs.length;

        int deletionCount = 0;

        // Iterate through each column
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
                if (strs[rowIndex].charAt(columnIndex) <
                        strs[rowIndex - 1].charAt(columnIndex)) {
                    deletionCount++;
                    break;
                }
            }
        }

        return deletionCount;
    }

    public static void main(String[] args) {
        // Input
        String[] strs = {"cba", "daf", "ghi"};

        // Function call
        int result = minDeletionSize(strs);

        // Output
        System.out.println("Minimum columns to delete: " + result);
    }
}
