package db;

import java.sql.Connection;

public class TestConn {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		DB.closeConnection();

	}

}
