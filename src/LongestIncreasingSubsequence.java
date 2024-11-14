public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println(lis(arr, n));
    }

    private static int lis(int[] arr, int n) {

        int lislength =0;
        int dp[] = new int[n];
        for(Integer current : arr)
        {
            int i=0,j=lislength;
            System.out.println("lislength :"+lislength);
            System.out.println("current :"+current);
            System.out.println("i :"+i);
            while(i!=j)
            {

                int mid = (i+j)/2;
                System.out.println("mid :"+mid);
                if(dp[mid]<current)
                    i =mid+1;
                else
                    j=mid;

            }
            dp[i] =current;
            if(i==lislength) {
                lislength++;
                System.out.println("after While lislength "+lislength);
            }
        }
return lislength;
    }
}
