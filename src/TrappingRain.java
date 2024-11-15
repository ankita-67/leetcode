
public class TrappingRain {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(maxWater(arr));
    }

    private static int maxWater(int[] arr) {
        int left = 1;
        int right = arr.length-2;
        int lmax = arr[left-1];
        int rmax = arr[right+1];
int res =0;
        while (left<=right)
        {
            if(lmax<=rmax)
            {

                res += Math.max(0,lmax -arr[left]);
                lmax = Math.max(lmax,arr[left]);
                left+=1;


            }
            else{

                res +=Math.max(0, rmax-arr[right]);
                rmax = Math.max(rmax, arr[right]);
                right-=1;
            }
        }
        return res;

    }
}
