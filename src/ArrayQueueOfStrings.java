public class ArrayQueueOfStrings {

    String[] queue;
    int queueSize;
    int size;
    int front;
    int back;

    ArrayQueueOfStrings(int size) {
        this.queue = new String[size];
        this.queueSize = size;
        this.size = 0;
        front = -1;
        back = -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(String s) {

        if(size == 0) {
            front = 0;
            back = 0;
            queue[back] = s;
        } else if(back == (queueSize - 1) && size != queueSize) {
            back = 0;
            queue[back] = s;
        } else {
            queue[++back] = s;
        }
        size++;
    }

    String dequeue() {
        if(size > 0) {
            String s = queue[front++];
            if(front == queueSize)
                front = 0;
            size--;
            return s;
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayQueueOfStrings queue = new ArrayQueueOfStrings(3);
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.dequeue();
        queue.enqueue("Fourth");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
