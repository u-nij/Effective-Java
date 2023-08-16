package me.whiteship.chapter01.item08.finalizer_attack;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AccountTest {

    @Test
    void 일반_계정() {
        Account account = new Account("keesun");
        account.transfer(BigDecimal.valueOf(10.4),"hello");
    }

    @Test
    void 푸틴_계정() {
        Account account = new Account("푸틴");
        account.transfer(BigDecimal.valueOf(10.4),"hello");
    }

    @Test
    void 푸틴_계정_Finalize_공격() throws InterruptedException {
        Account account = null; // 만들다 만 객체
        try {
            // BrokenAccount에서 부모 생성자를 호출해 account를 생성하고, Account 클래스의 if문을 거쳐가는 것은 동일하다.
            account = new BrokenAccount("푸틴");
        } catch (Exception exception) { // 예외를 잡을 수 있다.
            System.out.println("이러면???");
        }

        System.gc(); // GC 발생.
        Thread.sleep(3000L); // GC가 호출했을 떄 바로 일어나지 않을 수 있기 때문에.
        // finalize가 호출되면서 transfer가 실행된다.
    }

}