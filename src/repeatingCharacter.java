//Repeated Character Whose First Appearance is Leftmost
public class repeatingCharacter {
static int NO_OF_CHARS =256;
    public static void main(String[] args) {
        char[] str = "geeksforgeeks".toCharArray();
        int index = firstRepeating(str);
        if (index == -1)
        {
            System.out.printf("Either all characters are "
                    + "distinct or string is empty");
        }
        else
        {
            System.out.printf("First Repeating character"
                    + " is %c", str[index]);
        }
    }

    private static int firstRepeating(char[] str) {
        int res = Integer.MAX_VALUE;

        int[] firstIndex = new int[NO_OF_CHARS];
        for(int i=0;i<firstIndex.length; i++)
        {
            firstIndex[i] =-1;
        }

        for(int i=0;i<str.length;i++)
        {
            if(firstIndex[str[i]] == -1)
                firstIndex[str[i]] = i;
            else
                res = Math.min(res,firstIndex[str[i]]);

        }



        return res == Integer.MAX_VALUE ?-1:res;
    }
}
