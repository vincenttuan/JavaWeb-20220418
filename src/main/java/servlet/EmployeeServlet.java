package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;

/* 
 * 取得 employee_form.html 所傳來的資料
 * 呈現方式如下:
 * 姓名: John  
 * 年齡: 25
 * 性別: M
 * 階級: B
 * 生日: 1990/05/20
 * 語言: Java Python
 * 備註: ...
*/
@WebServlet("/servlet/employee")
public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		// case 1
		String empName = req.getParameter("empName");
		String empAge = req.getParameter("empAge");
		String empSex = req.getParameter("empSex");
		String empPos = req.getParameter("empPos");
		String empBirth = req.getParameter("empBirth");
		String[] empLang = req.getParameterValues("empLang");
		String empMemo = req.getParameter("empMemo");
		out.print("empName = " + empName + "<br />");
		out.print("empAge = " + empAge + "<br />");
		out.print("empSex = " + empSex + "<br />");
		out.print("empPos = " + empPos + "<br />");
		out.print("empBirth = " + empBirth + "<br />");
		out.print("empLang = " + Arrays.toString(empLang) + "<br />");
		out.print("empMemo = " + empMemo + "<br />");
		
		out.println("<hr />");
		
		// case 2
		req.getParameterMap()
				.entrySet()
				.forEach(e -> out.print(e.getKey() + " = " + Arrays.toString(e.getValue()) + "<br />"));
		//out.print(req.getParameterNames());
		
		// 將 form-data 注入 Employee 物件中
		Employee employee = new Employee(empName, Integer.parseInt(empAge), empSex, empPos, empBirth, empLang, empMemo);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("請不要直接執行我...");
	}
	
}