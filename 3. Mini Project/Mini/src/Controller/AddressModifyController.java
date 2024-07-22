package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoDto.AddressDAO;
import DaoDto.AddressDTO;

@WebServlet("/frontcontroller/address/modify")
public class AddressModifyController extends ControllerV2 {
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		AddressDAO dao = new AddressDAO();
		AddressDTO dto = new AddressDTO();
		
		String ad_id = request.getParameter("ad_id");
		String ad_name = request.getParameter("ad_name");
		String ad_department = request.getParameter("ad_department");
		String ad_rank = request.getParameter("ad_rank");
		String ad_phone = request.getParameter("ad_phone");
		String ad_email = request.getParameter("ad_email");
		
		dto.setAd_id(ad_id);
		dto.setAd_name(ad_name);
		dto.setAd_department(ad_department);
		dto.setAd_rank(ad_rank);
		dto.setAd_phone(ad_phone);
		dto.setAd_email(ad_email);
		
		dao.updateAddress(ad_id, dto);
		
		out.println("<script language=\"javascript\">");
		out.println("alert('주소록 수정이 완료되었습니다.');");
		out.println("</script>");
        response.sendRedirect("/Mini/address/list.jsp");
		
	}
}
