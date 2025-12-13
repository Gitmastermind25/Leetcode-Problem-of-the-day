import java.util.*;

public class problem9 {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> validIndices = new ArrayList<>();

        Set<String> allowedBusinessLines = new HashSet<>(
                Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
        );

        for (int i = 0; i < code.length; i++) {
            if (isActive[i]
                    && allowedBusinessLines.contains(businessLine[i])
                    && isValidCouponCode(code[i])) {
                validIndices.add(i);
            }
        }

        validIndices.sort((i1, i2) -> {
            int cmp = businessLine[i1].compareTo(businessLine[i2]);
            if (cmp != 0) return cmp;
            return code[i1].compareTo(code[i2]);
        });

        List<String> result = new ArrayList<>();
        for (int idx : validIndices) {
            result.add(code[idx]);
        }
        return result;
    }

    private boolean isValidCouponCode(String couponCode) {
        if (couponCode.isEmpty()) return false;

        for (char c : couponCode.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    // -------- MAIN METHOD (NO HARDCODE) --------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        problem9 obj = new problem9();

        int n = sc.nextInt();   // number of coupons
        sc.nextLine();

        String[] code = new String[n];
        String[] businessLine = new String[n];
        boolean[] isActive = new boolean[n];

        for (int i = 0; i < n; i++) {
            code[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            businessLine[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            isActive[i] = sc.nextBoolean();
        }

        List<String> ans = obj.validateCoupons(code, businessLine, isActive);
        System.out.println(ans);
    }
}
