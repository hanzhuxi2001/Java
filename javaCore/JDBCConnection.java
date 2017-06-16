package javaCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("orcale.jdbc.driver.orcaleDriver");
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:orcale:thin@localhost:1521:ocal", "user", "password");
			ps = c.prepareStatement("select * from employee where name=?");
			ps.addBatch("");
			ps.addBatch("insert into settings values(3,'liu')");
			ps.addBatch("insert into settings values(4,'zhi')");
			ps.addBatch("insert into settings values(5,'jun')");
			ps.executeBatch();
			ps.setString(1, "hh17097");
			rs = ps.executeQuery();
			rs.setFetchSize(200);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
					ps.close();
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

}

class JDBCBatchSize {
	public static final int SINGLE_BATCH = 1;
	public static final int SMALL_BATCH = 4;
	public static final int MEDIUM_BATCH = 11;
	public static final int LARGE_BATCH = 51;

	public static final void process(int totalNumberOfValuesLeftToBatch) throws SQLException {
		while (totalNumberOfValuesLeftToBatch > 0) {
			int batchSize = SINGLE_BATCH;
			if (totalNumberOfValuesLeftToBatch >= LARGE_BATCH) {
				batchSize = LARGE_BATCH;
			} else if (totalNumberOfValuesLeftToBatch >= MEDIUM_BATCH) {
				batchSize = MEDIUM_BATCH;
			} else if (totalNumberOfValuesLeftToBatch >= SMALL_BATCH) {
				batchSize = SMALL_BATCH;
			}
			totalNumberOfValuesLeftToBatch -= batchSize;
			StringBuilder inClause = new StringBuilder();
			boolean firstValue = true;
			for (int i = 0; i < batchSize; i++) {
				inClause.append('?');
				if (firstValue) {
					firstValue = false;
				} else {
					inClause.append(',');
				}
			}
			Connection conn = DriverManager.getConnection("jdbc:orcale:thin@localhost:1521:ocal", "user", "password");

			PreparedStatement stmt = conn
					.prepareStatement("select id, name from users where id in (" + inClause.toString() + ')');
			for (int i = 0; i < batchSize; i++) {
				stmt.setInt(i, 100); // or whatever values you are trying to
										// query by
			}
		}

	}

}