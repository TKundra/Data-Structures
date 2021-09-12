package Stack_Queue;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/*  We can use Java inbuilt Deque as a double
    ended queue to store the cache keys, with
    the descending time of reference from front
    to back and a set container to check presence
    of a key. But remove a key from the Deque using
    remove(), it takes O(N) time. This can be
    optimized by storing a reference (iterator) to
    each key in a hash map. */
public class LRUCache {
    /* stores keys of cache */
    private Deque<Integer> cache;
    /* store references of key in cache */
    private HashSet<Integer> hashSet;
    /* maximum capacity of cache */
    private final int CACHE_SIZE;

    LRUCache(int capacity) {
        cache = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    /* Refer the page within the LRU cache */
    public void refer(int page){
        // check is it already present in cache
        if (hashSet.contains(page)){
            // so remove it from cache so that it can be added at front of the cache
            cache.remove(page);
        }else {
            // not present in cache, adding it
            if (cache.size() == CACHE_SIZE){
                int last = cache.removeLast();
                hashSet.remove(last);
            }
        }
        // add to cache
        cache.push(page);
        hashSet.add(page);
    }

    /* display contents of cache */
    public void display() {
        for (Integer integer : cache) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(8);
        cache.refer(4);
        cache.refer(3);
        cache.refer(25);
        cache.refer(8);
        cache.refer(19);
        cache.refer(6);
        cache.refer(25);
        cache.refer(8);
        cache.refer(16);
        cache.refer(35);
        cache.refer(45);
        cache.refer(22);
        cache.refer(8);
        cache.refer(3);
        cache.refer(16);
        cache.refer(25);
        cache.refer(7);
        cache.display(); // 7 25 16 3 8 22 45 35
    }

}
