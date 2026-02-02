import java.util.*;

public class problem45 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // If low goes past the array, wrap around to the first letter
        return letters[low % letters.length];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter letters (sorted, no spaces, e.g., cfj): ");
        String input = sc.nextLine();
        char[] letters = input.toCharArray();

        System.out.print("Enter target character: ");
        char target = sc.next().charAt(0);

        char result = nextGreatestLetter(letters, target);
        System.out.println("Smallest letter greater than target: " + result);
        sc.close();
    }
}
