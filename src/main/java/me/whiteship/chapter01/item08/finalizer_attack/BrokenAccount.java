package me.whiteship.chapter01.item08.finalizer_attack;

import java.math.BigDecimal;

// Finalizer 공격
public class BrokenAccount extends Account {

    public BrokenAccount(String accountId) {
        super(accountId); // 부모의 생성자 호출
    }

    // finalize 재정의
    @Override
    protected void finalize() throws Throwable {
        this.transfer(BigDecimal.valueOf(100), "keesun");
    }
}

