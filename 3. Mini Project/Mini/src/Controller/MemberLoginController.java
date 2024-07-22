package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.MappingMatch;

import DaoDto.MemberDAO;
import DaoDto.MemberDTO;



@WebServlet("/frontcontroller/member/login")
public class MemberLoginController extends ControllerV1  {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("user_id");
		String pw=request.getParameter("user_pw");
		
		MemberDTO dto=null;
		HttpSession session=request.getSession();
		MemberDAO dao=MemberDAO.getInstance();
		int checkNum=dao.userCheck(id,pw);
		
		if(checkNum==-1){
			out.println("<script language='javascript'>");
	                out.println("alert('아이디가 존재하지 않습니다.');");
	                out.println("history.go(-1);");
	                out.println("</script>");
	       
		}else if(checkNum==0){
			out.println("<script language='javascript'>");
	        out.println("alert('비밀번호가 틀렸습니다.');");
	        out.println("history.go(-1);");
	        out.println("</script>");
	       
		
		}else if(checkNum==1){
			dto=dao.getMember(id);
			if(dto==null){
				out.println("<script language='javascript'>");
		                out.println("alert('존재하지 않는 회원입니다.');");
		                out.println("history.go(-1);");
		                out.println("</script>");
		      
			}
	else{
		
		String name=dto.getUser_name();
		session.setAttribute("user_id",id);
		session.setAttribute("user_name",name);
		session.setAttribute("ValidMem","yes");
		response.sendRedirect("/Mini/index.jsp");
		
	}
		}
	}

	
}
