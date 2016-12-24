/**
 * 
 */
package com.edu.dto;

/**
 * @author Administrator
 *
 */
public class Admin {
	private int id;
	private String username;
	private String pws;
	private String name;
	private int state;
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPws() {
		return pws;
	}

	public void setPws(String pws) {
		this.pws = pws;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", pws=" + pws + ", name=" + name + ", state=" + state
				+ "]";
	}

	

	

}
