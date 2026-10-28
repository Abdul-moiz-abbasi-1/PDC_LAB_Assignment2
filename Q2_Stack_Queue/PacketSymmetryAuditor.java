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
public static void main(String[] args) {
    PacketSymmetryAuditor auditor = new PacketSymmetryAuditor();

    String packet1 = "ABCDCBA";
    String packet2 = "ABCDEF";

    System.out.println(packet1 + " is symmetric: "
            + auditor.isSymmetric(packet1));

    System.out.println(packet2 + " is symmetric: "
            + auditor.isSymmetric(packet2));
}
}