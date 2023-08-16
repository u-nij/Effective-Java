package me.whiteship.chapter01.item08.finalizer;

public class FinalizerIsBad {

    /*
    Finalizer는 우리가 만드는 클래스에 finalize 메서드를 오바리이딩해 사용하면 된다.

    자바9부터 사용 자제를 권고.
    WeakReference 또는 PhantomReference 또는 Cleaner를 사용하는 것을 권장.
    하지만, 이보다 AutoCloseable이 가장 적절한 해결책.

    Finalizer 내부에서 다른 오브젝트를 참조하거나 본인을 객체로 만들어 사용하게 되면 finalize할 객체가 늘어나기 때문에 조심해야 한다.
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.print("");
    }
}
