import java.util.*;

public class problem23 {

    public static int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Busy rooms: [endTime, roomNumber]
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        // Available rooms (min room number first)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free rooms that have completed meetings
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                availableRooms.offer(busyRooms.poll()[1]);
            }

            int room;
            if (!availableRooms.isEmpty()) {
                room = availableRooms.poll();
                busyRooms.offer(new int[]{end, room});
            } else {
                int[] earliest = busyRooms.poll();
                room = earliest[1];
                int newEnd = earliest[0] + (end - start);
                busyRooms.offer(new int[]{newEnd, room});
            }

            meetingCount[room]++;
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (meetingCount[i] > meetingCount[ans]) {
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of rooms
        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        // Input number of meetings
        System.out.print("Enter number of meetings: ");
        int m = sc.nextInt();

        int[][] meetings = new int[m][2];

        System.out.println("Enter meeting start and end times:");
        for (int i = 0; i < m; i++) {
            meetings[i][0] = sc.nextInt();
            meetings[i][1] = sc.nextInt();
        }

        int result = mostBooked(n, meetings);
        System.out.println("Most booked room: " + result);

        sc.close();
    }
}
