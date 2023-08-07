package me.whiteship.chapter01.item07.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {

    @Test
    void npe() {
        Channel channel = new Channel();
        /*
        MemberShip memberShip = channel.defaultMemberShip();
        if (memberShip != null) {
            memberShip.equals(new MemberShip());
        }
         */
        Optional<MemberShip> optional = channel.defaultMemberShip();
        optional.ifPresent(MemberShip::hello);

        /*
        MemberShip membership = optional.get(); // NoSuchElementException 에러 발생
        membership.hello();
         */
    }

}