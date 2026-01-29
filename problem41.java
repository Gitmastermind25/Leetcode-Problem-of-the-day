import java.util.*;

public class problem41 {

    public static void main(String[] args) {
        problem41 sol = new problem41();
        String source = "abcd";
        String target = "bcde";

        char[] original = {'a', 'b', 'c', 'd'};
        char[] changed  = {'b', 'c', 'd', 'e'};
        int[] cost      = {1, 1, 1, 1};

        long ans = sol.minimumCost(source, target, original, changed, cost);

        System.out.println("Minimum Cost: " + ans);
    }

    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            graph.get(u).add(new int[]{v, cost[i]});
        }

        long[][] d = floyd(graph);
        long total = 0;

        for (int i = 0; i < source.length(); i++) {
            int src = source.charAt(i) - 'a';
            int dest = target.charAt(i) - 'a';

            if (src != dest) {
                if (d[src][dest] == Long.MAX_VALUE) {
                    return -1;
                }
                total += d[src][dest];
            }
        }
        return total;
    }

    public long[][] floyd(List<List<int[]>> graph) {
        long[][] d = new long[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(d[i], Long.MAX_VALUE);
        }

        for (int i = 0; i < 26; i++) {
            for (int[] nei : graph.get(i)) {
                d[i][nei[0]] = Math.min(d[i][nei[0]], nei[1]);
            }
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (d[i][k] != Long.MAX_VALUE && d[k][j] != Long.MAX_VALUE) {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        return d;
    }
}
