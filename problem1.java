import java.util.*;

public class problem1 {   // class name matches file name
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directions: ");
        String directions = sc.nextLine();

        problem1 sol = new problem1();
        int collisions = sol.countCollisions(directions);

        System.out.println("Collisions = " + collisions);
    }

    public int countCollisions(String directions) {
        int n = directions.length();

        int i = 0;
        // Skip leading 'L'
        while (i < n && directions.charAt(i) == 'L') i++;

        int j = n - 1;
        // Skip trailing 'R'
        while (j >= 0 && directions.charAt(j) == 'R') j--;

        int collisions = 0;

        // Count non-'S' between i and j
        while (i <= j) {
            if (directions.charAt(i) != 'S') collisions++;
            i++;
        }

        return collisions;
    }
}
