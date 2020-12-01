package bCommand;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;

public class BWriteCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String id= request.getParameter("id");
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		BoardDao dao=BoardDao.getInstance();
		dao.write(id, bTitle, bContent);	

			
	}


	

}
