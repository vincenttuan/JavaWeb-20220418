package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/report/*"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 1. 判斷是否此人已登入
		HttpSession session = req.getSession();
		Object data = session.getAttribute("pass");
		// 2.判斷此人是否是尚未登入或登入已過時
		if(data == null || Boolean.parseBoolean(data+"") != true) { 
			// 2.1 有把 username, password 與 usercode 傳遞過來
			String username = req.getParameter("username") + "";
			String password = req.getParameter("password") + "";
			String userCode = req.getParameter("usercode") + "";
			String authCode = session.getAttribute("authCode") + "";
			if(username.equals("admin") && password.equals("1234") && userCode.equals(authCode)) {
				// 寫入驗證通過 session 資料
				session.setAttribute("pass", true);
				chain.doFilter(req, res);
			} else {
				// 2.2 重導到登入頁面
				RequestDispatcher rd = req.getRequestDispatcher("/login");
				rd.forward(req, res);
			}
			
		} else {
			// 3.通過驗證
			chain.doFilter(req, res);
		}
		
	}
	
}
