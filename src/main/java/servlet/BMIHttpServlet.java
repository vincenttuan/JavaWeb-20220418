package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIHttpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("call by get");
		// 第一種方式
		// 案例1: h=170&w=60 得到 170 與 60
		// 案例2: h=170,171,172&w=60,61,62 得到 170 與 60
		/*
		String height = req.getParameter("h"); // 抓到請求參數 h
		String weight = req.getParameter("w"); // 抓到請求參數 w
		out.println("<p>");
		out.println("height = " + height);
		out.println("<p>");
		out.println("weight = " + weight);
		*/
		// 第二種方式 (支援陣列)
		// 案例1: h=170&w=60 得到 170 與 60
		// 案例2: h=170,171,172&w=60,61,62 得到 [170,171,172] 與 [60,61,62]
		/*
		Map<String, String[]> map = req.getParameterMap();
		String[] heights = map.get("h");
		String[] weights = map.get("w");
		out.println("<p>");
		out.println("heights = " + Arrays.toString(heights));
		out.println("<p>");
		out.println("weights = " + Arrays.toString(weights));
		*/
		// 第三種方式 (支援陣列)
		String[] heights = req.getParameterValues("h");
		String[] weights = req.getParameterValues("w");
		out.println("<p>");
		out.println("heights = " + Arrays.toString(heights));
		out.println("<p>");
		out.println("weights = " + Arrays.toString(weights));
		out.println("<p>");
		// 得到所有參數名
		Enumeration<String> names = req.getParameterNames();
		out.println("得到參數名稱:");
		while(names.hasMoreElements()) {
			out.println(names.nextElement() + " ");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("call by post");
	}
	
}
