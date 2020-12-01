package bCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;

public class BReplyDeleteCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BoardDao dao=BoardDao.getInstance()	;
		int reKey=Integer.parseInt(request.getParameter("reKey"));
		dao.replyDelete(reKey);
		
	}

}
