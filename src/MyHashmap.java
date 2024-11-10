import java.util.LinkedList;
import java.util.Map;

public class MyHashmap {

    public static void main(String[] args) {
        MyHashmap hashMap = new MyHashmap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
       System.out.println(hashMap.get(1));
       System.out.println(hashMap.get(3));
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2));
       hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }




    private static int numBucket =1000;
    private LinkedList<Pair>[] buckets;

    static class Pair
    {
        int key;
        int value;
        Pair next;

        Pair(int key, int value)
        {
            this.key =key;
            this.value= value;
        }
    }
    MyHashmap(){
        buckets = new LinkedList[numBucket];
        for(int i=0;i<numBucket;i++)
            buckets[i]=new LinkedList<>();
    }
    private void put(int key, int value) {
      int index = key % numBucket;
      LinkedList<Pair> bucket = buckets[index];
   for( Pair entry :bucket)
      {
          if(entry.key == key)
          {
              entry.value =value;
              return;
          }
      }


      bucket.add(new Pair(key,value));
    }
    private int get(int key) {
        int index = key%numBucket;
        LinkedList<Pair> bucket = buckets[index];
        for (Pair entry : bucket)
        {
            if(entry.key == key )
                return entry.value;
        }
        return -1;

    }
    private void remove(int i) {

        int index = i%numBucket;
        LinkedList<Pair> bucket = buckets[index];
        Pair p = null;
        for(Pair entry : bucket)
        {
            if (entry.key == i)
            {
                p = entry;
            }
        }
        if(p!=null)
            bucket.remove(p);
    }
}
