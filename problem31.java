import java.util.*;

public class problem31 {

    private static int findSumDivisors(int num) {
        int divisors = 0;
        int sum = 0;

        for (int fact = 1; fact * fact <= num; fact++) {
            if (num % fact == 0) {
                int other = num / fact;

                if (fact == other) {   // perfect square
                    divisors = divisors + 1;
                    sum = sum + fact;
                } else {
                    divisors = divisors + 2;
                    sum = sum + fact + other;
                }
            }

            if (divisors > 4) {
                return 0;   // invalid
            }
        }

        if (divisors == 4) {
            return sum;
        } else {
            return 0;
        }
    }

    public static int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = result + findSumDivisors(num);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {21, 4, 7};

        int answer = sumFourDivisors(nums);
        System.out.println("Sum of numbers with exactly 4 divisors: " + answer);
    }
}
