import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LRUcache {
    int capacity;
    LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
    
    public LRUcache(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUcache lRUCache = new LRUcache(2);
        lRUCache.put(1, 1); //
        lRUCache.put(2, 2);
        System.out.println(  lRUCache.get(1));
        lRUCache.put(3, 3);
        lRUCache.displayMap();
        System.out.println( lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println( lRUCache.get(1));
        System.out.println( lRUCache.get(3));
        lRUCache.get(4);
        lRUCache.displayMap();
    }

    private int get(int i) {
        if(hm.containsKey(i))
        {
            int value= hm.get(i);
            hm.remove(i);
            hm.put(i, value);
            return value;

        }
        return -1;
    }

    private void displayMap() {
        Set entrySet = hm.entrySet();

        // Obtain an Iterator for the entries Set
        Iterator it = entrySet.iterator();

        // Iterate through LinkedHashMap entries
        System.out.println("LinkedHashMap entries : ");

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }



    private void put(int key, int value) {
        if(hm.containsKey(key)) {
            hm.remove(key);
            hm.put(key, value);

        }
        else {
            hm.put(key,value);
            if(hm.size()>capacity)
            {
                int oldestIndex = hm.keySet().iterator().next();
                hm.remove(oldestIndex);
            }
        }

    }

}
