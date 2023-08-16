package me.whiteship.chapter01.item07.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/*
자원 반납 예제를 위한 레퍼런스.
커스텀하게 PhantomReference를 상속받아야 한다.
 */
public class BigObjectReference<BigObject> extends PhantomReference<BigObject> {

    // 부모의 생성자를 넘겨주기 위해 이 생성자를 만들어야 한다.
    public BigObjectReference(BigObject referent, ReferenceQueue<? super BigObject> q) {
        super(referent, q);
    }

    // 자원 반납
    public void cleanUp() {
        System.out.println("clean up");
    }
}
