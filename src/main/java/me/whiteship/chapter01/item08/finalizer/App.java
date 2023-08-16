package me.whiteship.chapter01.item08.finalizer;

import com.sun.management.UnixOperatingSystemMXBean;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class App {

    /**
     * 코드 참고 https://www.baeldung.com/java-finalize
     */
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        int i = 0;
        while(true) {
            i++;
            new FinalizerIsBad();
            /*
            여기까지 코드가 유효하다고 했을 떄,

            무한정 FinalizerIsBad 객체를 만들게 되며 참조하는 곳이 없기 떄문에 GC의 대상이 된다.
            객체가 백만 개가 만들어질 때쯤 한 번씩 Finalizer를 참조해, finalize 메소드를 실행한다.
            finalize 메서드 실행 자체로 Finalizer 클래스는 큐(ReferenceQueue) 안에 들어가게 된다.
             */

            // Finalizer의 큐에 얼마나 오브젝트가 쌓여 있는지 출력하는 코드
            // final로 접근이 제한되어 있기 때문에 리플렉션을 통해 접근한다.
            if ((i % 1_000_000) == 0) {
                // 리플렉션
                Class<?> finalizerClass = Class.forName("java.lang.ref.Finalizer");
                Field queueStaticField = finalizerClass.getDeclaredField("queue");
                queueStaticField.setAccessible(true);
                ReferenceQueue<Object> referenceQueue = (ReferenceQueue) queueStaticField.get(null);

                Field queueLengthField = ReferenceQueue.class.getDeclaredField("queueLength");
                queueLengthField.setAccessible(true);
                long queueLength = (long) queueLengthField.get(referenceQueue);
                System.out.format("There are %d references in the queue%n", queueLength);
            }
        }
    }
}
