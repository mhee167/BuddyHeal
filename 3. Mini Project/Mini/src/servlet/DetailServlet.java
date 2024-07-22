package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String boardIdStr = request.getParameter("board_id");
        System.out.println(boardIdStr);

        BoardDAO dao = BoardDAO.getInstance();

        if (boardIdStr != null && !boardIdStr.isEmpty()) {
            try {
            	
            	//dto생성
                BoardDTO detail = dao.detailBoard(boardIdStr);
              
                if (detail != null) {
                	 
                    // 조회수 증가
                    dao.incrementCount(boardIdStr);
                    //dto 전달
                	request.setAttribute("detail", detail);
                	//detail.jsp로 포워딩
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/detail.jsp");
                    dispatcher.forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "게시글을 찾을 수 없습니다.");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 게시글 ID 형식입니다.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "게시글 ID가 제공되지 않았습니다.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
