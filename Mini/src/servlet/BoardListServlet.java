package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.Criteria;
import dto.pageDTO;

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Criteria cri = new Criteria();
        
        // 현재 페이지 번호와 페이지당 보여줄 게시글 수가 담긴 -> setcri
        String pageParam = request.getParameter("page");//0 1 2 
        
        if (pageParam == null || pageParam.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/BoardListServlet?page=0");
            return;
        }
        
        System.out.println(pageParam);
        if (pageParam != null) {
            cri.setPage(Integer.parseInt(pageParam));
        }
        
        // 총 게시물의 수를 세팅 
        BoardDAO dao = BoardDAO.getInstance();
        int totalCount = dao.getBoardCount();
        System.out.println(totalCount);

      
        // pageDTO를 생성해서 -> setCri해서 현재 페이지와 페이지당 10개 설정
        pageDTO pageDTO = new pageDTO();
        pageDTO.setCri(cri);
        pageDTO.setTotalCount(totalCount);
        
        
        List<BoardDTO> list = dao.selectBoardList(cri);
        
        request.setAttribute("list", list);
        request.setAttribute("pageDTO", pageDTO);

        
        // board.jsp로 포우딩
        request.getRequestDispatcher("/jsp/board.jsp").forward(request, response);
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
