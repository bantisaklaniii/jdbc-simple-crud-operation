package com.jsp.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductDisplayController {
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
				
				//step-3  Create Statement
				
				String deleteQuery = "delete from product where productid =?";
				
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
				
				preparedStatement.setInt(1, 100);
				
				int a = preparedStatement.executeUpdate();
				
				if(a==1)
				{
					System.out.println("Data is deleted.");
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
