package algorithm;

import java.util.EmptyStackException;

public class Stack2 {

    private Integer[] arr;
    private int top = 0;

    public Stack2() {
        this.arr = new Integer[10000];
    }

    public Stack2(int size) {
        this.arr = new Integer[size];
    }
    public Integer[] getArr() {
        return arr;
    }

    public void push(int value) {
        this.arr[this.top++] = value;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return this.arr[--this.top];
    }

    public boolean isEmpty() {
//        boolean isEmpty = this.top == 0;
        return this.top == 0;
    }
}
