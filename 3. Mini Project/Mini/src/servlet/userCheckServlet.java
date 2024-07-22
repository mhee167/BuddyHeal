package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/userCheckMember")
public class userCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        
        MemberDAO dao = new MemberDAO();        
        String id = request.getParameter("id");
        String pwd =request.getParameter("pwd");
        
        
        
        
        System.out.println(id+" "+pwd);
        int num=0;;
		try {
			num = dao.userCheck(id, pwd);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(num);
        
    	

		// session 생성해서 작성자 데이터 넘기기
		HttpSession session=request.getSession();
		session.setAttribute("author", id);
		
	
		//login.jsp로 포워딩
		 RequestDispatcher dispatcher =request.getRequestDispatcher("/main.jsp"); 
		 dispatcher.forward(request,response);

    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
