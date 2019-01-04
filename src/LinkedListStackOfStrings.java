import java.io.*;
import java.util.Iterator;

public class LinkedListStackOfStrings implements Iterable<String>{

//    Stack Abstract Data Type implementation using LinkedList

    private Node first;

    private class Node {
        Node next;
        String value;

        Node(String s) {
            this.value = s;
            this.next = null;
        }
    }

    LinkedListStackOfStrings() {
        first = null;
    }

    boolean isEmpty() {
        return first == null;
    }

    void push(String value) {
        Node newNode = new Node(value);
        newNode.next = first;
        first = newNode;
    }

    String pop() {
        String val = first.value;
        first = first.next;
        return val;
    }

    static String reverse(String source) {
        String[] splitted = source.split(" ");
        LinkedListStackOfStrings stack = new LinkedListStackOfStrings();
        for(String s: splitted) {
            stack.push(s);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<String> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            String value = current.value;
            current = current.next;
            return value;
        }
    }

    public static void main(String[] args) {
//        File file = new File("/home/angel/Documents/linkedList.txt");
//        String str = "Hello world how are you ?";
//
//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(reverse(str));
//            bufferedWriter.flush();
//            bufferedWriter.close();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        try{
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            int c;
//            while ((c=bufferedReader.read()) != -1) {
//                stringBuilder.append((char)c);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(stringBuilder.toString());

        LinkedListStackOfStrings stack = new LinkedListStackOfStrings();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        for(String s: stack) {
            System.out.println(s);
        }

//        for each equals to
        Iterator<String> iterator  = stack.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
