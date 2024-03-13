package JDBCUTILITIES;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	public static String database = null;

	public static Connection getConnection() {
		FileInputStream fs = null;
		Properties p = new Properties();
		Connection con = null;
		try {
			fs = new FileInputStream("D:\\PRACTICE_I213\\emp_crud_app\\src\\JDBCUTILITIES\\connection.properties");
			p.load(fs);
			database = p.getProperty("database");
			con = DriverManager.getConnection(p.getProperty("url") + database, p.getProperty("username"),
					p.getProperty("password"));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnections(Connection con, Statement st, ResultSet rs) throws SQLException {
		if (con != null) {
			con.close();
		}
		if (st != null) {
			st.close();
		}
		if (rs != null) {
			rs.close();
		}
	}

	public static void setDatabasename(String selecteddatabase) {
		database = selecteddatabase;
	}

}
