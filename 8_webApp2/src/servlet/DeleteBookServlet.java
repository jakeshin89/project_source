package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;


//@WebServlet("/deleteBook.do")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); //한글 안깨짐
		
		//String bookid = request.getParameter("bookid");
		String[] bookid = request.getParameterValues("bookid");
		String img = request.getParameter("img"); //param name img가 어떻게 들어올까?
		System.out.println(img);
		String fname = img.substring(img.lastIndexOf('/')+1); //substring(숫자:index숫자부터시작) 그래야 온전한 파일명이 나옴
		String path = request.getRealPath("/upload/");
		
		File f = new java.io.File(path+fname);
		if(f.exists()) {
			f.delete();
		}
		
		System.out.println("deleteBook.do => "+Arrays.toString(bookid));
		
		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);
		
		try {
			
			for(String data: bookid) {
				service.deleteBook(Integer.parseInt(data));
			}			
			response.sendRedirect("listBook.do");
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}
}