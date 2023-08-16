package me.whiteship.chapter01.item07.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        WeakReference<Object> weak = new WeakReference<>(strong);
        strong = null;

        /*
        메모리 공간의 필요 여부에 상관 없이, GC가 일어날 때 무조건 없어진다.
         */

        System.gc();
        Thread.sleep(3000L);

        // TODO 거의 없어집니다.
        //  왜냐면 약하니까(?)...
        System.out.println(weak.get());
    }
}
