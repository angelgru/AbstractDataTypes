import java.io.*;

public class LinkedListStackOfStrings {

//    Stack Abstract Data Type implementation using LinkedList

    private Node first;

    private class Node {
        Node next;
        String value;

        Node(String s) {
            this.value = s;
            this.next  =null;
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

    public static void main(String[] args) {
        File file = new File("/home/angel/Documents/linkedList.txt");
        String str = "Hello world how are you ?";

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(reverse(str));
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c;
            while ((c=bufferedReader.read()) != -1) {
                stringBuilder.append((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());

    }
}
