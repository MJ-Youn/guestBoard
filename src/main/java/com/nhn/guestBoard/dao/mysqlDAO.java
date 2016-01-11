package com.nhn.guestBoard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.nhn.guestBoard.dto.Dto;

public class mysqlDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public mysqlDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestBoard", "root", "root");
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Dto> list() {
		
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		
		try {
			
			String sql = "SELECT IDX, EMAIL, CONTENT, POST_TIME, EDIT_TIME FROM POSTS;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while ( rs.next() ) {
				
				Dto dto = new Dto();
				dto.setIDX(rs.getInt("IDX"));
				dto.setEMAIL(rs.getString("EMAIL"));
				dto.setCONTENT(rs.getString("CONTENT"));
				dto.setPOST_TIME(rs.getTimestamp("POST_TIME"));
				
				if ( rs.getTime("EDIT_TIME") != null ) {
					dto.setEDIT_TIME(rs.getTimestamp("EDIT_TIME"));
				} else {
					dto.setEDIT_TIME(null);
				}
				
				dtos.add(dto);
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return dtos;
		
	}
	
	public void write(String EMAIL, String PW, String CONTENT) {
		
		try {
			
			String sql = "INSERT INTO POSTS(EMAIL, PW, CONTENT) VALUE(?, ?, ?);";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, EMAIL);
			stmt.setString(2, PW);
			stmt.setString(3, CONTENT);
			stmt.executeUpdate();
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public boolean modify(int IDX, String EMAIL, String PW, String CONTENT) {
		
		boolean check = false;
		
		try {
			
			String sql = "SELECT PW FROM POSTS WHERE IDX = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, IDX);
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				if ( rs.getString("PW").equals(PW) )
					check = true;
			}
			
			if ( check ) {
				sql = "UPDATE POSTS SET CONTENT = ? WHERE IDX = ?;";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, CONTENT);
				stmt.setInt(2, IDX);
				stmt.executeUpdate();
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		return check;
		
	}
	
	public void disConnect() {
		
		try {
			if ( rs != null ) rs.close();
			if ( stmt != null ) stmt.close();
			if ( conn != null ) conn.close();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
}
