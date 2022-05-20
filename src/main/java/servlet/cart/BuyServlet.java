package servlet.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/cart/buy")
public class BuyServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// 購物車內容
		List<String> products = null;
		synchronized (session) {
			// 是否 product 的 session 變數已經存在 ? 
			if(session.getAttribute("products") == null) { // 第一次買東西
				products = new ArrayList<>();
			} else {
				products = (List<String>)session.getAttribute("products");
			}
			// 取得購買商品
			String product = req.getParameter("product");
			// 將商品放置購物車內容中
			products.add(product);
			// 將 products 回存到 session 變數中
			session.setAttribute("products", products);
		}
		// 重導到 "/servlet/cart/view"
		RequestDispatcher rd = req.getRequestDispatcher("/servlet/cart/view");
		rd.forward(req, resp);
	}
	
}
