import java.util.*;

class problem4 {

    static final long MOD = 1_000_000_007L;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        int left = 1;

        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];

            // maintain max deque (descending)
            while (!maxQ.isEmpty() && nums[maxQ.peekLast() - 1] <= val)
                maxQ.pollLast();
            maxQ.offerLast(i);

            // maintain min deque (ascending)
            while (!minQ.isEmpty() && nums[minQ.peekLast() - 1] >= val)
                minQ.pollLast();
            minQ.offerLast(i);

            // shrink window until max - min <= k
            while (nums[maxQ.peekFirst() - 1] - nums[minQ.peekFirst() - 1] > k) {
                if (maxQ.peekFirst() == left) maxQ.pollFirst();
                if (minQ.peekFirst() == left) minQ.pollFirst();
                left++;
            }

            // dp[i] = sum(dp[left-1] ... dp[i-1])
            long sum = pref[i - 1];
            if (left - 2 >= 0) sum = (sum - pref[left - 2] + MOD) % MOD;

            dp[i] = sum;
            pref[i] = (pref[i - 1] + dp[i]) % MOD;
        }

        return (int)(dp[n] % MOD);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        problem4 obj = new problem4();
        int ans = obj.countPartitions(nums, k);

        System.out.println("Output: " + ans);
    }
}
