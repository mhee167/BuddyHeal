package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoDto.AddressDAO;
import DaoDto.AddressDTO;

@WebServlet("/frontcontroller/address/write")
public class AddressWriteController extends ControllerV2 {
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		AddressDAO dao = new AddressDAO();

		String ad_id = request.getParameter("ad_id");
		String ad_name = request.getParameter("ad_name");
		String ad_department = request.getParameter("ad_department");
		String ad_rank = request.getParameter("ad_rank");
		String ad_phone = request.getParameter("ad_phone");
		String ad_email = request.getParameter("ad_email");
		
		// DAO를 통해 DTO 저장
		AddressDTO dto = new AddressDTO();
		
		dto.setAd_id(ad_id);
		dto.setAd_name(ad_name);
		dto.setAd_department(ad_department);
		dto.setAd_rank(ad_rank);
		dto.setAd_phone(ad_phone);
		dto.setAd_email(ad_email);

		// DAO 수정 기능 메소드 실행
		Integer daoResult = dao.addAddress(dto);
		
		if(daoResult == 1) {
			out.println("alert('주소록 등록이 완료되었습니다.');");
	        response.sendRedirect("/Mini/address/list.jsp");
		} else if(daoResult == 0) {
			out.println("<script language=\"javascript\">");
			out.println("alert('이미 주소가 등록된 아이디입니다.');");
			out.println("history.back(-1);");
			out.println("</script>");
		} else if (daoResult == -1) {
			out.println("<script language=\"javascript\">");
			out.println("alert('회원 가입된 아이디를 입력하셔야만 등록할 수 있습니다.');");
			out.println("history.back(-1);");
			out.println("</script>");
		} else {
			out.println("<script language=\"javascript\">");
			out.println("alert('주소록 등록에 실패하셨습니다.');");
			out.println("history.back(-1);");
			out.println("</script>");
		}
		
        
	}
}
