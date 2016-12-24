/**
 * 
 */
package com.edu.dao;

import java.util.List;

import com.edu.dto.Student;

/**
 * @author Administrator
 *
 */
public interface IStudent {

	/*
	 * 登录功能：需要输入学号和密码
	 */

	public Student login(String stuNum, String password) throws Exception;

	/*
	 * 管理员添加学生信息（boolean）判断是否添加
	 */
	public boolean addStudent(Student s) throws Exception;

	/*
	 * 管理员删除学生信息（boolean）判断是否删除
	 */
	public boolean deleteStudent(String num) throws Exception;

	/*
	 * 管理员 修改学生信息（boolean）判断是否修改学生信息
	 */
	public boolean modifyStudent(Student s) throws Exception;

	/*
	 * 显示学生列表 <list集合>
	 * 
	 */

	public List<Student> lispStudent(int pageSize, int pageNo) throws Exception;

	/*
	 * 查找学生 Student
	 */
	public int getCount() throws Exception;

	public Student findStudent(String num) throws Exception;

	/*
	 * 根据关键字查询 模糊查询
	 */
	public List<Student> findStudent(int key, String keyname) throws Exception;

	public Student getPsw(String password, String num) throws Exception;

	public boolean updateStatus(Student s) throws Exception;

	public List<Student> recycleBinList() throws Exception;

	public boolean deleteStatus() throws Exception;

	/*public List<Student> getPageList(int currentPageIndex, int count) throws Exception;

	*//**
	 * 获取公有多少页
	 * 
	 * @param count
	 *            代表的是页面显示的记录数
	 * @return 返回页面的数量
	 *//*
	public int getPageCount(int count)throws Exception;*/

}
