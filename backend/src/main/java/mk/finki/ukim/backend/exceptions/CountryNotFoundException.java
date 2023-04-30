package mk.finki.ukim.backend.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(){
        super("Country Not Found!");
    }
}
