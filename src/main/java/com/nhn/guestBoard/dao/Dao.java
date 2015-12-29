package com.nhn.guestBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nhn.guestBoard.dto.Dto;

public class Dao {

	DataSource dataSource;
	
	public Dao() {
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Dto> list() {
		
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT IDX, EMAIL, CONTENT, POST_TIME, EDIT_TIME FROM ARTICLE ORDER BY IDX DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while ( resultSet.next() ) {
				Dto dto = new Dto();
				dto.setIDX(resultSet.getInt("IDX"));
				dto.setEMAIL(resultSet.getString("EMAIL"));
				dto.setCONTENT(resultSet.getString("CONTENT"));
				dto.setPOST_TIME(resultSet.getTimestamp("POST_TIME"));
				if ( resultSet.getTimestamp("EDIT_TIME").equals(null) ) {
					dto.setEDIT_TIME(resultSet.getTimestamp("EDIT_TIME"));
				} 
				
				dtos.add(dto);
			}
			
		} catch ( Exception e1 ) {
			e1.printStackTrace();
		} finally {
			try {
				if ( resultSet != null ) resultSet.close();
				if ( preparedStatement != null ) preparedStatement.close();
				if ( connection != null ) connection.close();
			} catch ( Exception e2 ) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
		
	}
	
}
