package dbconnection;

import java.sql.*;

public class Connectionsql  {
Connection con;
public Connectionsql(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}
	catch(ClassNotFoundException e){
		System.err.print(e.fillInStackTrace());
	}
	try {
		this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/systemedegestioneducative","root","0000");
		
	}catch(Exception e){
		System.err.print("no connection");
	}}	
public Connection getConnection() {
	return this.con;
	

}
}