package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;   

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf('/'));
		System.out.println(action);
		out.print("<h3>"+action+"</h3>");
		
		if(action.equals("/login.do")){
			
			System.out.println("/login.do 요청 처리");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			System.out.println("/login.do");
			System.out.println(id+"/"+pw);
			
			if(id==null||pw==null||id.length()==0||pw.length()==0) {
				//response.sendRedirect("./login.jsp");
				request.setAttribute("msg", "비밀번호를 다시 입력하세요.");
				request.setAttribute("id", id);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			
			if(id.equals("jakeshin") && pw.equals("bit")) {
				HttpSession session = request.getSession();
				session.setAttribute("login", id+"/shin");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			} else {
				request.setAttribute("msg", "로그인 실패");
				request.setAttribute("id", id);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
}
