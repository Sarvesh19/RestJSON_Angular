package com.formrest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTestDAO {

	public  List<Employee> JdbcMain() throws ClassNotFoundException, SQLException {
		// MySQL connection details.
		Statement stmt = null;
		String username = ("sarvesh");
		String password = ("sarvesh");
		String url = ("jdbc:derby://localhost:1527/Employee;create=true");
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection conn = DriverManager.getConnection(url, username, password);

		// PreparedStatement stmt=con.prepareStatement("insert into Emp
		// values(?,?)");
		PreparedStatement predstmt = conn.prepareStatement("insert into Persons values(?,?,?,?,?)");
		predstmt = conn.prepareStatement("DELETE FROM Persons WHERE personid=101");
		// predstmt.setInt(1, 101);// 1 specifies the first parameter in the
		// query
		// predstmt.setString(2, "Ratan");
		// predstmt.setString(3, "Ratan");
		// predstmt.setString(4, "Ratan");
		// predstmt.setString(5, "Ratan");
		return getEmpData_From_Query_And_SetEmp(predstmt, conn, stmt);
	}

	public static List<Employee> getEmpData_From_Query_And_SetEmp(PreparedStatement predstmt, Connection conn, Statement stmt) throws SQLException {
		int i = predstmt.executeUpdate();
		System.out.println(i + " records affected");

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Persons");

		List<Employee> listempl = new ArrayList<Employee>();
		Employee employee = null;
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					+ " " + rs.getString(5));
			
			employee = new Employee();
			setEmployee_Data(employee, listempl, rs);
		}
		conn.close();
		return listempl;
	}

	private static void setEmployee_Data(Employee employee, List<Employee> listempl, ResultSet rs) throws SQLException {
		employee.setAddress(rs.getString(4));
		employee.setCity(rs.getString(5));
		employee.setFirstName(rs.getString(3));
		employee.setLastname(rs.getString(2));
		employee.setPersonId(rs.getString(1));
		listempl.add(employee);
	}
}
