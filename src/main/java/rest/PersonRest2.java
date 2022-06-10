package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest2/*")
public class PersonRest2 extends HttpServlet {
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("HTTP method: " + req.getMethod());
		out.println("Path info: " + req.getPathInfo());
		//------------------------------------------------------------------------
		// 自行抓取串流並分解 args
		ServletInputStream sis = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(sis);
		BufferedReader br = new BufferedReader(isr);
		String args = br.readLine();
		out.println(args);
		String[] data = args.split("&");
		for(String rows : data) {
			String[] row = rows.split("=");
			//          name           value
			out.println(row[0] + "=" + row[1]);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	
}
