import java.util.*;

public class test2 {
    // Java Code to find all pairs using hashin

        // function to find all pairs
        static List<List<Integer>> findAllPairs(int[] arr, int target) {
            int n = arr.length;
            List<List<Integer>> res = new ArrayList<>();

            Map<Integer, List<Integer>> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {

                // Check if there exists an element that can pair with arr[i]
                if (mp.containsKey(target - arr[i])) {

                    // If such an element exists, iterate through its indices
                    for (int idx : mp.get(target - arr[i])) {
                        res.add(Arrays.asList(idx, i));
                    }
                }

                // Store the index of the current element in the map
                if (!mp.containsKey(arr[i])) {
                    mp.put(arr[i], new ArrayList<>());
                }
                mp.get(arr[i]).add(i);
            }
            return res;
        }

        public static void main(String[] args) {
            int[] arr = {10, 20, 30, 20, 10, 30};
            int target = 50;
System.out.print(Arrays.toString(arr));
            List<List<Integer>> res = findAllPairs(arr, target);
            for (List<Integer> pair : res) {
                System.out.println(pair.get(0) + " " + pair.get(1));
            }
        }
    }

