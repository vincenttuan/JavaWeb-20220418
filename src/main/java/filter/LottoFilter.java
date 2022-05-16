package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/servlet/lotto"}) // 定義要管理的 URL
public class LottoFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 驗證參數 count
		String count = request.getParameter("count");
		if(count == null || count.length() == 0) {
			PrintWriter out = response.getWriter();
			out.print("Lotto 無法服務. 因為資料輸入不完整");
		} else {
			// 通過並往下繼續執行
			chain.doFilter(request, response);
		}
	}
}
