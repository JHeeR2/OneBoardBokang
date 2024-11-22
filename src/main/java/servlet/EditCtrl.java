package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OneDAO;
import model.OneDTO;

@WebServlet("/edit.do")
public class EditCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//수정내용 보기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 받기
		String subject = req.getParameter("subject");
		//DAO 인스턴스 생성
		OneDAO oneDAO = new OneDAO();
		//기존 내용을 불러오기 위한 메서드 호출
		OneDTO oneDTO = oneDAO.loadSelect(subject);
		
		//리퀘스트 영역에 저장한 후 JSP 포워드
		req.setAttribute("oneDTO", oneDTO);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);
		

	}
	
	//수정하기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터 받기
		String prev_subj = req.getParameter("prev_subj");
		String subject = req.getParameter("subject");
		
		//DAO 인스턴스 생성
		OneDAO oneDAO = new OneDAO();
		//DTO 인스턴스 생성
		OneDTO oneDTO = new OneDTO();
		//파라미터 저장
		oneDTO.setPrev_subj(prev_subj);
		oneDTO.setSubject(subject);
		
		//수정을 위한 메서드 호출
		int result = oneDAO.editUpdate(oneDTO);
		
		if (result == 1) {
			System.out.println("수정성공");
			//성공하면 목록으로 이동
			resp.sendRedirect("list.do");
			
		} else {
			System.out.println("수정실패");
			//실패면 수정으로 이동 
			resp.sendRedirect("edit.do?subject="+subject);
		}
		
		
	}
}
