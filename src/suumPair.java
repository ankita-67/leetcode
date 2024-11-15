import java.util.Arrays;
import java.util.HashMap;

public class suumPair {
    public static void main(String[] args){

        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

       int[] answer = twoSum(arr, target);
       System.out.print(Arrays.toString(answer));

    }

    private static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            int requiredSum = target - arr[i];
           if( hm.containsKey(requiredSum))
            {
                return new int[]{hm.get(requiredSum),i};
            }
           hm.put(arr[i],i);
        }
        return null;
    }
}
