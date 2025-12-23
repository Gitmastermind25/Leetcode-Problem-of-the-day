import java.util.*;

class problem19 {

    public static int maxTwoEvents(int[][] events) {
        // Sort events by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        // Suffix array to store max value from index i to end
        int[] maxValueFromIndex = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            maxValueFromIndex[i] = Math.max(maxValueFromIndex[i + 1], events[i][2]);
        }

        int maxSum = 0;

        // Try taking each event as the first event
        for (int i = 0; i < n; i++) {
            int currentValue = events[i][2];
            int currentEndTime = events[i][1];

            // Binary search for next non-overlapping event
            int left = 0, right = n - 1;
            int firstTrueIndex = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > currentEndTime) {
                    firstTrueIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (firstTrueIndex != -1) {
                currentValue += maxValueFromIndex[firstTrueIndex];
            }

            maxSum = Math.max(maxSum, currentValue);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        // Sample Input
        int[][] events = {
                {1, 3, 4},
                {2, 5, 2},
                {4, 6, 4},
                {6, 7, 3}
        };

        int result = maxTwoEvents(events);

        // Output
        System.out.println("Maximum value from at most two non-overlapping events: " + result);
    }
}
