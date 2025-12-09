
import java.util.*;

public class problem6 {

    static final long M = 1_000_000_007L;

    public int specialTriplets(int[] nums) {

        HashMap<Integer, Integer> mp_left  = new HashMap<>();
        HashMap<Integer, Integer> mp_right = new HashMap<>();

        // preload right map with counts of all numbers
        for (int num : nums) {
            mp_right.put(num, mp_right.getOrDefault(num, 0) + 1);
        }

        long result = 0;

        // one pass
        for (int num : nums) {

            // remove from right (this number becomes the middle point)
            mp_right.put(num, mp_right.get(num) - 1);
            if (mp_right.get(num) == 0) mp_right.remove(num);

            // compute left and right count of value = num * 2
            int left  = mp_left.getOrDefault(num * 2, 0);
            int right = mp_right.getOrDefault(num * 2, 0);

            result = (result + (1L * left * right) % M) % M;

            // add current number to left
            mp_left.put(num, mp_left.getOrDefault(num, 0) + 1);
        }

        return (int) result;
    }
    public static void main(String[] args) {

        // 🔥 INPUT HERE
        int[] nums = {1, 2, 4, 2, 4, 8};
        problem6 obj = new problem6();
        long ans = obj.specialTriplets(nums);

        System.out.println("Result = " + ans);
    }
}
