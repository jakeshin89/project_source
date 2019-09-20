package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이름 다양하게 붙일 수 있음. 이 이름으로 연결 가능.
//@WebServlet({ "/HelloServlet", "/hello", "/hello.do" })

//urlPatterns : url 여러개 줄 수 있잖아요
//@WebServlet(urlPatterns = {"/HelloServlet", "/hello", "/hello.do"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
    	System.out.println("HelloServlet() 객체 생성");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	}

	
	public void destroy() {
		System.out.println("destroy() 호출");
	}
/*
	//get 방식으로 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //얘는 꼭 있어야 함(설정 해줘야 함), 환경설정이기 때문에 첫째줄에 있는게 이상적
		System.out.println("doGet() 호출");
				
		response.getWriter().append("Served at: ").append(request.getContextPath()); //getContextPath()은 7_webApp 이거
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet Page 입니다. </h1>"); //out.print => 나에게 접속한 client 웹브라우저에 찍힘
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");		
	}
	//바꿨지만 요청이 들어오지 않았기 때문에 메모리에 안 떠있음
	//get방식 ?name=홍길동&id=java01
*/	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8"); //얘는 꼭 있어야 함(설정 해줘야 함)
		request.setCharacterEncoding("utf-8");
		
		System.out.println("doPost() 호출");

		response.getWriter().append("<h3>Served at: ").append(request.getContextPath()).append("</h3>");
		//응답할게.써서(스트림인데 문자 스트림으로 보내야 하니 read/write. 문자 내용 덧붙일게.덧붙일게.덧붙일게...
		//System.out.println(request);
		//System.out.println(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet Page 입니다. </h1>");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");		
	}
}

//이게 메모리 올라가고 해아하니 첫 client에겐 느리게 뜰 수도.
//미리 메모리에 띄우기

//post 얘 한글 깨지네
//근데 get방식으로 잘못했다간 reload가 되어서 결제가 2번... 날 수 도....
//ui는 jsp에서, 그래서 이 서블릿은 jsp로..

//doGet이든 doPost 가리지 않고 호출하는게 service
