//45. Jump Game II
public class jump2 {
    public static void main(String[] args) {
        int arr[] = new int[] {1,3,6,1,0,9  };

        // calling minJumps method
        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {

        if(arr.length<=1)
            return 0;
        if(arr[0] >= arr.length-1)
            return 1;
        if (arr[0] == 0)
            return -1;
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
    for(int i=1;i<=arr.length-1;i++)
    {
        if(i == arr.length-1)
            return jump;

        if(arr[i]>=(arr.length -1) -i)
            return jump +1;

        maxReach = Math.max(maxReach, arr[i]+i);


        step--;
        if (step == 0) {
            jump++;
            if(i>=maxReach)
                return -1;

            step = maxReach -i;
        }


    }
        return -1;
    }
}

