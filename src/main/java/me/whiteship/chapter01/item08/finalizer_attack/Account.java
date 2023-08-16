package me.whiteship.chapter01.item08.finalizer_attack;

import java.math.BigDecimal;

/*
Finalizer 공격 방어 방법
1. Account가 상속을 허용하지 않을 거라면, final 클래스로 만들 수 있다.
2. 상속을 허용해야 할 경우, finalizer() 메소드를 오버라이딩 한 다음 final을 붙여서 하위 클래스에서 오버라이딩 할 수 없게 만들 수 있다.
 */
public class Account {

    private String accountId;

    public Account(String accountId) {
        this.accountId = accountId;

        // 이럼에도 불구하고, 푸틴의 계좌에서 돈을 보내게 할 수 있다.
        if (accountId.equals("푸틴")) {
            // unchecked exception. 런타임 계열의 예외이기 때문에 생성자 선언부에 아무것도 선언하지 않아도 된다.
            throw new IllegalArgumentException("푸틴은 계정을 막습니다.");
        }
    }

    public void transfer(BigDecimal amount, String to) {
        System.out.printf("transfer %f from %s to %s\n", amount, accountId, to);
    }

    /*
    아무것도 하지 않는 finalize를 만들어 final 키워드를 붙여 오버라이딩을 허용하지 않는 메서드를 만든다.
    BrokenAccount은 상속을 할 수는 있지만 finalize 메서드를 재정의할 수 없다.

    @Override
    protected final void finalize() throws Throwable {
    }
     */
}
