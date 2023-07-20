package com.jsp.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductUpdateController {
	public static void main(String[] args) {
		Connection connection = null;
		//method present in exception 
		//print stack trace
		//get message
		//
		try {
			
			//step-1 Load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 Create Connection
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "root";
			
			connection = DriverManager.getConnection(url, user, pass);
			
			//step-3  Create Statement
			
			String updateColorQuery = "update product set productcolor= ? where productid =?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(updateColorQuery);
			
			preparedStatement.setString(1, "White");
			preparedStatement.setInt(2, 100);
			
			int a = preparedStatement.executeUpdate();
			
			if(a==1)
			{
				System.out.println("Data is updated.");
			}
			else
			{
				System.err.println("Data id is not present.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
