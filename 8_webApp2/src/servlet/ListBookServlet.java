package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

//주로 서비스 역할 담당. UI 역할 눠눠. 이건 JSP에게 Forwarding.
//연결 및 컨트롤러 담당은 오로지 Servlet. JSP에 있는 자바코드 안녕~

@WebServlet("/listBook.do")
public class ListBookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;   
   
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
/*		
		if(login == null) {
			request.setAttribute("msg", "정보를 이용하기 위해서 로그인이 필요합니다.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
*/		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("/listBook.do 요청 처리");
		//나름 log 남기기
		
		//DB 연동
		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);

		List<BookVO> list = service.bookList();

		System.out.println("listBook "+list);
		request.setAttribute("booklist", list);
		String view = "/booklist_after.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
			
/*	
		//list data 꺼내서 table로 출력해주는 문장이 있어야 함
		PrintWriter out = response.getWriter();
		for(BookVO d: list) {
			out.print("<h3>"+d.getBookid()+"</h3>");
			out.print("<h3>"+d.getBookname()+"</h3>");
			out.print("<h3>"+d.getPublisher()+"</h3>");
			out.print("<h3>"+d.getPrice()+"</h3>");
		}
*/
	}
}
