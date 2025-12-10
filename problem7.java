import java.util.*;
class problem7{
    static final long M = 1_000_000_007L;
    public int countPermutations(int[] complexity){
        int n = complexity.length;
        long result = 1;
        for(int i=1; i<n;i++){
            if(complexity[i]<=complexity[0]){
                return 0;
            }
            result = (result*i) % M;
        }
        return (int) result;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // simple input: size
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {      // read elements
            arr[i] = sc.nextInt();
        }
        problem7 obj = new problem7();
        System.out.println(obj.countPermutations(arr));  // print output
    }
}
