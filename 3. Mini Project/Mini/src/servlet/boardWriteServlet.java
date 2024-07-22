package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.MemberDAO;
import dto.MemberDTO;

//@WebServlet("/boardWrite")
public class boardWriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        MemberDAO dao = new MemberDAO();

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // 받은 데이터를 DTO에 설정
        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPwd(pwd);
        member.setName(name);
        member.setAddress(address);
        member.setPhone(phone);
        member.setEmail(email);

        dao.insertMember(member);
        response.sendRedirect(request.getContextPath() + "/main.jsp");


    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
