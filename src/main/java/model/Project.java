package model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Project implements Serializable {
    private int project_id;
    private int leader_id;
    private String name;
    private int type;
    private Date creationDate;
    private String createdLink;
    private String notice;
    private String color;
    
    public Project() {
        name = "홍길동";
        leader_id = 0;
        type = 0;
        creationDate = new Date(0);
        createdLink = "";
        notice = "";
        color = "";
    }

	public Project(int leader_id, String name, int type, Date creationDate, String createdLink, String notice,
			String color) {
		super();
		this.leader_id = leader_id;
		this.name = name;
		this.type = type;
		this.creationDate = creationDate;
		this.createdLink = createdLink;
		this.notice = notice;
		this.color = color;
	}
	
	public Project(int project_id, int leader_id, String name, int type, Date creationDate, String createdLink,
			String notice, String color) {
		super();
		this.project_id = project_id;
		this.leader_id = leader_id;
		this.name = name;
		this.type = type;
		this.creationDate = creationDate;
		this.createdLink = createdLink;
		this.notice = notice;
		this.color = color;
	}


	public int getProject_id() {
        return project_id;
    }
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLeader_id() {
		return leader_id;
	}
	public void setLeader_id(int leader_id) {
		this.leader_id = leader_id;
	}
	public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public String getCreatedLink() {
        return createdLink;
    }
    public void setCreatedLink(String createdLink) {
        this.createdLink = createdLink;
    }
    public String getNotice() {
        return notice;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }
    public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", leader_id=" + leader_id + ", name=" + name + ", type=" + type
				+ ", creationDate=" + creationDate + ", createdLink=" + createdLink + ", notice=" + notice + ", color="
				+ color + "]";
	}
}
