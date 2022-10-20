package algorithm;

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
        this.arr[top] = value;
        this.top++;
    }

    public int pop() {
        int value = this.arr[this.top-1];
        this.top--;
        return value;
    }
}
