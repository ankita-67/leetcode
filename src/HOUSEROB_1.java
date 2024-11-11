public class HOUSEROB_1 {

    public static void main(String[] args) {
        int[] hval = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(rob(hval));
    }
    public static int rob(int[] nums) {
        int prevNoRob = 0;
        int prevRob =0;

        for(int current: nums)
        {
            int tempprevnoRob = Math.max(prevNoRob, prevRob);
            prevRob = prevNoRob +current;
            prevNoRob = tempprevnoRob;


        }
        return Math.max(prevRob, prevNoRob);
    }
}
