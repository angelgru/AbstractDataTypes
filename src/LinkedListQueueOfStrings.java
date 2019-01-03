public class LinkedListQueueOfStrings {

    Node front;
    Node back;

    class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    LinkedListQueueOfStrings() {
        this.front = null;
        this.back = null;
    }

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(String v) {
        Node newNode = new Node(v);
        if(front == null){
            front = newNode;
            back = newNode;
        }
        back.next = newNode;
        back = newNode;
    }

    String dequeue() {
        if(!isEmpty()) {
            String v = front.value;
            front = front.next;
            return v;
        }

        return null;
    }


    public static void main(String[] args) {
        LinkedListQueueOfStrings queue = new LinkedListQueueOfStrings();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.dequeue();
        queue.enqueue("Three");
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }

}
