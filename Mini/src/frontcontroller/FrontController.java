package frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.ControllerV1;
import Controller.ControllerV2;
import Controller.MemberJoinController;
import Controller.MemberJoinOutController;
import Controller.MemberLoadController;
import Controller.MemberLogOutController;
import Controller.MemberLoginController;
import Controller.MemberModifyController;
import Controller.AddressCountController;
import Controller.AddressDeleteController;
import Controller.AddressFilterController;
import Controller.AddressListController;
import Controller.AddressModifyController;
import Controller.AddressSearchController;
import Controller.AddressWriteController;
import DaoDto.MemberDAO;
import DaoDto.MemberDTO;	

@WebServlet("/frontcontroller/*")
public class FrontController extends HttpServlet {
	private Map<String,ControllerV1> controllerMapMbr = new HashMap<>();
	private Map<String,ControllerV2> controllerMapAddr = new HashMap<>();
	
	public FrontController() {
		// 회원 관리
		controllerMapMbr.put("/frontcontroller/member/login", new MemberLoginController());
		controllerMapMbr.put("/frontcontroller/member/logout", new MemberLogOutController());
		controllerMapMbr.put("/frontcontroller/member/join", new MemberJoinController());
		controllerMapMbr.put("/frontcontroller/member/joinOut", new MemberJoinOutController());
		controllerMapMbr.put("/frontcontroller/member/modify", new MemberModifyController());
		controllerMapMbr.put("/frontcontroller/member/load", new MemberLoadController());
		// 주소록 관리
        controllerMapAddr.put("/frontcontroller/address/list", new AddressListController());
        controllerMapAddr.put("/frontcontroller/address/modify", new AddressModifyController());
        controllerMapAddr.put("/frontcontroller/address/write", new AddressWriteController());
        controllerMapAddr.put("/frontcontroller/address/delete", new AddressDeleteController());
        controllerMapAddr.put("/frontcontroller/address/search", new AddressSearchController());
        controllerMapAddr.put("/frontcontroller/address/filter", new AddressFilterController());
        controllerMapAddr.put("/frontcontroller/address/count", new AddressCountController());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String requestURI = request.getRequestURI();
	    System.out.println("Request URI: " + requestURI);

	    // 회원 관리
	    ControllerV1 controllerM = controllerMapMbr.get(requestURI);
	    if (controllerM != null) {
	        controllerM.service(request, response);
	        return;
	    }

	    // 주소록 관리
	    ControllerV2 controllerA = controllerMapAddr.get(requestURI);
	    if (controllerA != null) {
	        controllerA.service(request, response);
	        return;
	    }

	    // 요청이 맵에 없는 경우 404 오류 반환
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
}
