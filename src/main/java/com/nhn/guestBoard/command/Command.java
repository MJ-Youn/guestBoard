package com.nhn.guestBoard.command;

import org.springframework.ui.Model;

public interface Command {

	void execute(Model model);
	
}
