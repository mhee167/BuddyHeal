package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoDto.MemberDAO;
import DaoDto.MemberDTO;


@WebServlet("/frontcontroller/member/load")
public class MemberLoadController extends ControllerV1 {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String id=(String) session.getAttribute("user_id");
		MemberDAO dao=MemberDAO.getInstance();
		MemberDTO dto=null;
		
		dto=dao.getMember(id);
		
		String user_id=dto.getUser_id();
		String user_name=dto.getUser_name();
		String user_pw=dto.getUser_pw();
		String user_pw_re=dto.getUser_pw_re();
		String user_phone=dto.getUser_phone();
		String user_email=dto.getUser_email();
		
		
		//원래는 request였지만, dispatch를 하면 uri가 이전 페이지와 동일하여 css 적용이 안됨. -> session으로 전달.
		session.setAttribute("user_id", user_id);
		session.setAttribute("user_name", user_name);
		session.setAttribute("user_pw", user_pw);
		session.setAttribute("user_pw_re", user_pw_re);
		session.setAttribute("user_phone", user_phone);
		session.setAttribute("user_email", user_email);
		
		//dispatch는 상대경로만 가능 -> dispatch를 하면 uri는 이전 페이지와 동일. 
		response.sendRedirect("/Mini/member/mypage.jsp");
	}

}
