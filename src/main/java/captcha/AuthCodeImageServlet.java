package captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1. 自動產出 0000~9999 之間的認證碼圖像(含干擾圖像)
// 2. 並將該碼存放到 session 屬性中以便比對
@WebServlet("/captcha/authcodeimage")
public class AuthCodeImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 產生驗證碼
		String authCode = String.format("%04d", new Random().nextInt(10000));
		System.out.println("authCode = " + authCode);
		
		// 將驗證碼保留在 session 中以便日後驗證
		req.getSession().setAttribute("authCode", authCode);
		
		// 產生驗證碼圖片
		try {
			ImageIO.write(getAuthCodeImage(authCode), "JPEG", resp.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 產生驗證碼圖片
	private BufferedImage getAuthCodeImage(String authCode) {
		// 建立圖像暫存區
		BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		// 建立畫布
		Graphics g = img.getGraphics();
		// 設定顏色
		g.setColor(Color.YELLOW);
		// 塗滿背景
		g.fillRect(0, 0, 80, 30);
		// 設定顏色
		g.setColor(Color.BLACK);
		// 設定字型(字體, 字樣, 尺寸)
		g.setFont(new Font("新細明體", Font.PLAIN, 30));
		// 繪文字
		g.drawString(authCode, 10, 23);
		// 放入干擾線
		Random random = new Random();
		g.setColor(Color.RED);
		for(int i=0;i<10;i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(80);
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2);
		}
		
		return img;
	}
	
	
}
