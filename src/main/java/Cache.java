import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by qale0001 on 27/01/2017.
 */
public class Cache {
    int capacity;
    Queue<Integer> queue;
    Map<Integer, Integer> cacheMap;

    public Cache(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
        cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (cacheMap.containsKey(key))
            return cacheMap.get(key);
        else
            return -1;
    }

    public void set(int key, int value) {
        while (queue.size() >= capacity) {
            int removedKey = queue.poll();
            cacheMap.remove(removedKey);
        }
        queue.add(key);
        cacheMap.put(key, value);
    }

    static public void main(String[] args) {
        Cache cache = new Cache(2);
        cache.set(1, 10);
        cache.set(5, 12);
        System.out.println(cache.get(5));
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.set(6, 14);
        System.out.println(cache.get(1));
    }
}

