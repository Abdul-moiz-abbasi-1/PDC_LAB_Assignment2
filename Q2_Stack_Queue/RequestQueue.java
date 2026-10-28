public class RequestQueue {
private char[] queue;
private int front;
private int rear;
private int size;
public RequestQueue(int capacity) {
    queue = new char[capacity];
    front = 0;
    rear = -1;
    size = 0;
}
}