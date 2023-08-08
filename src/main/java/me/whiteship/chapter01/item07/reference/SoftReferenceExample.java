package me.whiteship.chapter01.item07.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object(); // Object를 StrongReference
        // new SoftReference 생성자 매개변수에 SoftReference로 가리킬 StrongReference를 넣어주면 된다.
        SoftReference<Object> soft = new SoftReference<>(strong); // strong을 SoftReference
        strong = null;

        /*
        더이상 StrongReference하는 객체가 없고, SoftReference 레벨로만 참조하고 있으면
        "메모리가 필요한 상황"에 해당 오브젝트는 gc의 대상이 된다.
         */

        System.gc();
        Thread.sleep(3000L);

        // TODO 거의 안 없어집니다.
        //  왜냐면 메모리가 충분해서.. 굳이 제거할 필요가 없으니까요.
        System.out.println(soft.get());
    }
}
