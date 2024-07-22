package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoDto.AddressDAO;
import DaoDto.AddressDTO;

@WebServlet("/frontcontroller/address/delete")
public class AddressDeleteController extends ControllerV2 {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		AddressDAO dao = new AddressDAO();
		
		String ad_id = (String) request.getParameter("ad_id");
		
		dao.delAddress(ad_id);
		
		out.print("<script language='javascript'");
		out.print("alert(\"주소록 삭제가 완료되었습니다.\");");
		out.print("</script>");
		
		session.invalidate();
		response.sendRedirect("/Mini/address/list.jsp");
		
	}
}