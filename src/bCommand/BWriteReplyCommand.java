package bCommand;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bCommand.BCommand;
import boardPackage.BoardDao;

public class BWriteReplyCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bKey=Integer.parseInt(request.getParameter("bKey"));
		String reId=request.getParameter("reId");
		String reContent=request.getParameter("reContent");
		BoardDao dao=BoardDao.getInstance();
		dao.writeReply(bKey, reId, reContent);
		
		
		
		
		
		
		
		
		
		
	}

}
