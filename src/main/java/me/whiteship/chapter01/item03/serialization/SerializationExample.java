package me.whiteship.chapter01.item03.serialization;

import java.io.*;
import java.time.LocalDate;

public class SerializationExample {

    // 직렬화
    private void serialize(Book book) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
            out.writeObject(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 역직렬화
    private Book deserialize() {
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
            return (Book) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    직렬화 및 역직렬화
    */
//    public static void main(String[] args) {
//        Book book = new Book("12345", "이팩티브 자바 완벽 공략",
//                LocalDate.of(2022, 3, 21));
//        book.setNumberOfSold(200); // 직렬화할 떄 200, 역직렬화할 때 0(직렬화하지 않았기 때문)
//
//        SerializationExample example = new SerializationExample();
//        Book.staticField = "effective";
//        example.serialize(book);
//        Book.staticField = "java"; // static 필드 값은 직렬화가 되지 않기 때문에 역직렬화할 때에도 "java"가 프린트 된다.
//        Book deserializedBook = example.deserialize();
//
//        System.out.println(book);
//        System.out.println(deserializedBook);
//    }

    /*
    직렬화
    */
//    public static void main(String[] args) {
//        Book book = new Book("12345", "이팩티브 자바 완벽 공략",
//                LocalDate.of(2022, 3, 21));
//        book.setNumberOfSold(200); // 직렬화할 떄 200, 역직렬화할 때 0(직렬화하지 않았기 때문)
//
//        SerializationExample example = new SerializationExample();
//
//        example.serialize(book);
//        System.out.println(book);
//    }

    /*
    역직렬화
    */
    public static void main(String[] args) {
        SerializationExample example = new SerializationExample();

        Book deserializedBook = example.deserialize();
        System.out.println(deserializedBook);
    }
}
