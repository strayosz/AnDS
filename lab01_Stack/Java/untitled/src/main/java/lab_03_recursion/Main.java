package lab_03_recursion;

public class Main {
    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        Node.reverse(node1);
//        System.out.println(node4.next.value);
//        System.out.println(node3.next.value);
//        System.out.println(node2.next.value);
//        System.out.println(node1.next.value);
    }

    public static double logFact(int n) {
        if (n <= 1) {
            return 0;
        }
        return logFact(n - 1) + Math.log10(n);
    }

}

class Node {
    public int value;
    public Node next;
    public Node nextR;
    public Node nextL;

    public Node(int value) {
        this.value = value;
    }

    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        reverse(node.next).next = node;
        return node;
    }

}
