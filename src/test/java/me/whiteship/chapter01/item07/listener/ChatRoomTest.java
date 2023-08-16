package me.whiteship.chapter01.item07.listener;

import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatRoomTest {

    @Test
    void charRoom() throws InterruptedException {
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User();
        User user2 = new User();

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        chatRoom.sendMessage("hello");

        user1 = null; // 여전히 List<WeakReference<User>>에 남아 있다.

        System.gc();

        Thread.sleep(5000L);

        List<WeakReference<User>> users = chatRoom.getUsers();
        assertTrue(users.size() == 1); // users.size() = 2
        /*
        디버깅해보면 users.user1가 null임을 알 수 있다.
        weakReference가 참조하고 있는 오브젝트가 없어졌을 때 weakReference를 비워주는 작업을 해주는 List를 커스텀하게 만들어야 한다.
         */
    }

}