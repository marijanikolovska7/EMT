package mk.finki.ukim.backend.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(){
        super("Author Not Found!");
    }
}
