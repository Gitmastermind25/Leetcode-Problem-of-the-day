import java.util.*;
public class problem8 {
    public static void main(String[] args) {
        // Hardcoded input
        int n = 5;
        int[][] buildings = {
                {1, 2},
                {2, 2},
                {3, 2},
                {2, 1},
                {2, 3}
        };
        int ans = countCoveredBuildings(n, buildings);
        System.out.println(ans);
    }
    public static int countCoveredBuildings(int n, int[][] buildings) {
        // y → (minX, maxX)
        Map<Integer, int[]> yToMinMaxX = new HashMap<>();
        // x → (minY, maxY)
        Map<Integer, int[]> xToMinMaxY = new HashMap<>();
        // 1. Build min-max ranges
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            yToMinMaxX.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int[] xr = yToMinMaxX.get(y);
            xr[0] = Math.min(xr[0], x);
            xr[1] = Math.max(xr[1], x);

            xToMinMaxY.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            int[] yr = xToMinMaxY.get(x);
            yr[0] = Math.min(yr[0], y);
            yr[1] = Math.max(yr[1], y);
        }
        // 2. Count covered buildings
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            int[] xr = yToMinMaxX.get(y);
            int[] yr = xToMinMaxY.get(x);

            if (xr[0] < x && x < xr[1] && yr[0] < y && y < yr[1]) {
                count++;
            }
        }

        return count;
    }
}
