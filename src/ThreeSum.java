import java.util.Arrays;
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2 && nums[i]<=0;i++){
            if(i!=0 && nums[i]== nums[i-1])
                continue;
            twoSum(i+1, -nums[i],nums, res);
        }
        return res;
    }
    static void  twoSum(int start, int target, int[] arr,  List<List<Integer>> res)
    {
        int end = arr.length-1;
        while(start<end)
        {
            if(arr[start]+arr[end]<target){
                start++;
                continue;
            }
            if(arr[start]+arr[end]>target){
                end--;
                continue;
            }
            res.add(Arrays.asList(-target, arr[start], arr[end]));
            start++;
            end--;

            while(start<=end && arr[start] == arr[start-1])
                start++;

        }


    }

    public static void main(String[] args) {
        int []nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> p =  threeSum(nums);
        System.out.print(p);

    }
}


