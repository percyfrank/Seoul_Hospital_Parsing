package algorithm;

import org.junit.jupiter.api.Assertions;
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

}