import java.util.Stack;

public class MyStack {

    public Stack<String> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String top() {
        return stack.peek();
    }

    public String pop() {
        return stack.pop();
    }

    public void push(String value) {
        stack.push(value);
    }
}