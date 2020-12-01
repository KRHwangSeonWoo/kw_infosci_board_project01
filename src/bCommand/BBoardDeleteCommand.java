package bCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;

public class BBoardDeleteCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bKey=Integer.parseInt(request.getParameter("bKey"));
		BoardDao dao=BoardDao.getInstance()	;
		dao.boardDelete(bKey);
	}

}
