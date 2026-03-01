import java.util.Scanner;

public class problem52 {

    public int minPartitions(String n) {

        char maxCh = '0';

        for (char ch : n.toCharArray()) {
            maxCh = (char) Math.max(maxCh, ch);
        }

        return maxCh - '0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        String n = sc.nextLine();

        problem52 obj = new problem52();
        int result = obj.minPartitions(n);

        System.out.println("Minimum partitions: " + result);

        sc.close();
    }
}