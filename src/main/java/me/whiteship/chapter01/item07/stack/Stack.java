package me.whiteship.chapter01.item07.stack;

import java.util.Arrays;

// 코드 7-1 메모리 누수가 일어나는 위치는 어디인가? (36쪽)
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        return elements[--size]; // 데이터가 사라지지 않고 쌓이기만 한다. 언젠가 배열이 꽉 차 메모리 누수가 생김.
//    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // 코드 7-2 제대로 구현한 pop 메서드 (37쪽)
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result; // 해당 오브젝트를 리턴받는 곳에서는 참조할 수 있지만, elements 안에서는 참조 해제됨.
        // 리턴받은 메서드에서 해당 오브젝트의 사용이 끝나면, 그 메서드의 바운더리에 벗어나기 때문에 생명 주기가 끝나게 된다.
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }
}
