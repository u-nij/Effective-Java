package me.whiteship.chapter01.item02.varargs;

import java.util.Arrays;

public class VarargsSamples {

    public void printNumbers(int... numbers) {
                            // (int... numbers, String name) => 가변인수는 매개변수의 맨 마지막에 있어야 한다.
                            // (int... numbers, String... names) => 가변인수는 여러 개 선언할 수 없다.
        System.out.println(numbers.getClass().getCanonicalName()); // numbers가 실제 어떤 타입인지 출력 // int[](배열)
        System.out.println(numbers.getClass().getComponentType()); // numbers가 어떤 타입의 배열인지 출력 // int
        Arrays.stream(numbers).forEach(System.out::println); // 가변인수가 가지고 있는 값을 출력
    }

    public static void main(String[] args) {
        VarargsSamples samples = new VarargsSamples();
        samples.printNumbers(1, 20, 20, 39, 59);
    }
}
