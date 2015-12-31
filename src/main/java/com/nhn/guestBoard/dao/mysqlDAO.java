package com.nhn.guestBoard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nhn.guestBoard.dto.Dto;

public class mysqlDAO implements Dao {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public mysqlDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestBoard", "root", "root");
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<Dto> list() {
		
		try {
			String sql = "SELECT IDX, EMAIL, CONTENT, POST_TIME, EDIT_TIME FROM ARTICLE";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while ( resultSet.next() ) {
				System.out.println(resultSet.getString("EMAIL"));
			}
			
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	

	@Override
	public void write(String EMAIL, String PW, String CONTENT) {

		try {
			String sql = "INSERT INTO ARTICLE(EMAIL, PW, CONTENT)"
							+ "VALUES(?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, EMAIL);
			preparedStatement.setString(2, PW);
			preparedStatement.setString(3, CONTENT);
			preparedStatement.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(int IDX, String EMAIL, String PW, String CONTENT) {

		try {
			boolean check = false;
			String sql = "SELECT EMAIL, PW FROM ARTICLE WHERE IDX = " + IDX;
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			if ( resultSet.next() ) 
				if ( resultSet.getString("EMAIL").equals(EMAIL) ) 
					if ( resultSet.getString("PW").equals(PW) ) 
						check = true;
			
			if ( check ) {
				sql = "UPDATE ARTICLE SET CONTENT = '" + CONTENT + "' WHERE IDX = " + IDX ;
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.executeUpdate();
			}
				
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		
	}
	
}
