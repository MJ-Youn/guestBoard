package com.nhn.guestBoard.dao;

import java.util.ArrayList;

import com.nhn.guestBoard.dto.Dto;

public interface Dao {

	public ArrayList<Dto> list();
	public void write(String EMAIL, String PW, String CONTENT);
	public void modify(int IDX, String EMAIL, String PW, String CONTENT);
	
}
