package com.edu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.dao.ICourse;
import com.edu.dao.impl.CourseImpl;
import com.edu.dto.Course;

/**
 * Servlet implementation class CourseAction
 */
@WebServlet("/CourseAction")
public class CourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICourse course = new CourseImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseAction() {
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
		if (operate.equals("addCou")) {
			addCou(request, response);
		} else if (operate.equals("deleteCou")) {
			deleteCou(request, response);
		} else if (operate.equals("updateCou")) {
			updateCou(request, response);
		} else if (operate.equals("modifyCou")) {
			modifyCou(request, response);
		} else if (operate.equals("searchCou")) {
			searchCou(request, response);
		} else if (operate.equals("listCou")) {
			listCou(request, response);

		}

	}

	private void listCou(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			List<Course> cList = course.dispListCourse();
			request.setAttribute("cList", cList);
			request.getRequestDispatcher("CourseInfo/listCou.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void searchCou(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String courseid = request.getParameter("courseid");

		try {
			if (courseid == null || courseid.equals("")) {
				request.setAttribute("msg", "课程号不能为空！");
				listCou(request, response);
			} else {
				Course cou = course.findByCode(courseid);
				if (cou != null) {
					request.setAttribute("CourseInfo", cou);
					request.getRequestDispatcher("CourseInfo/listOneCou.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "找不到");
					listCou(request, response);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void modifyCou(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		StringBuffer sbf = new StringBuffer();
		String coursename = request.getParameter("coursename");
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		int stucount = Integer.parseInt(request.getParameter("stucount"));
		String courseid = request.getParameter("courseid");
		try {

			Course cou = course.findByCode(courseid);
			if (cou != null) {
				if (coursename == null || coursename.equals("")) {
					sbf.append("课程号不能为空！");
				} else {
					cou.setCourse_name(coursename);
				}
				if (place == null || place.equals("")) {
					sbf.append("上课地点不为空！");
				} else {
					cou.setPlace(place);
				}
				if (stucount == 0) {
					sbf.append("上课人数不能为空！");
				} else {
					cou.setStucount(stucount);
				}
				if (time == null || time.equals("")) {
					sbf.append("课时不能为空！");
				} else {
					cou.setTime(time + "课时");
				}
				if (sbf.length() != 0) {
					request.setAttribute("msg", sbf.toString());
					request.getRequestDispatcher("CourseInfo/modifyCou.jsp").forward(request, response);
				} else {
					if (course.ModifyCourse(cou)) {
						request.setAttribute("msg", "修改成功");
						listCou(request, response);
					} else {
						request.setAttribute("msg", "修改失败");
					}
				}

			} else {
				request.setAttribute("msg", "找不到");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void updateCou(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String courseid = request.getParameter("courseid");
			Course cou = course.findByCode(courseid);
			request.setAttribute("CourseInfo", cou);
			request.getRequestDispatcher("CourseInfo/modifyCou.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void deleteCou(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String courseid = request.getParameter("courseid");
		try {
			Course cou = course.findByCode(courseid);
			if (cou != null) {
				if (course.DelectCourse(courseid)) {
					request.setAttribute("msg", "删除成功");
					listCou(request, response);
				} else {
					request.setAttribute("msg", "删除失败");
					listCou(request, response);
				}
			} else {
				request.setAttribute("msg", "找不到");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void addCou(HttpServletRequest request, HttpServletResponse response) {

		StringBuffer sbf = new StringBuffer();

		String courseid = request.getParameter("courseid");
		String coursename = request.getParameter("coursename");
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		int stucount = Integer.parseInt(request.getParameter("stucount"));
		Course cou = null;
		try {
			cou = new Course();
			if (courseid == null || courseid.equals("")) {
				sbf.append("课程号不能为空！");
			} else {
				cou.setCourse_id(courseid);
			}
			if (coursename == null || coursename.equals("")) {
				sbf.append("课程名不能为空！");
			} else {
				cou.setCourse_name(coursename);
			}
			if (place == null || place.equals("")) {
				sbf.append("上课地点不为空！");
			} else {
				cou.setPlace(place);
			}
			if (stucount == 0) {
				sbf.append("上课人数不能为空！");
			} else {
				cou.setStucount(stucount);
			}
			if (time == null || time.equals("")) {
				sbf.append("课时不能为空！");
			} else {
				cou.setTime(time + "课时");
			}
			if (sbf.length() != 0) {
				request.setAttribute("msg", sbf.toString());
				request.getRequestDispatcher("CourseInfo/addCou.jsp").forward(request, response);
			} else {
				if (course.AddCourse(cou)) {
					request.setAttribute("msg", "添加成功");
					listCou(request, response);
				} else {
					request.setAttribute("msg", "添加失败");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
