import java.util.*;

public class problem21 {

    public static void main(String[] args) {

        // Directly given input
        int[] happiness = {1, 2, 3, 4, 5};
        int k = 3;

        Arrays.sort(happiness);

        long totalHappiness = 0;
        int n = happiness.length;

        for (int i = 0; i < k; i++) {
            int adjustedHappiness = happiness[n - 1 - i] - i;
            totalHappiness += Math.max(adjustedHappiness, 0);
        }

        System.out.println(totalHappiness);
    }
}
