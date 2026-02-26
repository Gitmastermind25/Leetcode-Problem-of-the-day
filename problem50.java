import java.util.Scanner;

public class problem50 {

    public static int numSteps(String s) {
        int n = s.length();
        int op = 0;
        int carry = 0;

        for (int i = n - 1; i >= 1; i--) {
            if (((s.charAt(i) - '0') + carry) % 2 == 1) { // odd
                op += 2;
                carry = 1;
            } else {
                op += 1;
            }
        }
        return op + carry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary string: ");
        String s = sc.nextLine();
        int result = numSteps(s);
        System.out.println("Number of steps: " + result);

        sc.close();
    }
}