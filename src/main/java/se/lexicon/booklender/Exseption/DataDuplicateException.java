package se.lexicon.booklender.Exseption;

public class DataDuplicateException extends RuntimeException{
    public DataDuplicateException(String message) {
        super(message);
    }
}
