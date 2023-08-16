package me.whiteship.chapter01.item07.optional;

import java.util.Optional;
import java.util.OptionalLong;

public class Channel {

    private int numOfSubscribers;

    public Optional<MemberShip> defaultMemberShip() {
        /*
        기존에는 IllegalStateException 에러를 던지거나, null을 리턴.
        -> 자바8 이후, 비어 있는 객체에 대해 Optional을 사용해 리턴해줄 수 있다.

        Optional을 활용한 API 개발을 통해 NPE 에러를 방지할 수 있다.
         */
        if (this.numOfSubscribers < 2000) {
            // return null;
            return Optional.empty();
        } else {
            // return new MemberShip();
            return Optional.of(new MemberShip());
        }
    }
}
