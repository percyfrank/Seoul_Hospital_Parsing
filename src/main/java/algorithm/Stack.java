package algorithm;

public class Stack {
    private int[] arr = new int[10000];

    private int pointer = 0;

    public Stack() {
    }

    public Stack(int size) {
        this.arr = new int[size];
    }

    public void push(int value) {
        this.arr[this.pointer] = value;
        this.pointer++;
    }

    public int pop() {
        this.pointer--;
        int value = this.arr[this.pointer];
        return value;
    }

    public int[] getArr() {
        return arr;
    }
}
