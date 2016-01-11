package com.nhn.guestBoard.dto;

import java.sql.Timestamp;

public class Dto {

	int IDX;
	String EMAIL;
	String CONTENT;
	Timestamp POST_TIME;
	Timestamp EDIT_TIME;
	
	public Dto() {
		
	}
	
	public int getIDX() {
		return IDX;
	}

	public void setIDX(int iDX) {
		IDX = iDX;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public Timestamp getPOST_TIME() {
		return POST_TIME;
	}

	public void setPOST_TIME(Timestamp pOST_TIME) {
		POST_TIME = pOST_TIME;
	}

	public Timestamp getEDIT_TIME() {
		return EDIT_TIME;
	}

	public void setEDIT_TIME(Timestamp eDIT_TIME) {
		EDIT_TIME = eDIT_TIME;
	}
	
}
