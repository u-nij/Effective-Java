package me.whiteship.chapter01.item03.field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConcertTest {

    @Test
    void perform() {
        // Concert concert = new Concert(Elvis.INSTANCE); // 진짜 Elvis를 호출해 테스트.
        Concert concert = new Concert(new MockElvis()); // 인터페이스를 통해 구현된 대역을 사용해 테스트.
        concert.perform();

        assertTrue(concert.isLightsOn());
        assertTrue(concert.isMainStateOpen());
    }

}