package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/upload2.do")
@MultipartConfig(maxFileSize = 1024*1024*5)
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/upload1.do ���Ͼ��ε�ó��");
		response.setContentType("text/html;charset=utf-8");
		//Ŭ���̾�Ʈ���� ������ �������� ���� ȯ�漳��. 
		//��, ����� ��µǴ� html������ ���ڵ� ����� �������ִ� ����. �ѱ۱��� ����.
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		//Ŭ���̾�Ʈ���� ����� �ǵ����ֱ� ���� HttpServletResponse�κ���
		//PrintWriter���� ��� ��Ʈ�� ��ü�� ���;� ��.
		
		String name = request.getParameter("name");
		//String myfile = request.getParameter("myfile");
		//System.out.println("myfile => "+myfile);
		String path = request.getRealPath("/upload/");
		System.out.println(path);
		
/*		
		if(myfile == null) {
			out.print("<h3> ���ε� �� ������ ����. </h3>");
			return;
		}
*/
		Collection<Part> parts = request.getParts();
		
		for(Part p: parts) {
			//System.out.println("p => "+p);
			if(p.getContentType() != null) {
				String filename = p.getSubmittedFileName();
				if(filename != null) {
					p.write(path+filename);
					out.print("<h3> ���ε��� ���� Name : "+filename+"</h3>");
					out.print("<h3> ���� size : "+p.getSize()+"</h3>");
					out.print("<img width=300px height=300px src='./upload/"+filename+"'>");
				}
			}
		}	
	}
}