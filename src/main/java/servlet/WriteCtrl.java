package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OneDAO;
import model.OneDTO;

//서블릿 요청명 매핑
@WebServlet("/write.do")
public class WriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//쓰기페이지 진입
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./write.jsp").forward(req, resp);
	}
	
	//쓰기 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 폼값 받기
		String subject = req.getParameter("subject");
		
		//2. DTO에 저장하기
		OneDTO oneDTO = new OneDTO();
		oneDTO.setSubject(subject);
		
		//3. DAO로 전달하여 입력(insert)처리
		OneDAO oneDAO = new OneDAO(); 
		int result = oneDAO.writeInsert(oneDTO);
		if(result==1) {
			System.out.println("입력성공^^");
			resp.sendRedirect("list.do");
		}else {
			System.out.println("입력실패ㅠㅠ");
			resp.sendRedirect("write.do");
		}
		
	}

}
