import java.util.*;
public class problem44 {
    public static int minimumCost(int[] nums){
        int n = nums.length;
        int score = nums[0];
        int firstmin = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        for(int i = 1; i <n ; i++){
            if(nums[i] < firstmin){
                secondmin = firstmin;
                firstmin = nums[i];
            }else if(nums[i] < secondmin){
                secondmin = nums[i];
            }
        }
        return  score +firstmin+secondmin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = minimumCost(nums);
        System.out.println(result);
        sc.close();
    }
}
