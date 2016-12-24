package com.edu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.ITeacher;
import com.edu.dao.impl.TeacherImpl;
import com.edu.dto.Teacher;

/**
 * Servlet implementation class TeacherAction
 */
@WebServlet("/TeacherAction")
public class TeacherAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITeacher teacher = new TeacherImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherAction() {
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
		if (operate.equals("addTea")) {
			addTea(request, response);
		} else if (operate.equals("deleteTea")) {
			deleteTea(request, response);
		} else if (operate.equals("modifyTea")) {
			modifyTea(request, response);
		} else if (operate.equals("updateTea")) {
			updateTea(request, response);
		} else if (operate.equals("searchTea")) {
			searchTea(request, response);
		} else if (operate.equals("searchStuScorce")) {
			searchStuScorce(request, response);
		} else if (operate.equals("searchAssess")) {
			searchAssess(request, response);
		}else if(operate.equals("listTea")){
			listTea(request,response);
		}
	}

	private void listTea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		try {
			List<Teacher> tList = teacher.dispAllTeacher();
			request.setAttribute("tList", tList);
			request.getRequestDispatcher("TeacherInfo/listTea.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 教师查看评价（每个学生给自己的评价）
	 */
	private void searchAssess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/*
	 * 查询本班学生成绩
	 */
	private void searchStuScorce(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	/*
	 * 功能：管理员查找教师
	 */
	private void searchTea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			Teacher tea = teacher.findTeacher(num);
			if (num == null || num.equals("")) {
				request.setAttribute("msg", "教工号不能为空！");
			}
			if (tea != null) {
				request.setAttribute("TeacherInfo", tea);
				request.getRequestDispatcher("TeacherInfo/listOneTea.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "查不到");
				listTea(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 管理员修改教师信息（先查询，传参数TeacherInfo） 在跳到modifyTea页面
	 */
	private void updateTea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			Teacher tea = teacher.findTeacher(num);
			if (tea != null) {
				request.setAttribute("TeacherInfo", tea);
				request.getRequestDispatcher("TeacherInfo/modifyTea.jsp").forward(request, response);

			} else {
				request.setAttribute("msg", "查不到");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 管理员修改教师信息
	 */
	private void modifyTea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		StringBuffer sbf = null;
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String courseid = request.getParameter("courseid");
		String teaTel = request.getParameter("tel");
		Teacher tea;
		try {
			tea = teacher.findTeacher(num);
			sbf = new StringBuffer();
			if (tea != null) {
				if (num == null || num.equals("")) {
					sbf.append("教工号不能为空！");
				} else {
					tea.setNum(num);
				}
				if (name == null || name.equals("")) {
					sbf.append("姓名不能为空！");
				} else {
					tea.setName(name);
				}

				if (courseid == null || courseid.equals("")) {
					sbf.append("所带课程号不能为空！");
				} else {
					tea.setCourse_id(courseid);
				}
				if (teaTel == null || teaTel.equals("")) {
					sbf.append("手机号码不能为空！");
				} else {
					tea.setTeatel(teaTel);
				}

				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					request.getRequestDispatcher("TeacherInfo/modifyea.jsp").forward(request, response);

				} else {
					if (teacher.modifyTeacher(tea)) {
						request.setAttribute("msg", "修改成功!");
						listTea(request, response);				
						} else {
						request.setAttribute("msg", "修改失败!");
						request.getRequestDispatcher("TeacherInfo/modifyea.jsp").forward(request, response);

					}
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 管理员删除教师信息
	 */

	private void deleteTea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		try {
			if (teacher.deleteTeacher(num)) {
				request.setAttribute("msg", "删除成功!");
				listTea(request, response);
			} else {
				request.setAttribute("msg", "删除失败!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 管理员增加教师信息
	 */

	private void addTea(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		StringBuffer sbf = new StringBuffer();
		Teacher tea = null;
		try {
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String courseid = request.getParameter("courseid");
			String teaTel = request.getParameter("tel");
			tea = new Teacher();
			if (num == null || num.equals("")) {
				sbf.append("教工号不能为空！");
			} else {
				tea.setNum(num);
			}
			if (name == null || name.equals("")) {
				sbf.append("姓名不能为空！");
			} else {
				tea.setName(name);
			}

			if (courseid == null || courseid.equals("")) {
				sbf.append("所带课程号不能为空！");
			} else {
				tea.setCourse_id(courseid);
			}
			if (sex.equals("男")) {
				tea.setSex("男");
			} else {
				tea.setSex("女");
			}
			if (teaTel == null || teaTel.equals("")) {
				sbf.append("手机号码不能为空！");
			} else {
				tea.setTeatel(teaTel);
			}

			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				request.getRequestDispatcher("TeacherInfo/addTea.jsp").forward(request, response);

			} else {
				if (teacher.addTeacher(tea)) {
					request.setAttribute("msg", "添加成功!");
					listTea(request, response);
				} else {
					request.setAttribute("msg", "添加失败");
					request.getRequestDispatcher("TeacherInfo/addTea.jsp").forward(request, response);

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
