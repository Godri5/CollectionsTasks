package task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    LRUCache<Long, Object> cache = new LRUCache<>(10);
    OriginalRetriever retriever;

    public CachingProxyRetriever(Storage storage) {
        this.retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object result = cache.find(id);
        if (result == null) {
            Object o = retriever.retrieve(id);
            cache.set(id, o);
            return o;
        }
        System.out.println("Returning cached object!");
        return result;
    }
}
