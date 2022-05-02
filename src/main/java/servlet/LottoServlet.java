package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LottoService;

@WebServlet("/servlet/lotto")
public class LottoServlet extends HttpServlet {
	
	private LottoService lottoService;
	
	@Override
	public void init() throws ServletException {
		lottoService = new LottoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收參數
		int count = Integer.parseInt(req.getParameter("count"));
		// 產生 lotto 數字
		List<Integer> lottos = lottoService.getLottos(count);
		// 透過重導到 html/lotto_result.jsp 頁面並將 lottos 物件傳進
		req.setAttribute("lottos", lottos);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/lotto_result.jsp");
		rd.forward(req, resp);
	}
	
}
