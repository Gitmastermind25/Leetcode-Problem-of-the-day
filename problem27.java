import java.util.*;

public class problem27 {

    static int ROW, COL;
    static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) {

        // -------- INPUT SECTION --------
        int row = 2;
        int col = 2;

        int[][] cells = {
                {1, 1},
                {2, 1},
                {1, 2},
                {2, 2}
        };
        // --------------------------------

        problem27 obj = new problem27();
        int result = obj.latestDayToCross(row, col, cells);

        System.out.println("Last Day You Can Still Cross: " + result);
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;

        int left = 0, right = cells.length - 1;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(cells, mid)) {
                ans = mid + 1;   // day is 1-based
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int[][] cells, int mid) {
        int[][] grid = new int[ROW][COL];

        // Flood till day = mid
        for (int i = 0; i <= mid; i++) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = 1;
        }

        // BFS from top row
        for (int j = 0; j < COL; j++) {
            if (grid[0][j] == 0 && bfs(grid, 0, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 1; // visited

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == ROW - 1) return true;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < ROW && ny >= 0 && ny < COL && grid[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    grid[nx][ny] = 1;
                }
            }
        }
        return false;
    }
}
