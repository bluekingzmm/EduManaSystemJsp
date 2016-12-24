package com.edu.dao;

import java.util.List;

import com.edu.dto.Admin;
import com.edu.dto.Course;
import com.edu.dto.StuScore;
import com.edu.dto.Student;
import com.edu.dto.Teacher;

public interface IAdmin {

	public Admin login(String username, String password) throws Exception;

	public boolean add(Admin a) throws Exception;

	public Admin select(int id) throws Exception;

	public Admin getPsw(String username) throws Exception;

	public boolean delete(int id) throws Exception;

	public boolean modify(Admin ad) throws Exception;

	public List<Admin> list() throws Exception;

	public boolean modisyPsw(Admin ad) throws Exception;

	public List<Admin> recycleBinList() throws Exception;

	public boolean updateStatus(Admin ad) throws Exception;

	public boolean deleteState() throws Exception;
	/*
	 * 修改个人信息
	 */

	public boolean modifyOwnStudent(Student s) throws Exception;

	/*
	 * 根据学生编号查询
	 */
	public List<StuScore> findByStudent(String num) throws Exception;

	public Course findTeacherByCode(String tea_id) throws Exception;

	/*
	 * 查看本班学生信息 视图
	 */
	public List<StuScore> LispStudentInfo(String code) throws Exception;

	/*
	 * 查看本班学生成绩 视图
	 */

	public List<StuScore> LispStudentScore(String code) throws Exception;

	/*
	 * 修改个人信息
	 */

	public boolean modifyOneTeacher(Teacher tea) throws Exception;
}
