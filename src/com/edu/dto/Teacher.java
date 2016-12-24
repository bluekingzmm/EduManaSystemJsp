/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public class Teacher extends Person {

	private String course_id;
	private String Teatel;
	private String memo;
	private String assess;
	private String write;
	
	


	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getTeatel() {
		return Teatel;
	}

	public void setTeatel(String teatel) {
		Teatel = teatel;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAssess() {
		return assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public Teacher(String code, String tea_name, String sex, String course_id, String tea_password) {
		super(tea_name, code, tea_password, sex);

		this.course_id = course_id;

	}

	@Override
	public String toString() {
		return super.toString() + "\t" + this.course_id;
	}

	public Teacher() {

	}
}
