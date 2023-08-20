import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DB;
import db.DbIntegrityException;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("delete from department " +
                    "where " +
                    "Id = ?");
            st.setInt(1, 2);
            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (Exception e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
