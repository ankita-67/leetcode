import java.util.List;
import java.util.*;

import static java.lang.Math.floor;

public class maxAvg {
   

    public static void main(String[] args) {
        String input[][] = {{"Bob","87"}, {"Mike", "86"},{"Bob", "52"}, {"Mike", "95"}, {"Mike", "79"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "-99"}};
        System.out.print(findMaxAverage(input));
    }

    private static float findMaxAverage(String[][] input) {
       HashMap<String, List<Integer>> hm = new HashMap<>();
       float highavg  = Integer.MIN_VALUE;

       for(int i=0;i<input.length;i++)
       {
            List<Integer> markList = hm.get(input[i][0]);
            if(markList == null)
            {
                List<Integer> currentMark = new ArrayList<>();
                currentMark.add(Integer.valueOf(input[i][1]));
                hm.put(input[i][0], currentMark);

            }
            else {
                markList.add(Integer.valueOf(input[i][1]));
                hm.put(input[i][0], markList);
            }

       }
       for(Map.Entry<String, List<Integer>> entry: hm.entrySet())
       {
          // System.out.pr
           // intln("key: "+entry.getKey()+" value: "+entry.getValue());
           float currentAvg = avg(entry.getValue());
           System.out.println("key: "+entry.getKey()+" value: "+entry.getValue()+ " currentavg: "+currentAvg);


           highavg = Math.max(currentAvg, highavg);
       }
       return highavg;
    }

    private static int avg(List<Integer> value) {
int sum =0;
        for(int ans :value)
        {
            sum+=ans;

        }
        System.out.println("sum: "+sum);
        int avg1 = (int) floor(sum/(value.size()));
        return avg1;

    }
}
