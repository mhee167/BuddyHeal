package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dao.BoardDAO;

@WebServlet("/likes")
public class LikeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//board_id 전달받기
        String boardIdStr = request.getParameter("board_id");

        BoardDAO dao = BoardDAO.getInstance();

        if (boardIdStr != null && !boardIdStr.isEmpty()) {
            try {
            	//해당 board_Id를 가진 게시글의 좋아요 증가
                dao.incrementLikes(boardIdStr);
                // board_id가 getParam으로 받은 id인 상세조회 페이지로 이동
                response.sendRedirect(request.getContextPath() + "/detail?board_id=" + boardIdStr);
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
