package me.whiteship.chapter01.item07.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {

    /*
    올바른 WeakReference 사용법이 아니다. 절대로 이렇게 쓰면 안된다.
    추후에 설명 예정.
     */
    private List<WeakReference<User>> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(new WeakReference<>(user));
    }

    public void sendMessage(String message) {
        // 리스트 순회하며 receive() 메서드 호출
        users.forEach(wr -> Objects.requireNonNull(wr.get()).receive(message));
    }

    public List<WeakReference<User>> getUsers() {
        return users;
    }
}
