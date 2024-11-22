package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OneDAO;

@WebServlet("/delete.do")
public class DeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 받기
		String subject = req.getParameter("subject");
		
		//DAO 인스턴스 생성
		OneDAO oneDAO = new OneDAO();
		//삭제를 위한 메서드 호출
		int result = oneDAO.deletePost(subject);
		// 성공? 실패? 판단
		if (result ==1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		
		//목록으로 이동
		resp.sendRedirect("list.do");
		
	}


}
