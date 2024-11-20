import java.util.HashMap;

public class romanToInteger {
    public static void main(String[] args)
    {
        String str = "MCMXCIV";
        System.out.println(romanToDecimal(str));
    }

    private static int romanToDecimal(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D', 500);
        mp.put('M',1000);
        int sum =0;
        for(int i=0; i<str.length();i++)
        {
            if(i+1< str.length() && mp.get(str.charAt(i))<mp.get(str.charAt(i+1)))
            {
                sum+= mp.get(str.charAt(i+1))- mp.get(str.charAt(i));
                i++;
            }
            else {
                sum+= mp.get(str.charAt(i));
            }
        }
        return sum;

    }

}
