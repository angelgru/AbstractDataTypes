import java.io.File;

public class DirectoryListingRecursion {

    static void traverse(File file) {
        if(!file.isDirectory()) {
            System.out.println(file.toString());
        } else {
            for(File f: file.listFiles()) {
                traverse(f);
            }
        }
    }

    public static void main(String[] args) {

        File file = new File("/home/angel/Documents/");
        traverse(file);
    }
}
