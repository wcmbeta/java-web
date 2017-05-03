import org.junit.Test;

import java.sql.*;

/**
 * Created by Water on 17/4/10.
 * Email:water471871679@gmail.com
 */
public class Main {
	@Test
	public void testJdbc() throws SQLException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/com.water.test", "root", "dickgo");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM person ;");
			while (resultSet.next()) {
				int nameIndex = resultSet.findColumn("name");
				String name = resultSet.getString(nameIndex);
				int age = resultSet.getInt(resultSet.findColumn("age"));
				System.out.println(name + "--" + age);
			}
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}finally {
			connection.close();

		}
	}
}
