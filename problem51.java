import java.util.Scanner;

public class problem51 {

    public static int concatenatedBinary(int n) {
        long ans = 0;
        int mod = 1000000007;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {

            // If i is power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            ans = ((ans << bitLength) + i) % mod;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int result = concatenatedBinary(n);
        System.out.println("Result: " + result);

        sc.close();
    }
}