package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// WebServlet 配置資訊
@WebServlet("/servlet/TimeStampServlet")
public class TimeStampServlet extends GenericServlet { // 繼承一個通用型 Servlet

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		String todayString = sdf.format(today);
		System.out.println(todayString);
		// Server 端編碼 UTF-8
		res.setCharacterEncoding("UTF-8");
		// Server 端回應給瀏覽器的文件格式與編碼
		res.setContentType("text/html;charset=utf-8");
		//res.setContentType("application/octet-stream");
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		//out.println("<meta charset='utf-8'>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H1 style='color: red'>");
		out.println(todayString);
		out.println("</H1>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
}
