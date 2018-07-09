package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by User2 on 20.09.2017.
 */
public class CachingProxyRetriever implements Retriever {
    OriginalRetriever originalRetriever;
    LRUCache cache = new LRUCache(16);

    public CachingProxyRetriever(Storage storage) {
        originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object obj = cache.find(id);
        if (obj == null) {
            obj = originalRetriever.retrieve(id);
            cache.set(id, obj);
        }
        return obj;
    }
}
