package bCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;

public class BBoardModifyCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bKey=Integer.parseInt(request.getParameter("bKey"));
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		BoardDao dao=BoardDao.getInstance()	;
		dao.boardModify(bKey, bTitle, bContent);
		

		
	}

}
