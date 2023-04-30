package mk.finki.ukim.backend.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(){
        super("Book Not Found!");
    }
}
