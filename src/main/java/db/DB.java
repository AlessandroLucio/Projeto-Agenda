package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {
		
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("url");
				String driver = props.getProperty("driver");
				Class.forName(driver);
				conn = DriverManager.getConnection(url, props);
				System.out.println(conn);
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			} catch (ClassNotFoundException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("C:\\Java\\workspace\\Agenda_Contatos\\db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
