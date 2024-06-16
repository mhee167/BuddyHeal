package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoDto.AddressDAO;
import DaoDto.AddressDTO;

@WebServlet("/frontcontroller/address/filter")
public class AddressFilterController extends ControllerV2 {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String ad_department = request.getParameter("ad_department");

        AddressDAO dao = new AddressDAO();
        List<AddressDTO> filterResults = dao.filterAddress(ad_department);

     // (키, 값)
        request.setAttribute("filterList", filterResults);
        request.getRequestDispatcher("/Mini/address/list.jsp").forward(request, response);
    }
}
