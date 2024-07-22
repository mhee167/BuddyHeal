package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoDto.AddressDAO;
import DaoDto.AddressDTO;

@WebServlet("/frontcontroller/address/search")
public class AddressSearchController extends ControllerV2 {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String find_name = request.getParameter("find_name");

        AddressDAO dao = new AddressDAO();
        List<AddressDTO> searchResults = dao.searchAddress(find_name);

     // (키, 값)
        request.setAttribute("addressList", searchResults);
        request.getRequestDispatcher("/Mini/address/list_search.jsp").forward(request, response);
    }
}
