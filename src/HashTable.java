import java.util.Iterator;
import java.util.Optional;

public class HashTable {

    int N = 128;
    private Node[] linkedList = new Node[128];

    private class Node implements Iterable<String> {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public Iterator<String> iterator() {
            return null;
        }

        class MyIterator implements Iterator<String> {

            Node current = next;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String v = current.value;
                current = current.next;
                return v;
            }
        }
    }

    int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % N;
    }

    void put(String key, String value) {
        int position = hash(key);
        Node node = new Node(key, value);

        Node trav = linkedList[position];
        if(trav == null)
            linkedList[position] = node;
        else {
            Node prev = trav;
            while (trav != null) {
                prev = trav;
                if(trav.key.equals(key))
                    trav.value = value;
                trav = trav.next;
            }
            prev.next = node;
        }
    }

    Optional<String> get(String key) {
        int position = hash(key);

        Node trav = linkedList[position];
        while (trav != null) {
            if(trav.key.equals(key))
                return Optional.of(trav.value);
            trav = trav.next;
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put("Ang", "Angel");
        hashTable.put("Ang", "Marchel");

        hashTable.get("Ang").ifPresent((String s) -> {
            System.out.println(s);
        });

    }


}
