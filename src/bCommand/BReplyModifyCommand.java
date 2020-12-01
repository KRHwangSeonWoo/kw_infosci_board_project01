package bCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;

public class BReplyModifyCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int reKey=Integer.parseInt(request.getParameter("reKey"));
		String reContent=request.getParameter("reContent");
		BoardDao dao=BoardDao.getInstance()	;
		dao.replyModify(reKey, reContent);
	}

}
