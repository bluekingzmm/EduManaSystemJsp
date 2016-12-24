package com.edu.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletAction
 */
@WebServlet("/servletAction")
public class servletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//创建变量
		int width=112;
		int height=37;
		//创建内存图像
		BufferedImage  image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//创建画笔
		Graphics g=image.getGraphics();
		//指定边框的颜色
		g.setColor(Color.RED);
		//画图像的边框
		g.drawRect(0, 0, width, height);
		
		//填充矩形的背景色
		//设定画笔颜色
		g.setColor(Color.YELLOW);
		//填充矩形的背景
		g.fillRect(1, 1, width-2, height-2);
		
		//设置字体
		g.setFont(new Font("宋体", Font.BOLD+Font.ITALIC, 24));
		
		//填充内容
		//随机产生4个数字输出到页面
		
		Random r=new Random();
		//设定画笔的颜色
		g.setColor(Color.RED);
		
		//随机产生4个汉子
		String s="滁州职业技术学院";
		//先将汉子转换为unicode编码
		s="\u6ec1\u5dde\u804c\u4e1a\u6280\u672f\u5b66\u9662";
		for (int i = 0; i <4; i++) {
		char c=s.charAt(r.nextInt(s.length()));
		int flag=r.nextBoolean()?1:-1;
		g.drawString(c+"", 18+18*i+flag*r.nextInt(3), 24+flag*r.nextInt(5));
		}
		
		/*for (int i = 0; i <=4; i++) {
			int n=r.nextInt(10);
			g.drawString(n+"", 23*i, 22);
			
		}*/
		//将图片输出到客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
		
		
		
		
		
		
	}

}
