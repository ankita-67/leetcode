import java.util.*;

// Largest No from given array
class a {
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




