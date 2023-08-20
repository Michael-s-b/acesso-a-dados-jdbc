package db;

public class DbIntegrityException extends RuntimeException {
    private static final long serialVersionUID = -7651797006L;

    public DbIntegrityException(String msg) {
        super(msg);
    }

}
