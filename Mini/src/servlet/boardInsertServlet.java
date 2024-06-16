package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("/boardInsertServlet")
public class boardInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        BoardDAO dao = new BoardDAO();
        
        
        // 파라미터를 받아서 객체에 설정
        String title = request.getParameter("title");
        String author = null;
        
        HttpSession session = request.getSession(); 
        
        // 세션을 받아서 author 값을 사용
        if (session != null) {
            author = (String) session.getAttribute("author");
        }        
        String content = request.getParameter("content");
        String is_public = request.getParameter("secret"); 
        
        //*********************

        BoardDTO board = new BoardDTO();
                
        board.setTitle(title);
        board.setAuthor(author);
        board.setContent(content);
        
        // 체크 박스가 체크된 경우의 처리>  secretValue가 "yes"일 때의 동작을 수행
        if (is_public != null && is_public.equals("yes")) {           
            board.setIs_public(1);;
        } else {
            // 체크 박스가 체크되지 않은 경우의 처리> secretValue가 null이거나 "yes"가 아닐 때의 동작을 수행
            board.setIs_public(0);;
        }
        
        board.setRegdate(new java.sql.Timestamp(System.currentTimeMillis()));
        board.setCount(0);
        board.setLikes(0);
        
        //board dto 객체를 insert
        dao.insertBoard(board);
        
       
        // 게시글을 추가한 이후 board.jsp로 포워딩
        response.sendRedirect(request.getContextPath() + "/jsp/board.jsp");

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
