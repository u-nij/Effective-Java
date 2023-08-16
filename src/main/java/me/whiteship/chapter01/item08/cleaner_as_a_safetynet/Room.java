package me.whiteship.chapter01.item08.cleaner_as_a_safetynet;

import java.lang.ref.Cleaner;

// 코드 8-1 cleaner를 안전망으로 활용하는 AutoCloseable 클래스 (44쪽)
public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    // Room 객체가 GC될 때 자원을 반납하는 작업.
    // 청소가 필요한 자원. 절대 Room을 참조해서는 안 된다!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // close 메서드나 cleaner가 호출한다.
        @Override public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0; // 삭제하고자 하는 리소스
        }
    }

    // 방의 상태. cleanable과 공유한다.
    private final State state;

    // cleanable 객체. 수거 대상이 되면 방을 청소한다.
    private final Cleaner.Cleanable cleanable;

    // Room을 만들 때 cleaner를 등록한다. Cleaner는 이미 필드에 있는 상태
    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state); // state 작업 등록
    }

    /*
    Adult;
    AutoCloseable을 구현하기 떄문에 try-with-resource에 사용하면 실행이 된다.
    => Room이 구현한 AutoClosable의 close 메서드를 이용해 자원 반납.

    Teenager; try-with-resource를 사용하지 않았을 경우.
    GC될 때 cleaner의 큐에 들어가게 된다.
    cleaner에 등록해놓은 작업인 state, 즉 Runnable이 실행되게 된다.(11~23l 실행)
    해서, Cleaing Room이 호출된다.
    => cleaner 안전망을 사용해 자원 반납.
     */
    @Override public void close() {
        cleanable.clean();
    }
}
