
import java.util.Scanner;

public class problem42 {

    public static int findClosest(int x, int y, int z) {

        if (Math.abs(x - z) == Math.abs(y - z)) {
            return 0;
        }

        if (Math.abs(x - z) < Math.abs(y - z)) {
            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        // function call
        int result = findClosest(x, y, z);

        // output
        System.out.println(result);
    }
}
