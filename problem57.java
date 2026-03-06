import java.util.Scanner;

public class problem57 {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input
        String s = sc.nextLine();

        problem57 obj = new problem57();

        // Call method
        boolean result = obj.checkOnesSegment(s);

        // Print result
        System.out.println(result);

        sc.close();
    }
}