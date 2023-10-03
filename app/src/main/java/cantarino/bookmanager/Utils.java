package cantarino.bookmanager;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        allBooks.add(new Book(1, "Book1", "Author1", 100,
                "https://marketplace.canva.com/EAFersXpW3g/1/0/1003w/canva-blue-and-white-modern-business-book-cover-cfxNJXYre8I.jpg",
                "It's a nice book!", "It's a really, really, really, really, really, really, really, really nice book.", false));
        allBooks.add(new Book(2, "Book2", "Author2", 200,
                "https://marketplace.canva.com/EAFersXpW3g/1/0/1003w/canva-blue-and-white-modern-business-book-cover-cfxNJXYre8I.jpg",
                "It's a nice book!", "It's a really, really, really, really, really, really, really, really nice book.", false));
    }

    public static Utils getInstance() {
        if (null != instance){
            return  instance;
        } else {
            instance = new Utils();
            return instance;
        }
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b: allBooks) {
            if(b.getId() == id) {
                return  b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }

}