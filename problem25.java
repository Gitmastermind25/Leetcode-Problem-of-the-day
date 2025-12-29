import java.util.*;

public class problem25 {

    static Map<String, Boolean> memo = new HashMap<>();

    private static boolean solve(String curr,
                                 Map<String, List<Character>> map,
                                 int idx,
                                 String above) {

        // Base case: pyramid completed
        if (curr.length() == 1) {
            return true;
        }

        String key = curr + "_" + idx + "_" + above;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Move to next row
        if (idx == curr.length() - 1) {
            boolean res = solve(above, map, 0, "");
            memo.put(key, res);
            return res;
        }

        String pair = curr.substring(idx, idx + 2);

        if (!map.containsKey(pair)) {
            memo.put(key, false);
            return false;
        }

        for (char ch : map.get(pair)) {
            if (solve(curr, map, idx + 1, above + ch)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input bottom string
        System.out.print("Enter bottom string: ");
        String bottom = sc.nextLine();

        // Number of allowed patterns
        System.out.print("Enter number of allowed patterns: ");
        int n = sc.nextInt();

        List<String> allowed = new ArrayList<>();
        System.out.println("Enter allowed patterns (e.g. ABC):");
        for (int i = 0; i < n; i++) {
            allowed.add(sc.next());
        }

        // Build map
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            map.computeIfAbsent(s.substring(0, 2),
                            k -> new ArrayList<>())
                    .add(s.charAt(2));
        }

        boolean result = solve(bottom, map, 0, "");

        System.out.println("Pyramid possible: " + result);
        sc.close();
    }
}
