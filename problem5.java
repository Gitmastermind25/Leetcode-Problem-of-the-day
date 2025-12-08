import java.util.*;

public class problem5 {

    public static int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);

                if (c * c == c2 && c <= n) {
                    count += (a == b) ? 1 : 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        // 🔹 INPUT INSIDE CODE
        int n = 10;   // <-- change this value to test

        int ans = countTriples(n);
        System.out.println("Number of square sum triples = " + ans);
    }
}
