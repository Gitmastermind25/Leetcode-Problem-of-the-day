import java.util.*;

class problem15 {

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        boolean[] vis = new boolean[n];
        vis[0] = true;
        vis[firstPerson] = true;

        int m = meetings.length;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < m;) {
            int j = i;
            while (j + 1 < m && meetings[j + 1][2] == meetings[i][2]) {
                j++;
            }

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            for (int k = i; k <= j; k++) {
                int x = meetings[k][0];
                int y = meetings[k][1];

                graph.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, key -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            for (int p : people) {
                if (vis[p]) {
                    queue.offer(p);
                }
            }

            while (!queue.isEmpty()) {
                int u = queue.poll();
                for (int v : graph.getOrDefault(u, new ArrayList<>())) {
                    if (!vis[v]) {
                        vis[v] = true;
                        queue.offer(v);
                    }
                }
            }

            i = j + 1;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        // -------- INPUT --------
        int n = 6;
        int[][] meetings = {
                {1, 2, 5},
                {2, 3, 8},
                {1, 5, 10}
        };
        int firstPerson = 1;

        // -------- FUNCTION CALL --------
        List<Integer> result = findAllPeople(n, meetings, firstPerson);

        // -------- OUTPUT --------
        System.out.println(result);
    }
}
