package top.inick.servlet2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class ServletDemo03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletDemo03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告诉客户端不使用缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		ValidateCode vdc = new ValidateCode(110, 25, 4, 9);
		vdc.write(response.getOutputStream());
		
		//test1(response);
	}

	private void test1(HttpServletResponse response) throws IOException {
		int width = 110;
		int height = 25;
		
		//在内存中创建一个图像对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		//创建一个画笔
		Graphics g = img.getGraphics();
		//给图片添加背景颜色
		g.setColor(Color.PINK);
		g.fillRect(1, 1, width - 2, height - 2);
		//给边框添加颜色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width - 1, height - 1);
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		//给图片添加文本
		Random rand = new Random();
		int position = 20;
		for(int i = 1; i < 5; i++) {
			g.drawString(rand.nextInt(10) + "", position * i, 18);			
		}
		//添加干扰线
		for(int i = 1; i < 10; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		
		//将图片对象以流的形式传输给客户端
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
