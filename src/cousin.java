// A Dynamic Programming based solution
// for 0-1 Knapsack problem

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

class Knapsack {
    public static void main(String[] args) {

        Path filePath = Path.of("C:/Users/Ankita/Documents/a.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath.toUri()), StandardCharsets.UTF_8)) {

            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            //handle exception
        }

        String fileContent = contentBuilder.toString();
        getMostFrequentIp(fileContent);
    }

    public static void getMostFrequentIp(String filecontent){
        HashMap<String, Integer> map = new HashMap<>();
      String[] logs = filecontent.split(", ");
      //  System.out.println(Arrays.toString(logs)+" ");

        for(String log : logs){
            System.out.println(log);
            String[] arr = log.split(" ");
           // System.out.println(Arrays.toString(arr));
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
        }

        List<String> mostFrequent = new ArrayList<>();
        int freq = 0;

        for(String ip : map.keySet()){
            freq = Math.max(freq, map.get(ip));
        }

        for(String ip : map.keySet()){
            if(map.get(ip) == freq) mostFrequent.add(ip);
        }
        System.out.println();
        System.out.println(mostFrequent);
    }
}
