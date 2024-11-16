import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// Largest No from given array
class A {
    public static void main(String[] args) {
        String[] arr1 = {"3", "30", "34", "5", "9"};
        System.out.println(
                largestNumber(arr1));
    }

    private static String largestNumber(String[] arr1) {
        Comparator<String> myCompare = (X,Y)->(X+Y).compareTo(Y+X);

        Arrays.sort(arr1,myCompare.reversed());

        for (int i=0;i<arr1.length;i++) {
            System.out.print(arr1[i]+" ");
        }
        if(arr1[0].equals("0"))
            return "0";

        StringBuilder res = new StringBuilder();
        for(String num :arr1)
            res.append(num);
        System.out.println();
        return res.toString();
    }

}




