package me.whiteship.chapter01.item02.hierarchicalbuilder;


import static me.whiteship.chapter01.item02.hierarchicalbuilder.NyPizza.Size.SMALL;
import static me.whiteship.chapter01.item02.hierarchicalbuilder.Pizza.Topping.*;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {
    public static void main(String[] args) {
        /*
        self()를 사용하지 않고, this를 사용했을 때.

        NyPizza pizza = (MyPizza) new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION).build();

        타입캐스팅이 필요하다.
        build()가 NyPizza.Builder의 build가 아닌, Pizza.Builder의 build가 되어서 Pizza를 리턴하게 되기 때문이다.
        */

        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION).build();

        // this를 사용하면 사용하지 못한다.
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
        
        System.out.println(pizza);
        System.out.println(calzone);
    }
}
