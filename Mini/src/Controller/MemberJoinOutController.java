package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoDto.MemberDAO;

/**
 * Servlet implementation class JoinOutController
 */
@WebServlet("/frontcontroller/member/joinOut")
public class MemberJoinOutController extends ControllerV1 {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		MemberDAO dao=MemberDAO.getInstance();
		
		String user_id=(String)session.getAttribute("user_id");
		System.out.println(user_id);
		dao.delMember(user_id);
		
		out.println("<script language='javascript'>");
        out.println("alert(\"회원 탈퇴가 완료되었습니다.\");");
        out.println("</script>");
        
        session.invalidate();
    	response.sendRedirect("/Mini/index.jsp");
		
	}

}
