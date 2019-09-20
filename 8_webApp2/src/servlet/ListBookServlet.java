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

//�ַ� ���� ���� ���. UI ���� ����. �̰� JSP���� Forwarding.
//���� �� ��Ʈ�ѷ� ����� ������ Servlet. JSP�� �ִ� �ڹ��ڵ� �ȳ�~

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
			request.setAttribute("msg", "������ �̿��ϱ� ���ؼ� �α����� �ʿ��մϴ�.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
*/		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("/listBook.do ��û ó��");
		//���� log �����
		
		//DB ����
		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);

		List<BookVO> list = service.bookList();

		System.out.println("listBook "+list);
		request.setAttribute("booklist", list);
		String view = "/booklist_after.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
			
/*	
		//list data ������ table�� ������ִ� ������ �־�� ��
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
