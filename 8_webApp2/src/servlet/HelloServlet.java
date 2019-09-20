package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�̸� �پ��ϰ� ���� �� ����. �� �̸����� ���� ����.
//@WebServlet({ "/HelloServlet", "/hello", "/hello.do" })

//urlPatterns : url ������ �� �� ���ݾƿ�
//@WebServlet(urlPatterns = {"/HelloServlet", "/hello", "/hello.do"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
    	System.out.println("HelloServlet() ��ü ����");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() ȣ��");
	}

	
	public void destroy() {
		System.out.println("destroy() ȣ��");
	}
/*
	//get ������� 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //��� �� �־�� ��(���� ����� ��), ȯ�漳���̱� ������ ù°�ٿ� �ִ°� �̻���
		System.out.println("doGet() ȣ��");
				
		response.getWriter().append("Served at: ").append(request.getContextPath()); //getContextPath()�� 7_webApp �̰�
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet Page �Դϴ�. </h1>"); //out.print => ������ ������ client ���������� ����
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");		
	}
	//�ٲ����� ��û�� ������ �ʾұ� ������ �޸𸮿� �� ������
	//get��� ?name=ȫ�浿&id=java01
*/	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8"); //��� �� �־�� ��(���� ����� ��)
		request.setCharacterEncoding("utf-8");
		
		System.out.println("doPost() ȣ��");

		response.getWriter().append("<h3>Served at: ").append(request.getContextPath()).append("</h3>");
		//�����Ұ�.�Ἥ(��Ʈ���ε� ���� ��Ʈ������ ������ �ϴ� read/write. ���� ���� �����ϰ�.�����ϰ�.�����ϰ�...
		//System.out.println(request);
		//System.out.println(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.print("<h1> HelloServlet Page �Դϴ�. </h1>");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		out.print("<h1>"+name+"||"+id+"</h1>");		
	}
}

//�̰� �޸� �ö󰡰� �ؾ��ϴ� ù client���� ������ �� ����.
//�̸� �޸𸮿� ����

//post �� �ѱ� ������
//�ٵ� get������� �߸��ߴٰ� reload�� �Ǿ ������ 2��... �� �� ��....
//ui�� jsp����, �׷��� �� ������ jsp��..

//doGet�̵� doPost ������ �ʰ� ȣ���ϴ°� service
