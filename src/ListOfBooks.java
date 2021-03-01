import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfBooks {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Path to files: ");
        String path = in.nextLine();
        in.close();

        File[] listOfFiles = new File(path).listFiles();
        List<Book> books = new ArrayList<Book>();

        for (File file : listOfFiles) {
            String fileName = file.getName();
            if(file.isFile() && (fileName.endsWith(".fb2") || fileName.endsWith(".fb2.zip"))){
                if(fileName.endsWith(".fb2.zip")){
                    books.add(Parse.parse(UnZip.unZip(file.getAbsolutePath(), path)));
                    file.delete();
                } else {
                    books.add(Parse.parse(file.getAbsolutePath()));
                }
            }
        }

        for (Book book : books){
            System.out.println(book);
        }
    }
}

