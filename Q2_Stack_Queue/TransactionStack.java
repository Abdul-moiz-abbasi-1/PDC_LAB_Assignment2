public class TransactionStack {
    private char[] stack;
    private int top;

    public TransactionStack(int capacity) {
    stack = new char[capacity];
    top = -1;
}
}
