import java.util.Locale;

public class validPalindrome {
    public static void main(String[] args) {
        String s = "Too hot to hoot.";

        System.out.println(sentencePalindrome(s)
                ? "True" : "False");
    }

    private static boolean sentencePalindrome(String s) {

        int last = s.length() -1;
        int start = 0;

        while(start<=last)
        {

            if(!Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if (!Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            } else if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(last))) {
                start++;
                last--;
                
            }
            else
                return false;

        }
        return true;
    }
}
