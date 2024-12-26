import java.util.HashMap;
import java.util.Map;

public class validAnagram {
    // Java Code to check if two Strings are anagram of
// each other using Hash map





        static boolean areAnagrams(String s1, String s2) {

            // Create a hashmap to store character frequencies
            HashMap<Character, Integer> charCount = new HashMap<>();

            // Count frequency of each character in string s1
            for (char ch : s1.toCharArray())
                charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            // Count frequency of each character in string s2
            for (char ch : s2.toCharArray())
                charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            // Check if all frequencies are zero
            for (Map.Entry<Character,Integer> ans: charCount.entrySet()) {
                if (ans.getValue() != 0) {
                    return false;
                }
            }

            // If all conditions satisfied, they are anagrams
            return true;
        }

        public static void main(String[] args) {
            String s1 = "geeks";
            String s2 = "kseeg";
            System.out.println(areAnagrams(s1, s2) ? "true" : "false");
        }
    }
