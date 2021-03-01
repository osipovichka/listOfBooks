import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book one, Book other) {
        int result =  one.getAuthor().getFullName().compareTo(other.getAuthor().getFullName());

        if (result == 0){
            return one.getName().compareTo(other.getName());
        }

        return result;
    }
}
