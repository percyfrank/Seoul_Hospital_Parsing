package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class Stack2Test {

    @BeforeEach
    void setUp() {
//        System.out.println("Before Each");
    }

    @Test
    @DisplayName("push가 잘 되는지")
    void push() {
        Stack2 stack = new Stack2();
        stack.push(10);
        stack.push(20);
        Integer[] arr = stack.getArr();

        assertEquals(20,arr[1]);
        assertEquals(10,arr[0]);
    }

    @Test
    @DisplayName("pop이 잘 되는지")
    void pushAndPop() {
        Stack2 stack = new Stack2();
        stack.push(10);
        stack.push(20);
        assertEquals(20,stack.pop());
        assertEquals(10,stack.pop());
        // Exception 예외의 검증
        assertThrows(EmptyStackException.class,() -> {
            stack.pop();
        });
//        stack.pop();
    }

    @Test
    public void isEmpty() throws Exception {
        //given
        Stack2 stack = new Stack2();
        //when
        //then
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void realStack() throws Exception {
        //given
        Stack<Integer> stack = new Stack<>();
        //when
        assertThrows(EmptyStackException.class, ()->{
            stack.pop();
        });
//        stack.pop();
        //then
    }


}