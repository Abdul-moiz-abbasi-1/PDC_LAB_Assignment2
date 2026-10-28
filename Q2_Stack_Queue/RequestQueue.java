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
public char dequeue() {
    if (isEmpty()) {
        System.out.println("Queue is empty.");
        return '\0';
    }

    char value = queue[front];
    front = (front + 1) % queue.length;
    size--;

    return value;
}
public boolean isEmpty() {
    return size == 0;
}
}