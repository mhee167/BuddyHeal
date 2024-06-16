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


@WebServlet("/frontcontroller/member/join")
public class MemberJoinController extends ControllerV1 {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		MemberDAO dao=MemberDAO.getInstance();
		MemberDTO dto=new MemberDTO();
		
		
		if(dao.confirmId(dto.getUser_id())==MemberDAO.MEMBER_EXISTENCE){
			out.println("<script language=\"javascript\">");
			out.println("alert('아이디가 이미 존재합니다.');");
			out.println("history.back(-1);");
			out.println("</script>");
		}else{
			
			String user_name=request.getParameter("user_name");
			String user_id=request.getParameter("user_id");
			String user_pw=request.getParameter("user_pw");
			String user_pw_re=request.getParameter("user_pw_re");
			String user_phone=request.getParameter("user_phone");
			String user_email=request.getParameter("user_email");
			
			dto.setUser_name(user_name);
			dto.setUser_id(user_id);
			dto.setUser_pw(user_pw);
			dto.setUser_pw_re(user_pw_re);
			dto.setUser_phone(user_phone);
			dto.setUser_email(user_email);
			
			int ri=dao.addMember(dto);
			
			if(ri==MemberDAO.MEMBER_JOIN_SUCCESS){
				session.setAttribute("user_id",user_id);
				response.sendRedirect("/Mini/member/joinSuccess.jsp");
			}else {
				out.println("<script language=\"javascript\">");
				out.println("alert('회원가입에 실패했습니다.');");
				out.println("document.location.href=\"/member/join.jsp\"");
				out.println("</script>");
			}
		}
	}

}
