import java.util.LinkedList;

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
    private static final int numBuckets = 1000;
    private LinkedList<Entry>[] buckets;

    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashmap() {
        buckets = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    public int get(int key) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % numBuckets;
        LinkedList<Entry> bucket = buckets[index];

        Entry toRemove = null;
        for (Entry entry : bucket) {
            if (entry.key == key) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }
}
