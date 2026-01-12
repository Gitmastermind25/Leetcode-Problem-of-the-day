import java.util.Scanner;

public class problem39 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            int horizontalDistance = Math.abs(points[i][0] - points[i - 1][0]);
            int verticalDistance = Math.abs(points[i][1] - points[i - 1][1]);
            totalTime += Math.max(horizontalDistance, verticalDistance);
        }

        return totalTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        int[][] points = new int[n][2];

        System.out.println("Enter points as x y (space-separated):");
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        problem39 solution = new problem39();
        int result = solution.minTimeToVisitAllPoints(points);

        System.out.println("Minimum time to visit all points: " + result);
        sc.close();
    }
}
