package com.nhn.guestBoard.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.nhn.guestBoard.dao.Dao;
import com.nhn.guestBoard.dao.mysqlDAO;
import com.nhn.guestBoard.dto.Dto;

public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Dao dao = new mysqlDAO();
		ArrayList<Dto> dtos =  dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
