package in.co.rays.proj04.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {

	private static JDBCDataSource jdbc = null;
	private static ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.proj4.bundle.System");

	// Multiple connection pools create honge.
	// Extra memory consume hogi.
	// Database connections unnecessarily increase ho sakte hain.
	// Application ki performance affect ho sakti hai.
	private JDBCDataSource() {

		// JDBCDataSource class mein hum Singleton Design Pattern ka use isliye
// hain taaki poore application mein JDBCDataSource ka sirf ek hi object create ho aur hum usi object ko baar-baar reuse kar sakein.

		cpds = new ComboPooledDataSource();
		
		//cpds database ke multiple connections ka ek pool maintain karta hai. 

		try {
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setMaxPoolSize(30);
			cpds.setMinPoolSize(5);
			cpds.setAcquireIncrement(5);
			cpds.setInitialPoolSize(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static JDBCDataSource getInstance() {

		if (jdbc == null) {
			jdbc = new JDBCDataSource();
			return jdbc;
		}
		return null;

	}

	public static Connection getConnection() {

		try {
			return getInstance().cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void closeConnection(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void trnRollBack(Connection conn) {

		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
