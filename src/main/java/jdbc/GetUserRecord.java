package jdbc;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

// 單筆查詢
@WebServlet("/get/user/record")
public class GetUserRecord extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sql = "select id, name, age, createtime from user where id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				
			} else {
				resp.getWriter().print("No record !");
			}
		} catch (Exception e) {
			resp.getWriter().print(e);
		}
	}
	
}
