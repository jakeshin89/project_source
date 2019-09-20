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
/*		
		HttpSession session = request.getSession();
		String login = (String)session.getAttribute("login");
		
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
		//결국 service를 부르는 건, service에 있는 메소드를 부르는 것.
		//이 메소드는 이 메소드 내 저장된 sql을 부르는 것.
		//sql문을 부르는 건 database에 저장된 sql문을 부르는 것.
		//getBookRec() 여기에서 sql문에서 나온 data를 다 뿌려줘서 뽑고싶은 column선택해서 list형태로 저장
		//크 이렇게 하면 저장됨

		System.out.println("listBook "+list);
		request.setAttribute("booklist", list); //위 변수list를 booklist라는 이름으로 저장
		String view = "/booklist_after.jsp";	//보낼 페이지 입력
		//이제는 받아서 뿌려주자
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
		//이건 찾아보자. 무튼 보내는거
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
