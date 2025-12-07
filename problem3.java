import java.util.*;

public class problem3 {

    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter low: ");
        int low = sc.nextInt();

        System.out.print("Enter high: ");
        int high = sc.nextInt();

        // Calling the function
        problem3 obj = new problem3();
        int result = obj.countOdds(low, high);

        // Output
        System.out.println("Odd count = " + result);
    }
}
