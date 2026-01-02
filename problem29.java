import java.util.*;
public class problem29 {
    public static int repeatedNTimes(int[] nums){
        for(int i =2; i<nums.length; i++){
            if(nums[i]==nums[i-1] || nums[i]==nums[i-2]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
   }

    static void main(String[] args) {
        int[] nums = {5,1,5,2,5,3,5,4};
        int result = repeatedNTimes(nums);
        System.out.println("Repeated element: " +result);
    }
}