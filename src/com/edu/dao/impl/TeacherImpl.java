/**
 * 
 */
package com.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.dao.ITeacher;
import com.edu.db.DataBase;
import com.edu.dto.Teacher;

/**
 * @author Administrator
 *
 */
public class TeacherImpl extends DataBase implements ITeacher {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#addTeacher(com.edu.dto.Teacher)
	 */
	@Override
	public boolean addTeacher(Teacher tea) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);

			ps = con.prepareStatement(
					"insert into teacher(tea_id,tea_name,sex,course_id,tea_tel,tea_password,memo,assess) values(?,?,?,?,?,?,?,?) ");
			ps.setString(1, tea.getNum());
			ps.setString(2, tea.getName());
			ps.setString(3, tea.getSex());
			ps.setString(4, tea.getCourse_id());
			ps.setString(5, tea.getTeatel());
			ps.setString(6, tea.getPassword());
			ps.setString(7, tea.getMemo());
			ps.setString(8, tea.getAssess());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			DataBase.rollback();
		} finally {
			AdminImpl.free(ps, con);
		}


		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#deleteTeacher(java.lang.String)
	 */
	@Override
	public boolean deleteTeacher(String code) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		try {

			con = getConn();
			con.setAutoCommit(false);

			ps = con.prepareStatement("delete from teacher where tea_id=?");
			ps.setString(1, code);
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			DataBase.rollback();

		}finally {
			AdminImpl.free(ps, con);
		}


		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#modifyTeacher(com.edu.dto.Teacher)
	 */
	@Override
	public boolean modifyTeacher(Teacher tea) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			con.setAutoCommit(false);
			ps = con.prepareStatement(
					"update teacher set tea_name=?,sex=?,course_id=?,tea_tel=?,tea_password=? where tea_id=?");
			ps.setString(1, tea.getName());
			ps.setString(2, tea.getSex());
			ps.setString(3, tea.getCourse_id());
			ps.setString(4, tea.getTeatel());
			ps.setString(5, tea.getPassword());
			ps.setString(6, tea.getNum());
			if (ps.executeUpdate() > 0) {
				DataBase.commit();
				return true;
			}

		} catch (Exception e) {
			DataBase.rollback();
		}finally {
			AdminImpl.free(ps, con);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#findTeacher(java.lang.String)
	 */
	@Override
	public Teacher findTeacher(String code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from teacher where tea_id=?");
			ps.setString(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTeatel(rs.getString("tea_tel"));
				tea.setMemo(rs.getString("memo"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			AdminImpl.free(rs,ps, con);
		}
		return tea;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#dispAllTeacher()
	 */
	@Override
	public List<Teacher> dispAllTeacher() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		Teacher tea = null;
		ResultSet rs = null;
		List<Teacher> sList = null;
		try {
			sList = new ArrayList<Teacher>();
			con = getConn();
			ps = con.prepareStatement("select * from teacher ");
			rs = ps.executeQuery();
			while (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setName(rs.getString("tea_name"));
				tea.setSex(rs.getString("sex"));
				tea.setCourse_id(rs.getString("course_id"));
				tea.setTeatel(rs.getString("tea_tel"));
				tea.setMemo(rs.getString("memo"));
				sList.add(tea);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			AdminImpl.free(rs,ps, con);

		}
		return sList;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.dao.ITeacher#loginTeacher(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Teacher loginTeacher(String code, String teaPassword) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		Teacher tea = null;
		ResultSet rs = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from teacher where tea_id=? and tea_password=?");
			ps.setString(1, code);
			ps.setString(2, teaPassword);
			rs = ps.executeQuery();
			if (rs.next()) {
				tea = new Teacher();
				tea.setNum(rs.getString("tea_id"));
				tea.setPassword(rs.getString("tea_password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			AdminImpl.free(rs,ps, con);

		}
		return tea;
	}

}
