/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.edu.dao.IStudent;
import com.edu.db.DataBase;
import com.edu.dto.Student;

/**
 * @author Administrator
 *
 */
public class StudentImpl extends DataBase implements IStudent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Student login(String stuNum, String password) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		Student s = null;
		ResultSet rs = null;
		try {

			con = getConn();
			ps = con.prepareStatement("select * from student where stuNum=? and stuPassword=? and status=?");
			ps.setString(1, stuNum);
			ps.setString(2, password);
			ps.setString(3, "1");
			rs = ps.executeQuery();
			if (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setPassword(rs.getString("stuPassword"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs, ps, con);
		}
		return s;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#select(java.lang.String)
	 */

	public Student findStudent(String stuNum) throws Exception {
		// TODO Auto-generated method stub
		Student stu = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student where stuNum=?");
			ps.setString(1, stuNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				stu = new Student();

				stu.setCourse_id(rs.getString("course_id"));
				stu.setDepartment(rs.getString("department"));
				stu.setID(rs.getString("stuId"));
				stu.setName(rs.getString("stuName"));
				stu.setSex(rs.getString("stuSex"));
				stu.setNum(rs.getString("stuNum"));
				stu.setPassword(rs.getString("stuPassword"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs, ps, con);
		}
		return stu;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.IStudent#listname()
	 */

	public List<Student> listname() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("insert into student(stuNum,stuName,stuSex,stuId,department) values(?,?,?,?,?) ");
			ps.setString(1, s.getNum());
			ps.setString(2, s.getName());
			ps.setString(3, s.getSex());
			ps.setString(4, s.getID());
			ps.setString(5, s.getDepartment());

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

	@Override
	public boolean deleteStudent(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from student where stuNum=?");
			ps.setString(1, num);
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

	@Override
	public boolean modifyStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement(
					"update student set stuName=?,stuSex=?,stuId=?,stuPassword=?,department=? where stuNum=? ");
			ps.setString(1, s.getName());
			ps.setString(2, s.getSex());
			ps.setString(3, s.getID());
			ps.setString(4, s.getPassword());
			ps.setString(5, s.getDepartment());
			ps.setString(6, s.getNum());
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

	@Override
	public List<Student> lispStudent(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> sList = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student where status=? limit ?,?");
			ps.setString(1, "1");
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			sList = new ArrayList<Student>();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setDepartment(rs.getString("department"));
				s.setID(rs.getString("stuId"));
				s.setDepartment(rs.getString("department"));
				s.setCourse_id(rs.getString("course_id"));
				sList.add(s);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs, ps, con);
		}

		return sList;
	}
	public int getCount() throws Exception {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con=getConn();
			String sql = "select count(*) from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
			ps.close();
			DataBase.releaseConnection(con);
		}
		return count;
	}

	@Override
	public List<Student> findStudent(int key, String keyname) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getPsw(String password, String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student where stuPassword=? and stuNum=?");
			ps.setString(1, password);
			ps.setString(2, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setID(rs.getString("stuId"));
				s.setPassword(rs.getString("stuPassword"));
				s.setDepartment(rs.getString("department"));
				s.setCourse_id(rs.getString("course_id"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs, ps, con);

		}

		return s;

	}

	@Override
	public boolean updateStatus(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("update student set status=? where stuNum=?");
			ps.setString(1, s.getStatus());
			ps.setString(2, s.getNum());
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

	@Override
	public List<Student> recycleBinList() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> sList = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from student where status=?");
			ps.setString(1, "0");
			rs = ps.executeQuery();
			sList = new ArrayList<Student>();
			while (rs.next()) {
				s = new Student();
				s.setNum(rs.getString("stuNum"));
				s.setName(rs.getString("stuName"));
				s.setSex(rs.getString("stuSex"));
				s.setDepartment(rs.getString("department"));
				s.setID(rs.getString("stuId"));
				s.setDepartment(rs.getString("department"));
				s.setCourse_id(rs.getString("course_id"));
				sList.add(s);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs, ps, con);

		}

		return sList;
	}

	@Override
	public boolean deleteStatus() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from student where status=?");
			ps.setString(1, "0");
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

}
