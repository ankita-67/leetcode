import java.util.HashMap;

// leetcode 166. Fraction to Recurring Decimal
public class recurringDecimal {
    public static void main(String[] args) {

        int numr = 50, denr = 22;
        String res = fractionToDecimal(numr, denr);
        if (res == "")
            System.out.print("No recurring sequence");
        else
            System.out.print("Recurring sequence is "
                    + res);
    }

    private static String fractionToDecimal(int numr, int denr) {

        if(numr == 0)
            return "0";
        StringBuilder res= new StringBuilder();
   boolean isNegative = (numr>0)  ^ (denr>0);
   res.append(isNegative?"-":"");

   long num = Math.abs(numr);
   long deno = Math.abs(denr);

   res.append(num/deno);
   num%=deno;

   if(num==0)
       return res.toString();

   res.append('.');
        HashMap<Long,Integer> hm = new HashMap<>();
   while(num!=0)
   {
       hm.put(num, res.length());
       num*=10;
       res.append(num/deno);
       num%=deno;

       if(hm.containsKey(num))
       {
           int index = hm.get(num);
           res.insert(index,'(');
           res.append(')');
           break;

       }

   }

        return res.toString();


    }
}
