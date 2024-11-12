import java.util.Arrays;

public class productWithoutself {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] res = productExceptSelf(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    private static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Arrays.fill(ans,1);
        int curr =1;
        for(int i=0;i<n;i++)
        {
            ans[i]*=curr;
            curr*=arr[i];
        }
        curr =1;
        for(int i=n-1;i>=0;i--)
        {
            ans[i]*=curr;
            curr*=arr[i];
        }
return ans;
    }
}

//    private static int[] productExceptSelf(int[] arr) {
//        int n= arr.length;
//        int pre[] = new int[n];
//        int suff[] =new int[n];
//        pre[0]=1;
//        suff[n-1]=1;
//        for(int i=1;i<n;i++)
//            pre[i] =pre[i-1]*arr[i-1];
//
//        for(int j=n-2; j>=0;j--)
//            suff[j] = suff[j+1] * arr[j+1];
//
//        int ans[] = new int[n];
//
//        for(int i=0;i<n;i++)
//             ans[i] = pre[i]* suff[i];
//
//        return ans;
//    }
//}
