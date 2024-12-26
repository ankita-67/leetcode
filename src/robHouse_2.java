public class robHouse_2 {
    public static void main(String[] args) {
        int arr[] = {2, 3, 2};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        int n=nums.length;
        if(n == 1)
            return nums[0];

        return Math.max(robHouse(nums, 0,n-2),robHouse(nums, 1,n-1));
    }

    public static int robHouse(int[] num, int left, int right)
    {
        int prevNoRob = 0;
        int prevRob =0;

        for(int i=left; i<right;i++)
        {
            int tempprevnoRob = Math.max(prevNoRob, prevRob);
            prevRob = prevNoRob +num[i];
            prevNoRob = tempprevnoRob;


        }
        return Math.max(prevRob, prevNoRob);
    }
    }

