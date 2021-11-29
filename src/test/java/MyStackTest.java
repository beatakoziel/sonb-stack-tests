import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void Given_StackNotUsed_When_IsEmpty_Should_ReturnTrue() {
        //given
        MyStack stack = new MyStack();
        //when
        boolean result = stack.isEmpty();
        //then
        assertTrue(result);
    }

    @Test
    void Given_StackNotUsed_When_Top_Should_ThrowException() {
        //given
        MyStack stack = new MyStack();
        //when-then
        assertThrows(EmptyStackException.class, stack::top);
    }

    @Test
    void Given_StackNotUsed_When_Pop_Should_ThrowException() {
        //given
        MyStack stack = new MyStack();
        //when-then
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void Given_FilledStack_When_Top_Should_NotBeEmptyAndReturnCorrectValues() {
        //given
        MyStack stack = new MyStack();
        String expected = "Ala ma kota";
        stack.push(expected);
        List<String> result = new ArrayList<>();
        //when
        for (int i = 0; i < 3; i++) {
            result.add(stack.top());
        }
        //then
        assertFalse(stack.isEmpty());
        result.forEach(element -> assertEquals(expected, element));
    }

    @Test
    void Given_FilledStack_When_Pop_Should_BeEmptyAndReturnCorrectValue() {
        //given
        MyStack stack = new MyStack();
        String expected = "Ala ma kota";
        stack.push(expected);
        //when
        String result = stack.pop();
        //then
        assertSame(expected, result);
        assertTrue(stack.isEmpty());
    }

    @Test
    void Given_FilledStack_When_Pop_Should_BeEmptyAndReturnValuesInCorrectOrder() {
        //given
        MyStack stack = new MyStack();
        String[] array = new String[]{"Ala", "ma", "kota"};
        for (String element : array) {
            stack.push(element);
        }
        //when-then
        assertSame(array[2], stack.pop());
        assertSame(array[1], stack.pop());
        assertSame(array[0], stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void Given_StackFilledWithNull_When_Pop_Should_ReturnNull() {
        //given
        MyStack stack = new MyStack();
        stack.push(null);
        //when
        String result = stack.pop();
        //then
        assertNull(result);
    }

    @Test
    public void Given_StackWithThrownException_When_Pop_Should_ReturnValueCorrectly() {
        //given
        MyStack stack = new MyStack();
        String expected = "Ala ma kota";
        //when
        try {
            stack.pop();
        } catch (EmptyStackException ex) {
        }
        stack.push(expected);
        //then
        assertEquals(expected, stack.pop());
    }

}