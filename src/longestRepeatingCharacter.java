public class longestRepeatingCharacter {
    public static void main(String[] args) {
        String str = "ABAB";
               int k=4;
      System.out.print(characterReplacement(str,k));
    }

    public static int characterReplacement(String s, int k) {
        int[] letterCount = new int[26]; // Array to store the frequency count of each letter
        int windowStart = 0; // Start index of the sliding window
        int windowEnd = 0; // End index of the sliding window
        int maxCountInWindow = 0; // Variable to store the maximum count of a single character in the current window

        // Iterate over the string with windowEnd serving as the end pointer of the sliding window
        for (; windowEnd < s.length(); ++windowEnd) {
            char currentChar = s.charAt(windowEnd); // Current character in iteration
            letterCount[currentChar - 'A']++; // Increment the count for this character in the frequency array

            System.out.print( letterCount[currentChar - 'A']);
            // Update the maxCountInWindow to be the max between itself and the count of the current character
            maxCountInWindow = Math.max(maxCountInWindow, letterCount[currentChar - 'A']);

            // Check if current window size minus max frequency count is greater than k
            // If it is, we need to slide the window ahead while decrementing the count of the char at windowStart
            if (windowEnd - windowStart + 1 - maxCountInWindow > k) {
                letterCount[s.charAt(windowStart) - 'A']--; // Decrement count of the start character of the window
                windowStart++; // Move the window's start index forward
            }
        }
        // The maximum length substring is the size of the window on loop exit
        return windowEnd - windowStart;
    }
}
