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
public void enqueue(char value) {
    if (size == queue.length) {
        System.out.println("Queue is full.");
        return;
    }

    rear = (rear + 1) % queue.length;
    queue[rear] = value;
    size++;
}
}