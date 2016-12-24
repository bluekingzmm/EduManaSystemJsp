/**
 * 
 */
package com.edu.dto;

import java.util.Date;

/**
 * @author Administrator
 *
 */
public abstract class Person {

	private String name;

	private String num;
	private String password;
	private String sex;
	public Person(String name, String num, String password, String sex) {
		super();
		this.name = name;

		this.num = num;
		this.password = password;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "person [name=" + name + ",  num=" + num + ", password=" + password + ", sex=" + sex
				+ "]";
	}
	
	public Person(){
		
	}
}
