package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;

@WebServlet("/InsertBook.do")
@MultipartConfig(maxFileSize = 1024*1024*5) //파일 업로드시 꼭 필요

public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listBook.do 요청 처리");

		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);
		
		BookVO vo = new BookVO();
		vo.setBookname(request.getParameter("bookname"));
		vo.setPublisher(request.getParameter("publisher"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		
		String path = request.getRealPath("/upload/");
		
		Collection<Part> parts = request.getParts();
		for(Part p: parts) {
			if(p.getContentType() != null) {
				String filename = p.getSubmittedFileName();
				if(filename != null && filename.length() != 0) {
					p.write(path+filename);
					vo.setImg("./upload/"+filename); //upload 자원 뿌리려면 상대주고 필요함
					System.out.println("./upload/"+filename);
					System.out.println(vo);	
				}
			}
		}
		
		try {
			service.addBook(vo);	
			response.sendRedirect("listBook.do");
		} catch (Exception e) {
			request.setAttribute("exception", e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
