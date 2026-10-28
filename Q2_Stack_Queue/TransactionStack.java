public class TransactionStack {
    private char[] stack;
    private int top;

    public TransactionStack(int capacity) {
    stack = new char[capacity];
    top = -1;
}
public void push(char value) {
    if (top == stack.length - 1) {
        System.out.println("Stack is full.");
        return;
    }

    top++;
    stack[top] = value;
}
public char pop() {
    if (isEmpty()) {
        System.out.println("Stack is empty.");
        return '\0';
    }

    char value = stack[top];
    top--;
    return value;
}
}
