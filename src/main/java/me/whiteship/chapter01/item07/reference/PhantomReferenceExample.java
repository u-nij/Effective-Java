package me.whiteship.chapter01.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        BigObject strong = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

        /*
        ReferenceQueue를 사용.
        PhantomReference가 strong 인스턴스 대신 남아있다.

        PhantomReference는 strongReference와 ReferenceQueue를 함께 넘겨줘야 한다.
        PhantomReference만 남은 경우, GC가 일어나면 본래 가지고 있던 오브젝트를 정리하고(null이므로) ReferenceQueue에 들어간다.
        바로 없어지는 것이 아니며, PhantomReference 오브젝트를 나중에 큐에서 꺼내 정리할 수 있다.

        용도
        1) 자원 반납할 때.
        finalize 메서드(권장x)보다 나은 자원 정리 방법.(더 나은 방법이 있다.)
        자원을 반납하는 용도로 쓰려면, 커스텀한 PhantomReference를 만들어야 한다.
        2) 무거운 객체의 메모리 해제 시점 알 수 있다.
        PhantomReference 오브젝트가 사라짐과 동시에 ReferenceQueue에 들어가기 때문에,
        queue를 확인하면 메모리 공간이 비어짐을 알 수 있다.
         */
        
        // 2) 자원 반남 시점 예제(BigObjectReference 관련 코드 주석 처리할 것)
//        PhantomReference<BigObject> phantom = new PhantomReference<>(strong, rq);
        // 1) 자원 반납 예제. 커스텀한 메서드를 사용하기 위해 커스텀한 레퍼런스를 사용해야 한다.
        BigObjectReference<BigObject> phantom = new BigObjectReference<>(strong, rq);
        strong = null;

        System.gc(); // PhantomReference가 ReferenceQueue에 들어간다.
        Thread.sleep(3000L);

        // TODO 팬텀은 유령이니까..
        //  죽었지만.. 사라지진 않고 큐에 들어갑니다.
        System.out.println(phantom.isEnqueued()); // rq에 있으면, 큰 리소스가 반납된 것.

        Reference<? extends BigObject> reference = rq.poll();
        BigObjectReference bigObjectCleaner = (BigObjectReference) reference; // 예제2 때 주석처리
        bigObjectCleaner.cleanUp(); // 예제2 때 주석처리
        reference.clear(); // 최종적으로 PhantomReference가 사라진다.
    }
}
