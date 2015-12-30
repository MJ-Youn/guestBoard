package com.nhn.guestBoard.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhn.guestBoard.dao.Dao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/")
	public String list(Model model) {
		
		Dao dao = sqlSession.getMapper(Dao.class);
		model.addAttribute("list", dao.list());
		
		return "guestBoard";
		
	}
	
}
