import java.util.List;
import java.util.*;

public class maxAvg {
   

    public static void main(String[] args) {
        String input[][] = {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
        System.out.print(findMaxAverage(input));
    }

    private static int findMaxAverage(String[][] input) {
        if(input == null || input.length == 0) {
            return -1;
        }
        int highestAve = 0;
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0;i<input.length;i++)
        {
            List<Integer> scoreList = map.get(input[i][0]);
            System.out.println("scoreList "+scoreList);
            if(scoreList == null) {
                List<Integer> currentList = new ArrayList<>();
                currentList.add(Integer.valueOf(input[i][1]));
                map.put(input[i][0], currentList);

            }
            else {
                scoreList.add(Integer.valueOf(input[i][1]));
                map.put(input[i][0], scoreList);
            }
        }
        System.out.print(map);
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            int currentAveScore = aveCalculate(entry.getValue());

            highestAve = Math.max(highestAve, currentAveScore);
        }

        return highestAve;
    }

    private static int aveCalculate(List<Integer> scores) {
        int len = scores.size();
        int sum = 0;
        for(int score : scores) {
            sum += score;
        }

        float ave = sum / len;
        return (int) ave;
    }
}
