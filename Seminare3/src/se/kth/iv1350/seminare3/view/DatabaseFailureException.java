package se.kth.iv1350.seminare3.view;
/**
 *DatabaseFailureException is thrown when Controller cant connect to database. Since there is no real database,
 * this exception is thrown only when itemIdentifier = 10 is used.
 */
public class DatabaseFailureException extends RuntimeException{
    public DatabaseFailureException(String msg) {
        super(msg);
    }
}
