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
        int inclPrev = 0;
        int excludePrev =0;
        for (int i=left; i<=right;i++)
        {
            int incurr = num[i]+excludePrev;
            excludePrev = Math.max(excludePrev, inclPrev);
            inclPrev = incurr;
        }
        return Math.max(excludePrev,inclPrev);
    }
}
