package bCommand;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardPackage.BoardDao;
import boardPackage.BoardDto;

public class BMainCommand implements BCommand {

	@Override
	public void play(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDao dao= BoardDao.getInstance();
		ArrayList<BoardDto> dtos=dao.main();
		
		request.setAttribute("dtos", dtos);
      
		
	}

}
