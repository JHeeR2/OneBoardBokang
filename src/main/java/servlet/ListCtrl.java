package servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OneDAO;
import model.OneDTO;

@WebServlet("/list.do")
public class ListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DAO 인스턴스 생성
		OneDAO oneDAO = new OneDAO();
		//목록 출력을 위한 메서드 호출
		ArrayList<OneDTO> oneList = oneDAO.listSelect();
		
		//리퀘스트 영역에 반환받은 List를 저장
		req.setAttribute("oneList", oneList);
		
		//뷰로 포워드
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
