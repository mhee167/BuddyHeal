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

@WebServlet("/frontcontroller/address/list")
public class AddressListController extends ControllerV2 {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 배열로 가져와서, jsp에서 for문으로 받기
		AddressDAO dao = new AddressDAO();
		List<AddressDTO> addressList = dao.listAddress();
		
		// (키, 값)
		request.setAttribute("addressList", addressList);
		
		// jsp로 제어 넘기기
		request.getRequestDispatcher("/Mini/address/list.jsp").forward(request, response);
	}
}
