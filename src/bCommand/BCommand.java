package bCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {

	void play(HttpServletRequest request, HttpServletResponse response);
	
}
