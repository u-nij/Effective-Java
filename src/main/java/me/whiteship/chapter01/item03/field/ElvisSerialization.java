package me.whiteship.chapter01.item03.field;

import java.io.*;

// 역직렬화로 여러 인스턴스 만들기
public class ElvisSerialization {

    public static void main(String[] args) {
        // 직렬화 -> 직렬화할 때 생성자가 필요.
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
            out.writeObject(Elvis.INSTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 역직렬화
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
            Elvis elvis3 = (Elvis) in.readObject(); // 읽어올 때, 새로운 인스턴스가 만들어진다. => 인스턴스가 여러개가 생길 수 있다.

            /*
            Elvis의 readResolve() 메서드를 재정의하지 않았을 경우 false
            */
            System.out.println(elvis3 == Elvis.INSTANCE); // true
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
