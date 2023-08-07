package me.whiteship.chapter01.item07.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

// 일반적인 HashMap
//public class PostRepository {
//
//    private Map<CacheKey, Post> cache;
//
//    public PostRepository() {
//        this.cache = new HashMap<>();
//    }
//
//    // CacheKey에 해당하는 Post를 리턴.
//    public Post getPostById(Integer id) {
//        CacheKey key = new CacheKey(id); // CacheKey가 메서드 안에서만 존재.
//        if (cache.containsKey(key)) {
//            return cache.get(key);
//        } else {
//            // TODO DB에서 읽어오거나 REST API를 통해 읽어올 수 있습니다.
//            Post post = new Post();
//            cache.put(key, post);
//            return post;
//        }
//    }
//
//    public Map<CacheKey, Post> getCache() {
//        return cache;
//    }
//}

// WeakHashMap으로 변경.
public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
        this.cache = new HashMap<>();
    }

    public Post getPostById(CacheKey key) {
//        CacheKey key = new CacheKey(id); // CacheKey가 더이상 참조되지X. 메서드 안에ㅓㅅ만 졵내하기 때문에 바로 사라짐./
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            // TODO DB에서 읽어오거나 REST API를 통해 읽어올 수 있습니다.
            Post post = new Post();
            cache.put(key, post);
            return post;
        }
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}