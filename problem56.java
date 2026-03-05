import java.util.Scanner;

public class problem56 {

    public static int minOperations(String s) {
        int n = s.length();
        int start_with_0 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    start_with_0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    start_with_0++;
                }
            }
        }

        return Math.min(start_with_0, n - start_with_0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        // Calling function
        int result = minOperations(s);

        // Printing output
        System.out.println("Minimum operations required: " + result);

        sc.close();
    }
}