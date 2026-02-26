package caesar.exception;

/**
 * Signals that an error specific to the Caesar application has occurred.
 * This is a checked exception used for handling invalid user commands,
 * corrupted storage files, and date parsing errors.
 */
public class CaesarException extends Exception {

    /**
     * Constructs a new CaesarException with the specified detail message.
     * 
     * @param message The specific error message to be displayed to the user.
     */
    public CaesarException(String message) {
        super(message);
    }
}
