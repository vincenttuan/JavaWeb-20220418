package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/area", "/area"})
public class AreaServlet extends HttpServlet {
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String radius = req.getParameter("radius");
		double r = Double.parseDouble(radius);
		double area = Math.pow(r, 2) * Math.PI;
		double volume = 4/3 * Math.pow(r, 3) * Math.PI;
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\""
				+ "	href=\"https://unpkg.com/purecss@2.1.0/build/pure-min.css\">"
				+ "<meta charset=\"UTF-8\">"
				+ "<title>計算圓面積與球體積</title>");
		out.println("</head>");
		out.println("<body style=\"padding: 20px\">");
		out.println("<form class=\"pure-form\"> "
				+ "		<fieldset>\r\n"
				+ "			<legend>圓面積與球體積</legend>\r\n"
				+ "			半徑: " + r + "<br />" 
				+ "			圓面積: " + String.format("%.2f", radius) + "<br />"
				+ "			球體積: " + String.format("%.2f", volume) + "<br />"
				+ "		</fieldset>"
				+ "	</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
}
