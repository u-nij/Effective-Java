package me.whiteship.chapter01.item01;

import me.whiteship.hello.ChineseHelloService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    /*
    인터페이스 타입을 사용할 수 있다.
    return type으로 HelloService라는 인터페이스를 넣어놨지만,
    실상 return되는 것은 인터페이스의 구현체인 KoreanHelloService와 EnglishHelloService로 변경 가능.

    또는, 클래스를 선언해놓고, 해당하는 클래스의 하위 클래스를 리턴할 수도 있다.

    고정적이지 않다.
    생성자를 사용할 땐, KoreanHelloService 혹은 EnglishHelloService"만" 가져올 수 있었다.
    생성자는 해당하는 클래스의 인스턴스만 만들어주는 반면, 리턴 타입에 호환 가능한 다른 타입의 인스턴스를 리턴해도 된다..

    매개변수에 따라 다른 인스턴스를 리턴할 수도 있다.

    자바 8 이후, static한 메서드를 인터페이스에 선언할 수 있게 됨.
    즉, Factory 메서드에 굳이 따로 정적 팩토리 메서드를 가지고 있는 클래스를 많이 만들지 않아도 된다.

    // HelloService 인터페이스로 코드 이동
    public static HelloService of(String lang) {
        if (lang.equals("ko")) {
            return new KoreanHelloService();
        } else {
            return new EnglishHelloService();
        }
    }
    */

    /*
    인터페이스 기반의 프레임워크를 사용할 수 있게 해준다.
    HelloServiceFactory 를 거쳐 어떤 인스턴스를 가져오던, 타입이 인터페이스 타입이 된다.
    클라이언트 코드로부터 인터페이스 기반의 프레임워크를 사용하도록 강제할 수 있다.
    구체적인 타입을 클라이언트로부터 숨길 수 있다.
    */
    /*
    public static void main(String[] args) {
        HelloService ko = HelloServiceFactory.of(lang."ko");
    }
    */


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        HelloService eng = HelloService.of("eng");
//        System.out.println(eng.hello()); // eng

        /*
        정적 팩토리 메서드를 작성하는 시점에 인터페이스만 있고, 구현체가 없어도 된다.
        
        (HelloService 구현체 주석처리 후 실행)
        HelloService 타입의 임의의 서비스를 로드.
        ServiceLoader가 참조할 수 있는 class path 내 모든 HelloService의 구현체를 가져온다.

        SerivceLoader => 서비스 제공자 프레임워크의 자바 기본 구현체

        chinese-hello-service\src\main\resources\META-INF\services\me.whiteship.chapter01.item01.HelloService
        => 제공할 구현체의 인터페이스의 풀 패키지 경로.

        me.whiteship.chapter01.item01.HelloService에 적힌 내용. 즉, me.whiteship.hello.ChineseHelloService
        => 제공할 구현체 풀 패키지 경로.

        패키징할 때 jar 파일 안에 META-INF 안의 정보가 들어가게 되고, pom.xml에 jar 파일로 하여금 참조할 수 있게 설정.
        */
        // 서비스 접근 API : ServiceLoader를 통해 실제 서비스를 가져오는 과정
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello()); // Ni Hao
        });


        /*
        위와 아래 방식의 차이점: ChineseHelloService에 대한 의존성.

        위의 코드는 어떤 임의의 구현체가 올지 전혀 모르는 반면, 아래의 코드는 명확하게 표기되어 있다.
        위의 코드는 어떤 구현체가 올지 모르지만, 그 구현체가 따르고 있는 인터페이스 기반으로 코딩하면 된다. (ex. JDBC Driver 동작 방식)
        아래의 코드는 ChineseHelloService를 import해야 실행할 수 있다.
        */

        HelloService helloService = new ChineseHelloService();
        System.out.println(helloService.hello()); // Ni Hao


        /*
        “서비스 제공자 인터페이스가 없다면 각 구현체를 인터페이스로 만들 때 리플렉션을 이용해야 한다”
        위에 주석 처리 후 실행
        */
        // 클래스 정보를 직접 참조하지 않는 이상 Class.forName() 으로 시작. 문자열으로 클래스를 만드는 것.
        Class<?> aClass = Class.forName("me.whiteship.hello.ChineseHelloService"); // 문자열을 통해 Class 인스턴스를 만듦.
        // 아래와 같은 방법을 통해 클래스 정보를 참조 or 접근 제어자와 관계 없이 값을 변경하거나 메소드를 호출할 수 있다.
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        // 클래스라는 레퍼런스를 통해 생성자를 가져와 인스턴스를 만들 수 있다.
        Constructor<?> constructor = aClass.getConstructor();
        HelloService helloService1 = (HelloService) constructor.newInstance();
        System.out.println(helloService1.hello());
    }

}
