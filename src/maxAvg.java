import java.util.List;
import java.util.*;

public class maxAvg {
   

    public static void main(String[] args) {
        String input[][] = {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
        System.out.print(findMaxAverage(input));
    }

    private static int findMaxAverage(String[][] input) {
       HashMap<String, List<Integer>> hm = new HashMap<>();
       int highavg =0;

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
           int currentAvg = avg(entry.getValue());
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

        int avg1 = sum/(value.size());
        return avg1;

    }
}
