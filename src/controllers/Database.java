package controllers;

import java.sql.*;

import javax.swing.JOptionPane;

import views.LoginPanel;

import models.User;

public class Database {

	private Connection my_con;
	private Statement sqlState;
	private String username, password;

	public Database() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		my_con = DriverManager.getConnection("jdbc:mysql://localhost/DB","root","");
		sqlState = my_con.createStatement();
	}
	public Connection getConnection(){
		return my_con;
	}
	public void insert(final User user) throws SQLException{
		String insert = "insert into userData "+"values('"+user.getMy_schedule()+"','"+user.getLastName()+","
				+user.getFirstName()+"','"+user.getMy_procedure()+"','"+user.getMy_length()+"'," +
				"'2014-09-09','01:01:01','01:01:01');";
		sqlState.executeUpdate(insert);
	}
	public void update(final String statement, User user) throws SQLException{
		sqlState.executeUpdate(statement);
	}
	public void delete(final String statement, User user) throws SQLException{
		sqlState.executeUpdate(statement);
	}
	public ResultSet findUser(final String username, final String password) throws SQLException{
		String find = "select * from logIn where username ='"+username+"' and password = '"+password+"';";
		ResultSet set = sqlState.executeQuery(find);
		return set;
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		User user = new User("Edward", "Bassan","pass", 1234556, "134 199th pl",
				"Monday", 9990, 5, 2006,5, 4);
	    Database db = new Database();
		db.findUser("u", "u");

	 

		// A connection object is used to provide access to a database

		Connection conn = null;

		try {
			// The driver allows you to query the database with Java
			// forName dynamically loads the class for you

			Class.forName("com.mysql.jdbc.Driver");

			// DriverManager is used to handle a set of JDBC drivers
			// getConnection establishes a connection to the database
			// You must also pass the userid and password for the database

			conn = DriverManager.getConnection("jdbc:mysql://localhost/DB","root","");

			// Statement objects executes a SQL query
			// createStatement returns a Statement object

			Statement sqlState = conn.createStatement();

			// This is the query I'm sending to the database

			String selectStuff = "Select * from userData";
			// "schedule, doctor, producer, length, date, st et";
			//insert into user_info values('x','x','5','5','2014-4-1','01:01:45','03:34:40');
			String insert = "insert into userData "+"values('"+user.getMy_schedule()+"','"+user.getLastName()+","
					+user.getFirstName()+"','"+user.getMy_procedure()+"','"+user.getMy_length()+"'," +
					"'2014-09-09','01:01:01','01:01:01');";
			// A ResultSet contains a table of data representing the
			// results of the query. It can not be changed and can
			// only be read in one direction

			 sqlState.executeUpdate(insert);
			  
			ResultSet rows = sqlState.executeQuery(selectStuff);

			// next is used to iterate through the results of a query
		 	while(rows.next()){
		 		System.out.print(rows.getString("schedule")+" ");
			System.out.print(rows.getString("doctor")+" ");

		 	}


		}catch (SQLException ex) {

			// String describing the error

			System.out.println("SQLException: " + ex.getMessage());

			// Vendor specific error code

			System.out.println("VendorError: " + ex.getErrorCode());

		}catch (ClassNotFoundException e) {
			// Executes if the driver can't be found
			e.printStackTrace();
		}

	}
}