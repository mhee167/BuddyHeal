package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/delMember")
public class delMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        MemberDAO dao = new MemberDAO();

        String id = request.getParameter("id");
       
        dao.delMember(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/show.jsp");
        dispatcher.forward(request, response);
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
