package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// WebServlet 配置資訊
@WebServlet("/servlet/lucky/number")
public class LuckyNumberServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		
		int number = new Random().nextInt(100) + 1;
		
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<H1 style='color: blue'>");
		out.println(String.format("幸運數字: %d", number));
		out.println("</H1>");
		out.println("</HTML>");
	}

}
