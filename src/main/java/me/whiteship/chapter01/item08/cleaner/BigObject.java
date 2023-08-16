package me.whiteship.chapter01.item08.cleaner;

import java.util.List;

public class BigObject {

    private List<Object> resource; // 객체가 없어질 때마다 없어져야 할 리소스

    public BigObject(List<Object> resource) {
        this.resource = resource;
    }

    /*
    finalize를 통해 해야 했던 작업을 별도의 Runnable 구현체로 만든다.

    유의 사항
    1. static으로 만들어야 하며,
    2. BigObject(정리하려는 오브젝트)에 대한 레퍼런스가 절대로 없어야 한다.
     - 정리하려는 작업은 오브젝트가 가비지 컬렉션될 떄 수행되는 오퍼레이션인데 참조하면 객체가 부활할 수 있기 때문.
       해서, 해당 메서드 안에서 오브젝트가 아닌 정리해야 할 리소스를 참조하도록 한 것.

    이러한 상황을 기피하기 위해 clean 작업을 하는 것을 별도의 클래스로 두는 것도 도움이 된다.
    물론 바깥에 둔다 하더라도, BigObject에 대한 레퍼런스를 가지면 안된다!
     */
    public static class ResourceCleaner implements Runnable {

        private List<Object> resourceToClean;

        public ResourceCleaner(List<Object> resourceToClean) {
            this.resourceToClean = resourceToClean;
        }

        @Override
        public void run() {
            resourceToClean = null;
            System.out.println("cleaned up.");
        }
    }
}
