package me.whiteship.chapter01.item07.cache;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PostRepositoryTest {

    // 일반적인 HashMap
//    @Test
//    void cache() throws InterruptedException {
//        PostRepository postRepository = new PostRepository();
//        Integer p1 = 1;
//        Post postById = postRepository.getPostById(p1); // 가져온 데이터가 cache에 저장됨.
//
//        assertFalse(postRepository.getCache().isEmpty());
//
//        p1 = null; // 해당 코드를 통해, null로 설정해도 AssertionFailedError 발생.
//        // TODO run gc
//        System.out.println("run gc");
//        System.gc(); // 바로 gc가 실행된다는 보장되지는 않지만, 실행되긴 한다.
//        System.out.println("wait");
//        Thread.sleep(3000L);
//
//        assertTrue(postRepository.getCache().isEmpty());
//

    // WeakHashMap
    @Test
    void cache() throws InterruptedException {
        PostRepository postRepository = new PostRepository();
        // WeakHashMap으로 참조하고 있던 p1이 없어진다.
        // 더이상 CacheKey를 참조하는 곳이 없음.
        CacheKey key1 = new CacheKey(1); // 메서드가 끝날때까지 유효.
        /*
        커스텀한 Ref 타입을 가지고 있는 경우 WeakHashMap을 사용해도 괜찮지만
        wrapper 타입의 경우 주의해 사용해야 한다. 레퍼런스를 만들어 사용해야 한다.
        (primitive 타입의 경우, 맵의 키 값은 wrapper 타입을 써야 하기 때문에 key로 못 쓴다.)

        아무리 null로 만들어도, 캐시가 삭제되지 않는다.
        자주 사용하는 wrapper 타입과 같은 값들은 JVM 내부 어딘가에 상수 pool같은 걸로 이미 캐시되어 있기 때문.
         */
        // Integer key1 = 1;

        postRepository.getPostById(key1);

        assertFalse(postRepository.getCache().isEmpty());

        key1 = null;
        /*
        40~45 라인의 코드가 별도의 메서드일 때, 메서드가 끝나면 key1이 유효하지 않게 된다.
        => `key1 = null;` 코드와 동일.
        => 임의로 `key1 = null;` 하지 않아도, GC를 하는 순간 Weak 레퍼런스에서 정리된 것.
        */

        // TODO run gc
        System.out.println("run gc");
        System.gc();
        System.out.println("wait");
        Thread.sleep(3000L);

        assertTrue(postRepository.getCache().isEmpty());
        /*
         AssertionFailedError 발생. => cache가 비어 있지 않다는 의미.
         key1은 이 메서드가 끝날 때까지 new CacheKey(1) 참조하고 있기 때문에.
         */
    }

    // ScheduledExecutorService 활용
    // HashMap 사용.
//    @Test
//    void backgroundThread() throws InterruptedException {
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//        PostRepository postRepository = new PostRepository();
//        CacheKey key1 = new CacheKey(1);
//        postRepository.getPostById(key1);
//
//        // 명령어를 실행할 때 하는게 아닌, 백그라운드에서 스레드를 이용해 주기적으로 정리하는 작업
//        Runnable removeOldCache = () -> {
//            System.out.println("running removeOldCache task");
//            Map<CacheKey, Post> cache = postRepository.getCache();
//            Set<CacheKey> cacheKeys = cache.keySet();
//            // 가장 오래된 것을 찾아 삭제.
//            Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
//            key.ifPresent((k) -> {
//                System.out.println("removing " + k);
//                cache.remove(k);
//            });
//        };
//
//        System.out.println("The time is : " + new Date());
//
//        executor.scheduleAtFixedRate(removeOldCache,
//                1, 3, TimeUnit.SECONDS); // 최초 1초 후, 매 3초마다 실행
//
//        Thread.sleep(20000L);
//
//        executor.shutdown();
//    }

}