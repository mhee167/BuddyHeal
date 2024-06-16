package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("/updateBoard")
public class updateBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        BoardDAO dao = new BoardDAO();

    	//board_id 전달받기
        String boardIdStr = request.getParameter("board_id");
        int board_id = 0; 

        // String->Integer로 변환
        if (boardIdStr != null && !boardIdStr.isEmpty()) {
           
               board_id = Integer.parseInt(boardIdStr);
            
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String is_public = request.getParameter("secret"); 

     
        BoardDTO board = new BoardDTO();
        board.setBoardId(board_id); 
        board.setTitle(title);
        board.setContent(content);
        

        if (is_public != null && is_public.equals("yes")) {
            // 체크 박스가 체크된 경우의 처리- secretValue가 "yes"일 때의 동작을 수행
            board.setIs_public(1);;
        } else {
            // 체크 박스가 체크되지 않은 경우의 처리- secretValue가 null이거나 "yes"가 아닐 때의 동작을 수행
         board.setIs_public(0);}

        System.out.println(title+" "+content+" "+board_id+" "+is_public);
       
        // updateBoard 메서드 수행
        dao.updateBoard(board);
	
        // board_id가 getParam으로 받은 id인 상세조회 페이지로 이동
        response.sendRedirect(request.getContextPath() + "/memberServlet?command=detail&board_id=" +boardIdStr);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
