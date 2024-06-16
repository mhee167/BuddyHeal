package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BoardDAO;


@WebServlet("/delBoard")
public class delBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        BoardDAO dao = new BoardDAO();

        String board_id = request.getParameter("board_id");
        System.out.println("borad_id"+board_id);

        dao.delBoard(board_id);

        response.sendRedirect(request.getContextPath() + "/jsp/board.jsp");

        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
