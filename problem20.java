import java.util.*;

public class problem20 {

    public static int minimumBoxes(int[] apple, int[] capacity) {

        // Sort capacity array
        Arrays.sort(capacity);

        // Calculate total apples
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        int boxCount = 0;
        int n = capacity.length;

        // Use boxes from largest to smallest
        while (totalApples > 0) {
            totalApples -= capacity[n - 1 - boxCount];
            boxCount++;
        }

        return boxCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input apples (space-separated)
        String[] appleInput = sc.nextLine().split(" ");
        int[] apple = new int[appleInput.length];
        for (int i = 0; i < appleInput.length; i++) {
            apple[i] = Integer.parseInt(appleInput[i]);
        }

        // Input capacities (space-separated)
        String[] capacityInput = sc.nextLine().split(" ");
        int[] capacity = new int[capacityInput.length];
        for (int i = 0; i < capacityInput.length; i++) {
            capacity[i] = Integer.parseInt(capacityInput[i]);
        }

        System.out.println(minimumBoxes(apple, capacity));

        sc.close();
    }
}
