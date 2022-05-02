package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/today")
public class TodayHeaderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// 只有透過 Chrome 瀏覽器連入的才看得到今天日期
		// 分析下面的 header 資訊
		// sec-ch-ua:" Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"
		String headerValue = req.getHeader("sec-ch-ua");
		out.println("您所使用的瀏覽器是: " + headerValue + "<p />");
		out.println("您所使用的瀏覽器是: " + headerValue.split(",")[2].split(";")[0].replace('\"', '\u0000') + "<p />");
		if(headerValue.contains("Google Chrome")) {
			out.println("現在時刻: " + new Date());
		} else {
			out.println("請使用 Chrome 瀏覽器");
		}
		
	}
	
}
