import java.util.HashMap;

public class MinimumSlidingWindow  {

    public static String smallestWindow(String s, String t)
    {
        int len1 = s.length();
        int len2 = t.length();
        if(len2 > len1)
            return "-1";

        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmt = new HashMap<>();

        for(int i=0;i<len2;i++)
        {
            hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i),0)+1);

        }
        System.out.println("Mappings of HashMap hm1 are : "
                + hmt);
        int count =0, start=0, min_len = Integer.MAX_VALUE, start_idx =-1;
        for(int j=0;j<len1;j++)
        {
            char current = s.charAt(j);
            hms.put(current, hms.getOrDefault(current,0)+1);
            if(hmt.containsKey(current) && hms.get(current)<=hmt.get(current)){
                count++;
            }
            if(count == len2)
            {
                while ((!hmt.containsKey(s.charAt(start)))||
                        (hms.getOrDefault(s.charAt(start),0)>hmt.getOrDefault(s.charAt(start),0)))
                {
                    if(hms.get(s.charAt(start))>hmt.getOrDefault(s.charAt(start),0))
                    {
                        hms.put(s.charAt(start), hms.get(s.charAt(start))-1);
                    }
                    start++;
                }

                int len = j-start+1;
                if(min_len>len)
                {
                    System.out.println("min_len "+min_len);
                    min_len = len;
                    start_idx = start;
                }

            }
        }
        if(start_idx ==-1)
            return "-1";

        return s.substring(start_idx, start_idx+min_len);


    }
    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC";
        String p = "ABC";

        String result = smallestWindow(s, p);
        System.out.println(result);
    }
}