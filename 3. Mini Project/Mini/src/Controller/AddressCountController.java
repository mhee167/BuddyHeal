package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoDto.AddressDAO;
import DaoDto.AddressDTO;

@WebServlet("/frontcontroller/address/count")
public class AddressCountController extends ControllerV2 {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	
		HttpSession session=request.getSession();
	
		AddressDAO dao=new AddressDAO();
		HashMap<String,Integer> countMap=dao.getCount();
		
		
        session.setAttribute("countMap",countMap);
    	response.sendRedirect("/Mini/address/list.jsp");
		
		
	}
}