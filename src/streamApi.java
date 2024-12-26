import java.util.*;

public class streamApi {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        // add elements to the list
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

      OptionalDouble number =  list.stream().mapToInt(i->i).average();
      System.out.print(number);
    }

}
