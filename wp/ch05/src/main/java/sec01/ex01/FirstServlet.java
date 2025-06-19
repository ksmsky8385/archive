package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description="처음 만드는 서블릿",urlPatterns = {"/First"})


public class FirstServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>FirstServlet</TITLE></HEAD>");
		out.println("<BODY><H2>~~~~~~~</H2></BODY>");
		out.println("<BODY><H2>ㅗ^ㅗ^ㅗ</H2></BODY>");
		out.println("<BODY><H2>~~~~~~~</H2></BODY>");
		out.println("</HTML>");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	
}
