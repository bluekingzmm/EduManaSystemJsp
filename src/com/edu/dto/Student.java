/**
 * 
 */
package com.edu.dto;


/**
 * @author Administrator
 *
 */
public class Student extends Person {

	private String ID;
	private String department;
	private String course_id;
	private String course_name;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", department=" + department + ", course_id=" + course_id + ", course_name="
				+ course_name + ", status=" + status + "]";
	}

	public Student(String name, String num, String password, String sex, String iD, String department, String course_id,
			String course_name, String status) {
		super(name, num, password, sex);
		ID = iD;
		this.department = department;
		this.course_id = course_id;
		this.course_name = course_name;
		this.status = status;
	}

	

}
