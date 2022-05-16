package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/servlet/*")
public class PerformanceFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("請求: " + req.getRequestURI());
		long begin = System.currentTimeMillis();
		chain.doFilter(req, res);
		long end = System.currentTimeMillis();
		System.out.println("請求: " + req.getRequestURI() + ", 花費時間:" + (end - begin) + " ms");
	}
	
}
