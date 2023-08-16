package me.whiteship.chapter01.item08.cleaner;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class CleanerIsNotGood {

    public static void main(String[] args) throws InterruptedException {
        // Cleaner 구현 자체가 PhantomReference를 사용해 만든 것이기 때문에, 사용 또한 PhantomReference를 사용하는 것과 비슷.
        Cleaner cleaner = Cleaner.create();

        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp); // 사용하고자 하는 객체

        // cleaner 등록. 정리하려는 오브젝트가 GC될 때 이 Runnable을 사용해 정리 작업을 해라.
        cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

        bigObject = null; // null -> 사용이 필요해지지 않음.
        System.gc(); // GC
        Thread.sleep(3000L);
    }

}
