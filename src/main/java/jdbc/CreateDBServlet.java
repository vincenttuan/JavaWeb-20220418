package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc/create/db")
public class CreateDBServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 資料庫放置位置
		String db_path = "C:/Users/student/eclipse-workspace-web/JavaWeb-20220418/db";
		// 資料庫名稱
		String db_name = "webdb.db";
		// 建立資料庫連線參數
		String db_url = "jdbc:sqlite:" + db_path + "/" + db_name;
		// 資料庫連線物件
		Connection conn = null;
		try {
			// 建立資料庫 driver
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(db_url);
			resp.getWriter().print("Connection to SQLite has benn established!");
			
		} catch (Exception e) {
			resp.getWriter().print(e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					resp.getWriter().print(e.getMessage());
				}
			}
		}
	}
	
}
