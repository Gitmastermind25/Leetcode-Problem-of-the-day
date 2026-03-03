import java.util.Scanner;

public class problem54 {

    // Function to find kth bit
    public static char findKthBit(int n, int k) {

        // Base case
        if (n == 1) {
            return '0';
        }

        int length = (1 << n) - 1;   // 2^n - 1
        int mid = (length + 1) / 2;  // middle position

        if (k < mid) {
            return findKthBit(n - 1, k);
        }
        else if (k == mid) {
            return '1';
        }
        else {
            char ch = findKthBit(n - 1, length - k + 1);
            return (ch == '0') ? '1' : '0';  // flip bit
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        char result = findKthBit(n, k);

        System.out.println("Answer: " + result);

        sc.close();
    }
}