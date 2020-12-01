package bFrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bCommand.BCommand;
import bCommand.BContent_viewCommand;
import bCommand.BMainCommand;
import bCommand.BReplyDeleteCommand;
import bCommand.BReplyModifyCommand;
import bCommand.BWriteCommand;
import bCommand.BWriteReplyCommand;
import bCommand.BBoardDeleteCommand;
import bCommand.BBoardModifyCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("doGet");
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo");
		request.setCharacterEncoding("EUC-KR");
		
		String movePage=null;
		BCommand bCommand=null;
		String uri=request.getRequestURI();
		String conpath= request.getContextPath();
		String com= uri.substring(conpath.length());
	
		

		if(com.equals("/write.do")) {
			bCommand=new BWriteCommand();
			bCommand.play(request, response);
		    movePage="main.do";
		   
			
		}

		else if(com.equals("/main.do")) {
			bCommand=new BMainCommand();
			bCommand.play(request,response);
			movePage="main.jsp";

		}
		
		else if(com.equals("/content_view.do")) {
			bCommand=new BContent_viewCommand();
			bCommand.play(request,response);
			movePage="content_view.jsp";
		
		
		}
		
		else if(com.equals("/boardModify.do")) {
			bCommand=new BBoardModifyCommand();
			bCommand.play(request, response);
			movePage="main.do";
		}
		
		else if(com.equals("/boardDelete.do")) {
			bCommand=new BBoardDeleteCommand();
			bCommand.play(request,response);
			movePage="main.do";
		}
		
		else if(com.equals("/writeReply.do")) {
			bCommand=new BWriteReplyCommand();
			bCommand.play(request,response);
			movePage="content_view.do";
		}

		else if(com.equals("/replyModify.do")) {
			bCommand=new BReplyModifyCommand();
			bCommand.play(request,response);
			movePage="content_view.do";
		}

		else if(com.equals("/replyDelete.do")) {
			bCommand=new BReplyDeleteCommand();
			bCommand.play(request, response);
			movePage="content_view.do";
		}
		
		else if(com.equals("/write_page_jsp.do")) {
			movePage="write_page.jsp";
		}
		
		else if(com.equals("/login_jsp.do")) {
			movePage="login.jsp";
		}
		
		else if(com.equals("/boardModify_jsp.do")) {
			movePage="boardModify.jsp";
		}
		
		else if(com.equals("/boardDelete_jsp.do")) {
			movePage="boardDelete.jsp";
		}
		
		else if(com.equals("/joinAfter_jsp.do")) {
			movePage="joinAfter.jsp";
		}
		
		else if(com.equals("/infoModify_jsp.do")) {
			movePage="infoModify.jsp";
		}
		
		else if(com.equals("/loginAfter_jsp.do")) {
			movePage="loginAfter.jsp";
		}
		
		else if(com.equals("/infoModifyAfter_jsp.do")) {
			movePage="infoModifyAfter.jsp";
		}
		
		else if(com.equals("/login_jsp.do")) {
			movePage="login.jsp";
		}
		
		else if(com.equals("/replyModify_jsp.do")) {
			movePage="replyModify.jsp";
		}
		
		else if(com.equals("/replyDelete_jsp.do")) {
			movePage="replyDelete.jsp";
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(movePage);
		dispatcher.forward(request, response);
		
		
		
	}

	
	
}
