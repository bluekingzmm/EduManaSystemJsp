package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.IAdmin;
import com.edu.db.DataBase;
import com.edu.dto.Admin;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

public class AdminImpl extends DataBase implements IAdmin {

	@Override
	public Admin login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		Admin ad = null;
		ResultSet rs = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from admin where userName=? and userPassword=? and state=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				ad = new Admin();
				ad.setUsername(rs.getString("username"));
				ad.setPws(rs.getString("psw"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return ad;
	}

	public boolean add(Admin a) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into admin(userName,userPassword,name) values(?,?,?)");
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPws());
			ps.setString(3, a.getName());
			while (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			DataBase.rollback();
		} finally {
			ps.close();
			DataBase.releaseConnection(con);
		}

		return false;
	}

	@Override
	public Admin select(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin ad = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from admin where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setUsername(rs.getString("userName"));
				ad.setPws(rs.getString("userPassword"));
				ad.setName(rs.getString("name"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return ad;
	}
	
	

	@Override
	public boolean delete(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement("delete from admin where id=?");
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			con.rollback();
		} finally {
			ps.close();
			DataBase.releaseConnection(con);
		}

		return false;
	}

	@Override
	public List<Admin> list() throws Exception {
		// TODO Auto-generated method stubL
		List<Admin> aList = null;
		Connection con = null;
		PreparedStatement ps = null;
		Admin ad = null;
		ResultSet rs = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from admin where state=?");
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			aList = new ArrayList<Admin>();
			while (rs.next()) {
				ad = new Admin();
				ad.setId(rs.getInt("id"));
				ad.setUsername(rs.getString("userName"));
				ad.setPws(rs.getString("userPassword"));
				ad.setName(rs.getString("name"));
				aList.add(ad);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return aList;
	}

	@Override
	public boolean modify(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement("update admin set userPassword=?,name=?  where id=?");
			ps.setString(1, ad.getPws());
			ps.setString(2, ad.getName());
			ps.setInt(3, ad.getId());
			while (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			con.rollback();
		} finally {
			ps.close();
			DataBase.releaseConnection(con);
		}
		return false;
	}

	@Override
	public Admin getPsw(String username) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin ad = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select userPassword  from admin where userName=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				ad = new Admin();
				ad.setPws(rs.getString("userPassword"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			rs.close();
			ps.close();
			DataBase.releaseConnection(con);
		}

		return ad;
	}

	@Override
	public boolean modisyPsw(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();	
			con.setAutoCommit(false);
			ps = con.prepareStatement("update admin set userPassword=? where userName=?");
			ps.setString(1, ad.getPws());
			ps.setString(2, ad.getUsername());
			while (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}
		} catch (Exception e) {
			con.rollback();
		} finally {
			ps.close();
			DataBase.releaseConnection(con);
		}

		return false;
	}

	@Override
	public boolean modifyOwnStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement("update student set stuName=?,stuId=? where stuNum=? ");
			ps.setString(1, s.getName());
			ps.setString(2, s.getID());
			ps.setString(3, s.getNum());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			con.rollback();
		}
		free(ps, con);
		return false;
	}

	@Override
	public List<StuScore> findByStudent(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		List<StuScore> sList = null;
		ResultSet rs = null;
		StuScore ss = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 where stuNum=?");
			ps.setString(1, num);
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			while (rs.next()) {
				ss = new StuScore();
				Course c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				Student s = new Student();
				s.setName(rs.getString("stuName"));
				s.setNum(rs.getString("stuNum"));
				Teacher tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				ss.setCourse(c);
				ss.setStu(s);
				ss.setTea(tea);
				ss.setScore(rs.getDouble("score"));
				sList.add(ss);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			free(rs, ps, con);
		}
		return sList;
	}

	@Override
	public Course findTeacherByCode(String tea_id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		try {
			ps = con.prepareStatement("select course_id from teacher  where tea_id=?");
			ps.setString(1, tea_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				c.setPlace(rs.getString("place"));
				c.setStucount(rs.getInt("stucount"));
				c.setTime(rs.getString("time"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			free(ps, con);
		}

		return c;
	}

	@Override
	public List<StuScore> LispStudentInfo(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		StuScore v = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore where tea_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			System.out.println("课程编号\t学生学号\t学生姓名\t性别\t身份证号码\t\t\t毕业日期\t\t课时\t地点");
			while (rs.next()) {
				v = new StuScore();
				Student stu = new Student();
				stu.setNum(rs.getString("stuNum"));
				stu.setID(rs.getString("stuId"));
				stu.setSex(rs.getString("stuSex"));
				stu.setName(rs.getString("stuName"));

				Course c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				c.setPlace(rs.getString("place"));
				c.setTime(rs.getString("time"));

				Teacher tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				v.setTea(tea);
				v.setCourse(c);
				v.setStu(stu);
				sList.add(v);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		free(rs, ps, con);

		return sList;
	}

	@Override
	public List<StuScore> LispStudentScore(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		StuScore v = null;
		ResultSet rs = null;
		List<StuScore> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from vscore1 where tea_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			sList = new ArrayList<StuScore>();
			System.out.println("课程编号\t学生学号\t学生姓名\t教师编号\t分数\t课程名\t教师名");
			while (rs.next()) {
				v = new StuScore();
				Student s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				Course c = new Course();
				c.setCourse_id(rs.getString("course_id"));
				c.setCourse_name(rs.getString("course_name"));
				Teacher tea = new Teacher();
				tea.setName(rs.getString("tea_name"));
				tea.setNum(rs.getString("tea_id"));
				v.setCourse(c);
				v.setTea(tea);
				v.setStu(s);
				v.setScore(rs.getDouble("score"));
				System.out.println(v + "\t" + c.getCourse_name() + "\t" + tea.getName());
				sList.add(v);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			free(rs, ps, con);
		}

		return sList;
	}

	@Override
	public boolean modifyOneTeacher(Teacher tea) throws Exception {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement("update teacher set tea_name=?,sex=?,tea_tel=? where tea_id=?");
			ps.setString(1, tea.getName());
			ps.setString(2, tea.getSex());
			ps.setString(3, tea.getTeatel());
			ps.setString(4, tea.getNum());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			con.rollback();
		} finally {

			free(ps, con);
		}

		return false;
	}
	public List<Admin> recycleBinList() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Admin> aList = null;
		Admin ad = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from admin where state=?");
			ps.setInt(1, 0);
			rs = ps.executeQuery();
			aList = new ArrayList<Admin>();
			while (rs.next()) {
				ad=new Admin();
				ad.setId(rs.getInt("id"));
				ad.setUsername(rs.getString("userName"));
				ad.setPws(rs.getString("userPassword"));
				ad.setName(rs.getString("name"));
				aList.add(ad);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs,ps, con);

		}

		return aList;
	}
	public boolean updateStatus(Admin ad) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update admin set state=? where id=?");
			ps.setInt(1,ad.getState());
			ps.setInt(2, ad.getId());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(ps, con);

		}
		return false;
	}
	public boolean deleteState() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from admin where state=?");
			ps.setInt(1, 0);
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(ps, con);
		}

		return false;
	}

	/*
	 * 功能：释放资源
	 */
	public static void free(PreparedStatement ps, Connection con) {

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					DataBase.releaseConnection(con);
				} catch (Exception e) {
					e.printStackTrace();

				}
		}
	}

	/*
	 * 功能：释放资源
	 */
	public static void free(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (con != null)
					try {
						DataBase.releaseConnection(con);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		}
	}

}
