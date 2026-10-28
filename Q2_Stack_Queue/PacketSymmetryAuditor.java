public class PacketSymmetryAuditor {

public boolean isSymmetric(String packet) {
    TransactionStack stack = new TransactionStack(packet.length());
    RequestQueue queue = new RequestQueue(packet.length());

    for (int i = 0; i < packet.length(); i++) {
        stack.push(packet.charAt(i));
        queue.enqueue(packet.charAt(i));
    }

    while (!stack.isEmpty()) {
        if (stack.pop() != queue.dequeue()) {
            return false;
        }
    }

    return true;
}
}