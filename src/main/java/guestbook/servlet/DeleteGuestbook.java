package guestbook.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.entity.Guestbook;
import guestbook.service.JPAService;

@WebServlet("/guestbook/delete")
public class DeleteGuestbook extends HttpServlet {
private JPAService service = new JPAService();
	
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 擷取網頁表單內容
		Integer id = Integer.parseInt(req.getParameter("id"));
		// 根據 id 將 guestbook 資料刪除
		service.deleteGuestbookById(id);
		// 重導頁面
		RequestDispatcher rd = req.getRequestDispatcher("/guestbook/view");
		rd.forward(req, resp);
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
