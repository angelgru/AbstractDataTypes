import java.util.Iterator;

public class Hash<Key, Value> {

    private int m = 1024;
    private Node[] lists = new Node[m];

    private int hash(Key key) {
        return Math.abs(key.hashCode() % m);
    }

    public Value get(Key key) {
        int i = hash(key);
        Node x = lists[i];

        while (x != null) {
            if(key.equals(x.key))
                return (Value) x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = hash(key);

        Node x = lists[i];
        while (x != null) {
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        lists[i] = new Node(key, value, lists[i]);
    }

    private class Node<Key, Value> {
        private Key key;
        private Value value;
        private Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
