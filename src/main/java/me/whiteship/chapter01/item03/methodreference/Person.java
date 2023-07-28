package me.whiteship.chapter01.item03.methodreference;

import autovalue.shaded.com.google$.common.base.$Function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    LocalDate birthday;

    public Person() {

    }

    // 생성자
    public Person(LocalDate birthday) {
        this.birthday = birthday;
    }

    // 스태틱 메서드
//    public static int compareByAge(Person a, Person b) {
//        return a.birthday.compareTo(b.birthday);
//    }

    // 인스턴스 메서드
//    public int compareByAge(Person a, Person b) {
//        return a.birthday.compareTo(b.birthday);
//    }

    // 임의 객체의 인스턴스 메서드
    public int compareByAge(Person b) { // 첫 번째 인자는 자기 자신이고, 두 번째 인자부터 적는다고 생각.
        return this.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {
        // LocalDate를 받아 Person을 리턴받는 람다 익스프레션. 호환 가능한 생성자는 Person(LocalDate birthday)밖에 없다.
        $Function<LocalDate, Person> aNew = Person::new;

        /*
        생성자 레퍼런스

        비어있는 생성자와 파라미터가 있는 생성자가 있을 때, 무조건 파라미터가 있는 생성자를 참조한다.
        d -> Peron::new; LocalDate가 생략되어 있는 것이기 때문에  파라미터가 있는 생성자 참조.

        하지만, 외부에서 Person::new 라고만 참조하면 어떤 것을 참조하려는 것인지 모른다.
        */
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(1982, 7, 15));
        dates.add(LocalDate.of(1982, 7, 15));
        // 클릭해보면, 어떤 것을 참조하는지 알 수 있다.
        dates.stream().map(Person::new).collect(Collectors.toList()); // d -> Peron::new


        List<Person> people = new ArrayList<>();
        people.add(new Person(LocalDate.of(1982, 7, 15)));
        people.add(new Person(LocalDate.of(2011, 3, 2)));
        people.add(new Person(LocalDate.of(2013, 1, 28)));

        // 자바8 이전의 방법. 익명 내부 클래스를 이용해 직접 Comparator를 만들어주던 방법.
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.birthday.compareTo(b.birthday);
            }
        });
        // 자바8 이후.
        people.sort((p1, p2) -> p1.birthday.compareTo(p2.birthday));

        /*
        람다 익스프레션 안에서 하는 일이 오로지 어떠한 메서드 하나를 호출하는 일이라면,
        그 메서드 호출하는 일 자체를 메서드 레퍼런스로 간추려 쓸 수 있다.
        */
//        people.sort((p1, p2) -> Person.compareByAge(p1, p2)); // 람다 익스프레션
        /*
        스태틱 메서드 레퍼런스; 일종의 람다 익스프레션을 만드는 방법.
        static 메서드를 참조하기 때문에, 클래스 이름을 사용.(Person::compareByAge)
        Comparator에 호환이 되는 타입의 메서드.
        */
//        people.sort(Person::compareByAge)

        /*
        인스턴스 메서드 레퍼런스; 인스턴스를 통해 호출해야 하기 때문에 객체를 생성.
        */
//        Person person = new Person(null);
//        people.sort(person::compareByAge);

        /*
        임의 객체의 인스턴스 메서드 레퍼런스; 객체를 생성하지 않고 인스턴스 메서드를 레퍼런스하는 방법.
        인스턴스 메서드를 클래스 이름으로 참조. 첫 번째 인자가 자기 자신이 된다.
        */
        Comparator<Person> compareByAge = Person::compareByAge;
        people.sort(compareByAge);
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

}
