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
		
		System.out.println("/upload1.do 파일업로드처리");
		response.setContentType("text/html;charset=utf-8");
		//클라이언트에게 응답할 페이지에 대한 환경설정. 
		//즉, 결과로 출력되는 html문서의 인코딩 방식을 지정해주는 문장. 한글깨짐 눠눠.
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		//클라이언트에게 결과를 되돌려주기 위해 HttpServletResponse로부터
		//PrintWriter형의 출력 스트림 객체를 얻어와야 함.
		
		String name = request.getParameter("name");
		//String myfile = request.getParameter("myfile");
		//System.out.println("myfile => "+myfile);
		String path = request.getRealPath("/upload/");
		System.out.println(path);
		
/*		
		if(myfile == null) {
			out.print("<h3> 업로드 할 파일이 없다. </h3>");
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
					out.print("<h3> 업로드한 파일 Name : "+filename+"</h3>");
					out.print("<h3> 파일 size : "+p.getSize()+"</h3>");
					out.print("<img width=300px height=300px src='./upload/"+filename+"'>");
				}
			}
		}	
	}
}