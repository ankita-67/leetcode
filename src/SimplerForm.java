public class SimplerForm {

    public static void main(String[] args) {
        int N = 3;
        int arr1[] = { 1, 2, 5 };
        int arr2[] = { 2, 1, 6 };
        addReduce(N, arr1, arr2);
    }

    private static void addReduce(int n, int[] num, int[] deno) {
        int fnum =0;
        int fdeno= findLCM(deno, n);
        for(int i=0;i<n;i++)
        {
            fnum =fnum+( fdeno *num[i]/deno[i]);
        }
        int gcd1 = gcd(fnum,fdeno);
        fnum/=gcd1;
        fdeno/=gcd1;

        System.out.println(fnum+"/"+fdeno);
    }

    private static int findLCM(int[] deno, int n) {
        int ans = deno[0];
        for(int i=1;i<n;i++)
            ans = (deno[i]*ans)/gcd(deno[i],ans);

        return ans;
    }

    private static int gcd(int a, int b) {
        if(b==0)
            return  a;
        return gcd(b, a%b);
    }
}
