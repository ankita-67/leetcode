import java.util.*;

public class LFUCache {
    private class Node {
        int key;
        int frequency;
        int value;
        int time;

        public Node(int k, int v, int f) {
            key = k;
            frequency = f;
            value = v;
            time = ++timestamp;
        }

    }

    HashMap<Integer, Node> frequencyMap;
    PriorityQueue<Integer> frequencyMinHeap;
    int timestamp;
    private int capacity;

    public LFUCache(int capacity) {
        frequencyMap = new HashMap<>();
        frequencyMinHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer p1, Integer p2) {
                int diff = frequencyMap.get(p1).frequency - frequencyMap.get(p2).frequency;
                return diff == 0 ? frequencyMap.get(p1).time - frequencyMap.get(p2).time : diff;
            }
        });
        this.capacity = capacity;
        timestamp = 0;
    }

    public int get(int key) {
        if (frequencyMap.containsKey(key)) {
            Node p = frequencyMap.get(key);

            System.out.print(frequencyMinHeap);

            ++p.frequency;
            p.time = ++timestamp;
            // force heapify:
            frequencyMinHeap.offer(frequencyMinHeap.poll());

            System.out.println("------------endput--------------");
            return p.value;
        } else {
            System.out.println("------------endget --------------");
            return -1;
        }

    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (frequencyMap.containsKey(key)) {
            Node p = frequencyMap.get(key);
            p.value = value;
            p.time = ++timestamp;
            ++p.frequency;
            // force heapify:
            frequencyMinHeap.offer(frequencyMinHeap.poll()); // fr\
        } else {
            if (frequencyMinHeap.size() == capacity) {
                int k = frequencyMinHeap.poll();
                frequencyMap.remove(k);
            }
            Node p = new Node(key, value, 1);
            System.out.print("key: "+p.key +" value: "+p.value +" freq: "+p.frequency+" time: "+p.time);
            System.out.println();
            frequencyMap.put(key, p);
            frequencyMinHeap.offer(key);
            System.out.print("frequencyMinHeap: ");
            System.out.print(frequencyMinHeap);
            System.out.println();
        }
        System.out.println("endput");
    }

    public static void main(String[] args) {
        LFUCache lrucache = new LFUCache(2);
        lrucache.put(1,1);
        System.out.println("----------------after put 1--------------------");
        lrucache.put(2,2);
        System.out.println("-----------------after put 2-----------------------");
        lrucache.get(1);
        System.out.println("-------------------after get 1---------------------");
        lrucache.put(3,3);
        lrucache.get(2);
        lrucache.get(3);
        lrucache.put(4,4);
        lrucache.get(1);
        lrucache.get(3);
        lrucache.get(4);

    }
}
