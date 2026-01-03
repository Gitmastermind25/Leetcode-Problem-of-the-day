public class problem30 {

    public static int numOfWays(int n) {
        long MOD = 1_000_000_007;

        // Base case for first row
        long abc = 6; // all 3 colors different
        long aba = 6; // first and third same

        for (int i = 2; i <= n; i++) {
            long newAbc = (abc * 2 + aba * 2) % MOD;
            long newAba = (abc * 2 + aba * 3) % MOD;
            abc = newAbc;
            aba = newAba;
        }

        return (int) ((abc + aba) % MOD);
    }

    public static void main(String[] args) {
        int n = 3; // you can change input here
        System.out.println("Number of ways: " + numOfWays(n));
    }
}
