import java.util.List;

//Count of subarrays with sum at least K
public class SumAtleastlessthank {
    public static void main (String[] args)
    {
        int a[] = {2,3,1,2,4,3}, k = 7;
        int n = a.length;

        System.out.println(k_sum(a, n, k));
    }

    private static int  k_sum(int[] a, int n, int k) {

        int r =0, sum =0, ans=0;
        for(int i=0;i<n;i++) {
            while (sum<k)
            {
                if(r == n)
                    break;
                else {
                    sum += a[r];
                    r++;

                }
            }
            if(sum<k)
               break;
            ans+=n-r+1;

            sum -=a[i];
        }
        return ans;
    }
}
