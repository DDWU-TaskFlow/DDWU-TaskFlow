package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Participation implements Serializable{
	private int project_id;
	private int member_id;
	
	public Participation() {
		project_id = 0;
		member_id = 0;
	}
	public Participation(int project_id, int member_id) {
		super();
		this.project_id = project_id;
		this.member_id = member_id;
	}
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	@Override
	public String toString() {
		return "Participation [project_id=" + project_id + ", member_id=" + member_id + "]";
	}
	
}
