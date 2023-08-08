package me.whiteship.chapter01.item07.listener;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatRoom {

    /*
    올바른 WeakReference 사용법이 아니다. 절대로 이렇게 쓰면 안된다.
    WeakReference를 List로 쓰면 삭제되지 않는다.

    '해당 객체에 넣은 레퍼런스들이 더이상 참조하지 않으면, 리스트에서 사라지겠구나. 편하겠다.'는 생각은 틀리다.
    WeakReference를 삭제해주는 기능은 WeakHashMap에 들어있는 기능.
    WeakReference를 참조하는 객체가 없어질 때 WeakReference 자체를 없애고 싶다면, 커스텀한 List를 만들어야 한다.
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
        // Strong Reference
        ChatRoom chatRoom = new ChatRoom(); // ChatRoom 오브젝트를 가리키는 chatRoom
        chatRoom = null; // null을 가리키는 chatRoom
        // ChatRoom를 참조하는 객체가 없다. 즉, strongReference하는 객체가 없다. -> GC의 대상이 된다.
        return users;
    }
}
