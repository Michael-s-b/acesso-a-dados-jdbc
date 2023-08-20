import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import db.DB;
import db.DbException;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();
            int rows1 = st.executeUpdate("update seller set BaseSalary = 3500 where DepartmentId = 1");

            // Simulating a system error
            // int x = 1;
            // if (x < 2) {
            // throw new SQLException("Fake error");
            // }

            int rows2 = st.executeUpdate("update seller set BaseSalary = 2900 where DepartmentId = 2");
            System.out.println("Done! Rows affected: " + "rows1: " + rows1 + ", " + "rows2: " + rows2);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }

        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
