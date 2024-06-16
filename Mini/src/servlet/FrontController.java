package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BoardDAO;

// mapping 이름을 frontcontroller로 변경했어야 함..
@WebServlet("/memberServlet")

public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String command = request.getParameter("command");
        System.out.println(command);

        if (command != null) {
        	// 멤버 추가
            if (command.equals("insertMember")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/insertMember");
                dispatcher.forward(request, response);
            }
        	// 멤버 삭제
            if (command.equals("delMember")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/delMember");
                dispatcher.forward(request, response);
            }
        	// 멤버 업데이트
            if (command.equals("updateMember")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/updateMember");
                dispatcher.forward(request, response);
            }
            
            //로그인 검사            
            if (command.equals("userCheckMember")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/userCheckMember");
                dispatcher.forward(request, response);
                
            }
            //모든 게시글 조회
            if (command.equals("boardSelect")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/boardSelect");
                dispatcher.forward(request, response);
                
            }
            //게시글 추가
            if (command.equals("boardInsert")) { //원래는 boardInsertServlet으로 되어 있었음.
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/boardInsertServlet");
            	dispatcher.forward(request, response);
            	
            }
            //게시글 삭제
            if (command.equals("delBoard")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/delBoard");
                dispatcher.forward(request, response);
            }
          //게시글 업데이트
            if (command.equals("updateBoard")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/updateBoard");
                dispatcher.forward(request, response);
            }
            //상세 조회 보기
            if (command.equals("detail")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/detail");
                dispatcher.forward(request, response);    
           }
          //좋아요 수 증가
            if (command.equals("likes")) {
       
                RequestDispatcher dispatcher = request.getRequestDispatcher("/likes");
                dispatcher.forward(request, response);
            
           }
                      
        }
    }
}
