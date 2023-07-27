package me.whiteship.chapter01.item03.enumtype;

import me.whiteship.chapter01.item03.field.Elvis;

import java.io.*;

public class EnumElvisSerialization {

    public static void main(String[] args) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
            out.writeObject(Elvis.INSTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))) {
            Elvis elvis = (Elvis) in.readObject();
            System.out.println(elvis == Elvis.INSTANCE); // true // 역직렬화하면, 동일한 인스턴스가 된다.
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
