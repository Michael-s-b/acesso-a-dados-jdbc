package db;

public class DbException extends RuntimeException {
    private static final long serialVersionUID = -943228713L;

    public DbException(String msg) {
        super(msg);
    }

}
