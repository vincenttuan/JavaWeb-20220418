package jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

@WebServlet("/insert/user/record")
public class InsertUserRecord extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "insert into user(name, age) values(?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, new Faker().name().lastName());
			pstmt.setInt(2, new Random().nextInt(30) + 10);
			int rowcount = pstmt.executeUpdate();
			resp.getWriter().print("rowcount = " + rowcount);
		} catch (Exception e) {
			resp.getWriter().print(e);
		}
	}
	
}
