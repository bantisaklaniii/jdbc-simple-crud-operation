package com.jsp.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductInsertController {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			//step-1 Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "root";
			
			connection = DriverManager.getConnection(url, user, pass);
			
			//step-3 Create Statement
	
			String insertQuery = "insert into product values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, 103);
			preparedStatement.setString(2, "Bag");
			preparedStatement.setDouble(3, 500);
			preparedStatement.setString(4, "Red");
			
			preparedStatement.execute();
			
			System.out.println("Data---Stored");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}


}
