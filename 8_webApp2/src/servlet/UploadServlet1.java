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


@WebServlet("/upload1.do")
@MultipartConfig(location = "c:/upload", maxFileSize = 1024*1024*5)
public class UploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/upload1.do ���Ͼ��ε�ó��");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String myfile = request.getParameter("myfile");
		
		System.out.println("myfile => "+myfile);
/*		
		if(myfile == null || myfile.equals("") || myfile.equals("null")) {
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
					p.write(filename);
					out.print("<h3> ���ε��� ���� Name : "+filename+"</h3>");
					out.print("<h3> ���� size : "+p.getSize()+"</h3>");
					out.print("<img src='c:/upload/"+filename+"'>");
				}
			}
		}	
	}
}