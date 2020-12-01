package bCommand;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;
import boardPackage.BoardDto;

public class BContent_viewCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
	
		// TODO Auto-generated method stub
		int bKey=Integer.parseInt(request.getParameter("bKey"));
		BoardDao dao= BoardDao.getInstance();
		BoardDto dto=dao.content_view(bKey);
		ArrayList<BoardDto> replys=dao.reply_view(bKey);
		dao.upHit(bKey);
		request.setAttribute("dto",dto);
		request.setAttribute("replys", replys);
		
	}

}
