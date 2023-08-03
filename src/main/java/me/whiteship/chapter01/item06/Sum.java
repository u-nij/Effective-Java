package me.whiteship.chapter01.item06;

public class Sum {
    private static long sum() {
        // TODO Long을 long으로 변경하여 실행해 보세요.
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i; // Long + long 이기 때문에, 객체 i의 타입이 Integer.MAX_VALUE 개수만큼 Long으로 바뀜.
        return sum;
    }



    /*
    primitive 타입을 wrapper 타입으로 변형하는 과정을 AutoBoxing.
    wrapper 타입을 primitive 타입으로 변형하는 과정을 UnBoxing이라고 한다.
    해당 과정을 JVM의 자바 컴파일러가 런타임에 자동으로 처리해준다.

    불필요한 AutoBoxing으로 불필요하게 많은 객체를 만들게 되는 것을 조심해야 한다.
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        long x = sum();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000. + " ms.");
        System.out.println(x);
    }
}
