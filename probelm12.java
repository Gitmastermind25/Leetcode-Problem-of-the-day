import java.util.*;

class problem12 {

    int n, budget;
    int[] present, future;
    List<Integer>[] tree;

    // memo[u][0] -> dp without discount
    // memo[u][1] -> dp with discount
    int[][][] memo;
    boolean[] visited;

    public int maxProfit(
            int n,
            int[] present,
            int[] future,
            int[][] hierarchy,
            int budget
    ) {
        this.n = n;
        this.present = present;
        this.future = future;
        this.budget = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        // Build tree (1-based → 0-based)
        for (int[] e : hierarchy) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            tree[u].add(v);
        }

        memo = new int[n][2][budget + 1];
        visited = new boolean[n];

        int[] rootDp = dfs(0)[0];
        int ans = 0;
        for (int val : rootDp) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

    private int[][] dfs(int u) {
        if (visited[u]) {
            return memo[u];
        }
        visited[u] = true;

        int[] noDiscount = new int[budget + 1];
        int[] withDiscount = new int[budget + 1];

        for (int v : tree[u]) {
            int[][] child = dfs(v);
            noDiscount = merge(noDiscount, child[0]);
            withDiscount = merge(withDiscount, child[1]);
        }

        int[] newDp0 = Arrays.copyOf(noDiscount, budget + 1);
        int[] newDp1 = Arrays.copyOf(noDiscount, budget + 1);

        // Buy current node at full cost
        int fullCost = present[u];
        int profitFull = future[u] - fullCost;
        for (int b = fullCost; b <= budget; b++) {
            newDp0[b] = Math.max(
                    newDp0[b],
                    withDiscount[b - fullCost] + profitFull
            );
        }

        // Buy current node at half cost (discounted)
        int halfCost = present[u] / 2;
        int profitHalf = future[u] - halfCost;
        for (int b = halfCost; b <= budget; b++) {
            newDp1[b] = Math.max(
                    newDp1[b],
                    withDiscount[b - halfCost] + profitHalf
            );
        }

        memo[u][0] = newDp0;
        memo[u][1] = newDp1;
        return memo[u];
    }

    private int[] merge(int[] A, int[] B) {
        int[] res = new int[budget + 1];
        Arrays.fill(res, Integer.MIN_VALUE);

        for (int i = 0; i <= budget; i++) {
            if (A[i] == Integer.MIN_VALUE) continue;
            for (int j = 0; i + j <= budget; j++) {
                if (B[j] == Integer.MIN_VALUE) continue;
                res[i + j] = Math.max(res[i + j], A[i] + B[j]);
            }
        }
        return res;
    }

    // Optional main method for local IntelliJ testing
    public static void main(String[] args) {
        problem12 sol = new problem12();

        int n = 3;
        int[] present = {4, 2, 6};
        int[] future = {7, 3, 9};
        int[][] hierarchy = {
                {1, 2},
                {1, 3}
        };
        int budget = 6;

        System.out.println(sol.maxProfit(n, present, future, hierarchy, budget));
    }
}
