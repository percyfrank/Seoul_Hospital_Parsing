package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushTest() {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        int[] arr = stack.getArr();
        Assertions.assertEquals(10,arr[0]);
        Assertions.assertEquals(20,arr[1]);
    }

    @Test
    @DisplayName("push가 잘 되는지 pop이 잘 되는지")
    void pushAndPop() {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);

        Assertions.assertEquals(20,stack.pop());
        Assertions.assertEquals(10,stack.pop());
        stack.push(30);
        Assertions.assertEquals(30,stack.pop());

    }

}