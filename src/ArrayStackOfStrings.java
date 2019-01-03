import java.io.*;
import java.util.Optional;

public class ArrayStackOfStrings {

    private int arraySize;
    private int size;
    private String[] array;

    ArrayStackOfStrings(int arraySize) {
        this.arraySize = arraySize;
        this.size = -1;
        this.array = new String[arraySize];
    }

    public boolean isEmpty() {
        return size == -1;
    }

    public void push(String item) {
        if(size != arraySize)
            array[++size]=item;
    }

    public Optional<String> pop() {
        if(!isEmpty())
            return Optional.of(array[size--]);
        else
            return Optional.empty();
    }

    public static String reverseString(String original) {
        String[] words = original.split(" ");
        ArrayStackOfStrings stack = new ArrayStackOfStrings(words.length);
        for(String s: words) {
            stack.push(s);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stack.pop().ifPresent((String s) -> {stringBuilder.append(s);});
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {


        String str = "How are you mate, are you feeling good mate?";
        String reversed = reverseString(str);

        FileOutputStream fileOutputStream;

        try{
            fileOutputStream = new FileOutputStream("/home/angel/Documents/reversed.txt");
            fileOutputStream.write(reversed.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fileInputStream;
        StringBuilder stringBuilder = new StringBuilder();
        int c;
        try{
            fileInputStream = new FileInputStream("/home/angel/Documents/reversed.txt");
            while ((c=fileInputStream.read()) != -1)
                stringBuilder.append((char) c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuilder.toString());
    }
}
