import java.util.*;

public class Solution {
    public static List<int[]> createSkyline(int[][] buildings) {
    Set<Integer> positions = new TreeSet<>(); // TreeSet to hold unique, sorted positions (edges of buildings)
    Map<Integer, Integer> positionIndexMap = new HashMap<>(); // Maps original positions to their index after compression

    // Collect all potential start and end points from the buildings
    for (int[] building : buildings) {
        positions.add(building[0]);
        positions.add(building[1]);
    }
        System.out.print(positions);
    System.out.println();

    // Create a map from position to index (for easier access, reduction of positions)
    int index = 0;
    for (int pos : positions) {
        positionIndexMap.put(pos, index++);
    }
System.out.print(positionIndexMap);
    // Create an array to store the maximum height at each position
    int[] heights = new int[positionIndexMap.size()];
        System.out.println();
    // Determine the maximum height for each compressed position
    for (int[] building : buildings) {
        int beginIndex = positionIndexMap.get(building[0]); // Compressed start index
        int endIndex = positionIndexMap.get(building[1]); // Compressed end index

        for (int i = beginIndex; i < endIndex; ++i) {
           heights[i] = Math.max(heights[i], building[2]);

        }

    }
    for(int i =0;i<heights.length;i++)
        System.out.println("height["+i+"] "+heights[i]);


    List<int[]> result = new ArrayList<>(); // List to hold the skyline points

    // Iterator to track positions
    Integer previousPosition = null;

    // Construct the result list with actual positions and the corresponding heights
    for (int pos : positions) {
        int mappedIndex = positionIndexMap.get(pos);
        System.out.println("mappedIndex: "+mappedIndex);
        int currentHeight = heights[mappedIndex];

        // Add point to skyline if it is the start or height changes
        if (previousPosition == null || currentHeight != heights[positionIndexMap.get(previousPosition)]) {
            result.add(new int[]{pos, currentHeight});
            previousPosition = pos; // Update the previousPosition after adding to result
        }
    }

    return result; // Return the result skyline
}

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10},{3, 7, 15},{5, 12, 12},{15, 20, 10},{19, 24, 8}};
        printSkyline(buildings);
    }
        public static void printSkyline ( int[][] buildings){
            List<int[]> skyline = createSkyline(buildings);
            System.out.println("Sky}line for given buildings:");
        System.out.print("{");
        for (int[] it : skyline) {
            System.out.print("{" + it[0] + ", " + it[1] + "} ");
        }
        System.out.println("}");
    }

}

