package me.whiteship.chapter01.item03.serialization;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable { // 인터페이스를 구현하지 않으면 NotSerializableException 예외 발생

    /*
    직렬화하는 시스템과 역직렬화하는 시스템이 다를 때, 직렬화 이후 클래스를 변경하게 되면
    serialVersionUID가 일치하지 않아 InvalidClassException 예외가 발생한다.

    임의로 serialVersionUID를 명시하여 역직렬화가 가능하도록 만들어줄 수 있다.
    */
    private static final long serialVersionUID = 1L;

    // static 필드의 값은 클래스에 할당되는 값이며, 인스턴스에 할당되는 값이 아니기 때문에 직렳화되지 않는다.
    // 직렬화 후 클래스가 바뀌면 역직렬화가 될 것인가?
    public static String staticField;

    private String isbn;

    private String title;

    // 직렬화 후, author 코드 추가
    private String author;

    private LocalDate published;

    private String name;

    private transient int numberOfSold; // 직렬화를 하고 싶지 않은 데이터의 경우 transient 키워드 추가

    public Book(String isbn, String title,
                String author, // 직렬화 후, author 코드 추가
                LocalDate published) {
        this.isbn = isbn;
        this.author = author; // 직렬화 후, author 코드 추가
        this.title = title;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", author=" + author + // 직렬화 후, author 코드 추가
                ", numberOfSold=" + numberOfSold +
                ", staticField=" + staticField +
                '}';
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public void setNumberOfSold(int numberOfSold) {
        this.numberOfSold = numberOfSold;
    }
}
