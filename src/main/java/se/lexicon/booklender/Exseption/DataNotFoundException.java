package se.lexicon.booklender.Exseption;

public class DataNotFoundException extends RuntimeException{

    public DataNotFoundException(String message) {
        super(message);
    }
}
