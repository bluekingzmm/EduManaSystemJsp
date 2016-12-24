package com.edu.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.dao.IStudent;
import com.edu.dao.impl.StudentImpl;
import com.edu.dto.Student;

/**
 * Servlet implementation class StudentAction
 */
@WebServlet("/StudentAction")
public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudent student = new StudentImpl();
	public static final int PAGESIZE = 5;// 定义变量

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String operate = request.getParameter("operate");

		if (operate.equals("stuLogin")) {
			stuLogin(request, response);
		} else if (operate.equals("listone")) {
			listone(request, response);
		} else if (operate.equals("addStu")) {
			addStu(request, response);
		} else if (operate.equals("loginOut")) {
			loginOut(request, response);
		} else if (operate.equals("changePsw")) {
			changePsw(request, response);
		} else if (operate.equals("deleteStu")) {
			deleteStu(request, response);
		} else if (operate.equals("updateStu")) {
			updateStu(request, response);
		} else if (operate.equals("modifyStu")) {
			modifyStu(request, response);
		} else if (operate.equals("selectCourse")) {
			selectCourse(response, response);
		} else if (operate.equals("writeAssess")) {
			writeAssess(request, response);
		} else if (operate.equals("searchScore")) {
			searchScore(request, response);
		} else if (operate.equals("searchStu")) {
			searchStu(request, response);
		} else if (operate.equals("listStu")) {
			listStu(request, response);
		} else if (operate.equals("recycleBin")) {
			recycleBin(request, response);
		} else if (operate.equals("clearRecycleBin")) {
			clearRecycleBin(request, response);
		} else if (operate.equals("move")) {
			move(request, response);
		} else if (operate.equals("recover")) {
			recover(request, response);
		} else if (operate.equals("yzm")) {
			yzm(request, response);
		}
	}

	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r, g, b;
		r = s + random.nextInt(e - s); // 随机生成RGB颜色中的r值
		g = s + random.nextInt(e - s); // 随机生成RGB颜色中的g值
		b = s + random.nextInt(e - s); // 随机生成RGB颜色中的b值
		return new Color(r, g, b);
	}

	public void yzm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应图片,一定不能缺少这句话,否则错误.
		response.setContentType("image/jpeg");
		int width = 112, height = 37; // 指定生成验证码的宽度和高度
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 创建BufferedImage对象,其作用相当于一图片
		Graphics g = image.getGraphics(); // 创建Graphics对象,其作用相当于画笔
		Graphics2D g2d = (Graphics2D) g; // 创建Grapchics2D对象
		Random random = new Random();
		Font mfont = new Font("楷体", Font.BOLD, 24); // 定义字体样式
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height); // 绘制背景
		g.setFont(mfont); // 设置字体
		g.setColor(getRandColor(180, 200));

		// 绘制100条颜色和位置全部为随机产生的线条,该线条为2f
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); // 定制线条样式
			Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
			g2d.setStroke(bs);
			g2d.draw(line); // 绘制直线
		}
		// 输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。
		String sRand = "";
		String ctmp = "";
		int itmp = 0;
		// 制定输出的验证码为四位
		for (int i = 0; i < 4; i++) {
			switch (random.nextInt(3)) {
			case 1: // 生成A-Z的字母
				itmp = random.nextInt(26) + 65;
				ctmp = String.valueOf((char) itmp);
				break;
			case 2: // 生成汉字
				String[] rBase = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
				// 生成第一位区码
				int r1 = random.nextInt(3) + 11;
				String str_r1 = rBase[r1];
				// 生成第二位区码
				int r2;
				if (r1 == 13) {
					r2 = random.nextInt(7);
				} else {
					r2 = random.nextInt(16);
				}
				String str_r2 = rBase[r2];
				// 生成第一位位码
				int r3 = random.nextInt(6) + 10;
				String str_r3 = rBase[r3];
				// 生成第二位位码
				int r4;
				if (r3 == 10) {
					r4 = random.nextInt(15) + 1;
				} else if (r3 == 15) {
					r4 = random.nextInt(15);
				} else {
					r4 = random.nextInt(16);
				}
				String str_r4 = rBase[r4];
				// 将生成的机内码转换为汉字
				byte[] bytes = new byte[2];
				// 将生成的区码保存到字节数组的第一个元素中
				String str_12 = str_r1 + str_r2;
				int tempLow = Integer.parseInt(str_12, 16);
				bytes[0] = (byte) tempLow;
				// 将生成的位码保存到字节数组的第二个元素中
				String str_34 = str_r3 + str_r4;
				int tempHigh = Integer.parseInt(str_34, 16);
				bytes[1] = (byte) tempHigh;
				ctmp = new String(bytes);
				break;
			default:
				itmp = random.nextInt(10) + 48;
				ctmp = String.valueOf((char) itmp);
				break;
			}
			sRand += ctmp;
			Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), random.nextInt(110));
			g.setColor(color);
			// 将生成的随机数进行随机缩放并旋转制定角度 PS.建议不要对文字进行缩放与旋转,因为这样图片可能不正常显示
			/* 将文字旋转制定角度 */
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate((45) * 3.14 / 180, 15 * i + 8, 7);
			/* 缩放文字 */
			float scaleSize = random.nextFloat() + 0.8f;
			if (scaleSize > 1f)
				scaleSize = 1f;
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			g.drawString(ctmp, 15 * i + 18, 14);
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("randCheckCode", sRand);
		g.dispose(); // 释放g所占用的系统资源
		ImageIO.write(image, "JPEG", response.getOutputStream()); // 输出图片
	}

	private void recover(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			Student s = student.findStudent(num);
			if (s != null) {
				s.setStatus("1");
				if (student.updateStatus(s)) {
					request.setAttribute("msg", "还原成功！");
					recycleBin(request, response);
				} else {
					request.setAttribute("msg", "还原失败");
					recycleBin(request, response);
				}

			} else {
				request.setAttribute("msg", "找不到");
				listStu(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void move(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			Student s = student.findStudent(num);
			if (s != null) {
				if (student.deleteStudent(num)) {
					clearRecycleBin(request, response);
				}
			} else {
				request.setAttribute("msg", "找不到");
				clearRecycleBin(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void clearRecycleBin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			if (student.deleteStatus()) {
				request.setAttribute("msg", "已经彻底删除！");
				recycleBin(request, response);
			} else {
				request.setAttribute("msg", "彻底删除失败！");
				recycleBin(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private void recycleBin(HttpServletRequest request, HttpServletResponse
	 * response) { // TODO Auto-generated method stub List<Student> sList=new
	 * ArrayList<Student>(); try { sList=student.recycleBinList();
	 * request.setAttribute("sList", sList);
	 * request.getRequestDispatcher("StudentInfo/recycleBin.jsp").forward(
	 * request, response); } catch (Exception e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * }
	 */
	private void recycleBin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("StudentInfo/recycleBin.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteStu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			Student s = student.findStudent(num);
			if (s != null) {
				s.setStatus("0");
				if (student.updateStatus(s)) {
					request.setAttribute("msg", "删除成功！");
					listStu(request, response);
				} else {
					request.setAttribute("msg", "删除失败");
					listStu(request, response);
				}

			} else {
				request.setAttribute("msg", "找不到");
				listStu(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private void listStu(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * // 共几页
	 * 
	 * try {
	 * 
	 * List<Student> sList = student.lispStudent();
	 * request.setAttribute("sList", sList);
	 * request.getRequestDispatcher("StudentInfo/stuList.jsp").forward(request,
	 * response); } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	private void listStu(HttpServletRequest request, HttpServletResponse response) {
		int pageNo = 1;
		int pageSize = 6;//当前页面的数据
		int count = 0;
		// String pageN=request.getParameter("pageNo");
		// int pn=Integer.parseInt(request.getParameter("pageNo"));
		// int ps=Integer.parseInt(request.getParameter("pageSize"));
		try {
			//
			if (request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals(""))
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			count = student.getCount();
			int totalPage = (int) Math.ceil((float) count / pageSize);// 取整

			if (pageNo < 1)
				pageNo = 1;
			if (pageNo > totalPage)
				pageNo = totalPage;

			List<Student> sList = student.lispStudent(pageSize, pageNo);
			request.setAttribute("sList", sList);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", totalPage);
			request.getRequestDispatcher("StudentInfo/sList.jsp").forward(request, response);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void searchStu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			String num = request.getParameter("num");
			if (num == null || num.equals("")) {
				request.setAttribute("msg", "学号不能为空！");
			} else {
				Student stu = student.findStudent(num);
				if (stu != null) {
					request.setAttribute("student", stu);
					request.getRequestDispatcher("StudentInfo/searchStu.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "找不到");
					listStu(request, response);
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 学生查看自己成绩
	 */
	private void searchScore(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/*
	 * 学生给代课老师写评价
	 */
	private void writeAssess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/*
	 * 学生选课
	 */
	private void selectCourse(HttpServletResponse response, HttpServletResponse response2) {
		// TODO Auto-generated method stub

	}

	/*
	 * 管理员修改学生
	 */
	private void modifyStu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		String xb = request.getParameter("xb");
		String name = request.getParameter("name");
		String Id = request.getParameter("Id");
		try {

			Student stu = student.findStudent(num);
			if (stu != null) {
				if (xb.equals("信息系")) {
					stu.setDepartment("信息系");
				} else if (xb.equals("经贸系")) {
					stu.setDepartment("经贸系");
				} else if (xb.equals("传媒系")) {
					stu.setDepartment("传媒系");
				} else if (xb.equals("汽车系")) {
					stu.setDepartment("汽车系");
				} else if (xb.equals("食品环境系")) {
					stu.setDepartment("食品环境系");
				}
				stu.setID(Id);
				stu.setName(name);
				if (student.modifyStudent(stu)) {
					listStu(request, response);
				} else {
					request.setAttribute("msg", "修改失败！");
					request.getRequestDispatcher("StudentInfo/modifyStu.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("msg", "找不到学号！");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 管理员修改学生（先查找，在跳到修改页面）
	 */
	private void updateStu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			Student stu = student.findStudent(num);
			if (stu != null) {
				request.setAttribute("StudentInfo", stu);
				request.getRequestDispatcher("StudentInfo/modifyStu.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "查不到");
				listStu(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 由于学生默认密码是000，学生修改个人密码
	 */
	private void changePsw(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		StringBuffer sbf = new StringBuffer();
		String oldPsw = request.getParameter("oldPsw");

		HttpSession session = request.getSession();
		session.getAttribute("stuNum");
		Student stu = null;
		try {
			String num = request.getParameter("num");
			if (oldPsw == null || oldPsw.equals("")) {
				sbf.append("原密码不能为空!<br/>");
			}
			stu = student.getPsw(oldPsw, num);
			if (stu != null) {
				String newPsw = request.getParameter("newPsw");
				String againPsw = request.getParameter("againPsw");
				if (newPsw == null || newPsw.equals("")) {
					sbf.append("新密码不能为空！<br/>");
				}
				if (againPsw == null || againPsw.equals("")) {
					sbf.append("再次输入新密码不能为空！<br/>");
				}
				if (oldPsw.equals(newPsw)) {
					sbf.append("新密码不能原来密码相同！<br/>");
				}
				if (newPsw.equals(againPsw)) {
					stu.setPassword(newPsw);
				} else {
					sbf.append("两次输入密码不同！<br/>");
				}
			} else {
				sbf.append("原密码输入错误！<br/>");
			}

			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				request.getRequestDispatcher("StudentInfo/changePsw.jsp").forward(request, response);
			} else {
				if (student.modifyStudent(stu)) {
					request.setAttribute("msg", "修改密码成功！");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "修改密码失败");
					request.getRequestDispatcher("StudentInfo/changePsw.jsp").forward(request, response);

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 管理员添加学生
	 */
	private void addStu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Student stu = new Student();
			StringBuffer sbf = new StringBuffer();
			String xb = request.getParameter("xb");
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String Id = request.getParameter("Id");
			if (xb.equals("信息系")) {
				stu.setDepartment("信息系");
			} else if (xb.equals("经贸系")) {
				stu.setDepartment("经贸系");
			} else if (xb.equals("传媒系")) {
				stu.setDepartment("传媒系");
			} else if (xb.equals("汽车系")) {
				stu.setDepartment("汽车系");
			} else if (xb.equals("食品环境系")) {
				stu.setDepartment("食品环境系");
			}

			if (num == null || num.equals("")) {
				sbf.append("学号不能为空！<br/>");
			} else {
				stu.setNum(num);
			}
			if (name == null || name.equals("")) {
				sbf.append("姓名不能为空！<br/>");
			} else {
				stu.setName(name);
			}

			if (sex.equals("男")) {
				stu.setSex(sex);
			} else {
				stu.setSex("女");
			}
			if (Id == null || Id.equals("")) {
				sbf.append("身份证号码不能为空");
			} else {
				stu.setID(Id);
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				request.getRequestDispatcher("StudentInfo/addStu.jsp").forward(request, response);
			} else {
				if (student.addStudent(stu)) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "添加失败");
					request.getRequestDispatcher("StudentInfo/addStu.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/*
	 * 学生登录个人信息
	 */
	private void listone(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String num = request.getParameter("num");
			Student stu = student.findStudent(num);
			request.setAttribute("student", stu);
			request.getRequestDispatcher("StudentInfo/listone.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 学生登录
	 */
	private void stuLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		StringBuffer sbf = new StringBuffer();
		String stuNum = request.getParameter("stuNum");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkCode");
		if (stuNum == null || stuNum.equals("")) {
			sbf.append("学号不能为空！<br/>");
		}
		if (password.equals("") || password == null) {
			sbf.append("密码不能为空！<br/>");
		}
		try {
			Student stu = student.login(stuNum, password);
			if (stu != null) {
				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					HttpSession session = request.getSession();
					if (checkcode.equals("") || checkcode == null) {
						sbf.append("请输入验证码！");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					} else {
						if (!checkcode.equalsIgnoreCase((String) session.getAttribute("randCheckCode"))) {
							request.setAttribute("msg", "验证码错误");
							request.getRequestDispatcher("index.jsp").forward(request, response);
						} else {
							session.setAttribute("stuNum", stuNum);
							session.setAttribute("password", password);
							request.getRequestDispatcher("StudentInfo/stuNav.jsp").forward(request, response);
						}
					}
				}

			} else {
				sbf.append("用户名和密码不对！或者用户不存在!<br/>");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 注销
	 */
	private void loginOut(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {
			if (session != null) {
				session.invalidate();// session失效
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
