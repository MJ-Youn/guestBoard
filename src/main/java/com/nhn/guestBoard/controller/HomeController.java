package com.nhn.guestBoard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nhn.guestBoard.dao.mysqlDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String list(Model model) {
		
		mysqlDAO dao = new mysqlDAO();
		model.addAttribute("list", dao.list());
		
		return "guestBoard";
		
	}
	
	@RequestMapping(value="/write")
	public String write(HttpServletRequest httpServletRequest, Model model) {
		
		String EMAIL = httpServletRequest.getParameter("EMAIL");
		String PW = httpServletRequest.getParameter("PW");
		String CONTENT = httpServletRequest.getParameter("CONTENT");
		
		mysqlDAO dao = new mysqlDAO();
		dao.write(EMAIL, PW, CONTENT);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/modify")
	public String modify(HttpServletRequest httpServletRequest, Model model) {
		
		int IDX = Integer.parseInt(httpServletRequest.getParameter("IDX"));
		String EMAIL = httpServletRequest.getParameter("EMAIL");
		String PW = httpServletRequest.getParameter("PW");
		String CONTENT = httpServletRequest.getParameter("CONTENT");
		
		mysqlDAO dao = new mysqlDAO();
		boolean check = dao.modify(IDX, EMAIL, PW, CONTENT);
		
		if ( check ) {
			return "redirect:/";
		} else {
			return "modifyFail";
		}
		
	}
	
}
