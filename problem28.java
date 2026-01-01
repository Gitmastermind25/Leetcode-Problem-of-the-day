import java.util.Arrays;

public class problem28 {

    // Function to add one to the number
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Start from last digit (LSB)
        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // If digit is 9, make it 0 and continue carry
            digits[i] = 0;
        }

        // If all digits were 9 (e.g., 999 → 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {

        // INPUT (you can change this)
        int[] digits = {9, 9, 9};

        // FUNCTION CALL
        int[] answer = plusOne(digits);

        // OUTPUT
        System.out.println("Result: " + Arrays.toString(answer));
    }
}
