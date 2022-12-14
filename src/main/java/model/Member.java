package model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Member implements Serializable{
    private int member_id;
    private String user_name;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Date birth;
    
	public Member() {
        member_id = -1;
        user_name = "song02";
        password = "0000"; 
        name = "성춘향";
        email = "chun@naver.com";
        phone = "010-0000-0000";
        birth = new Date(0);
    }
	
	public Member(String user_name, String password, String name, String email, String phone, Date birth) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
	}

	public Member(int member_id, String user_name, String password, String name, String email, String phone,
			Date birth) {
		super();
		this.member_id = member_id;
		this.user_name = user_name;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;

	}

	//비밀번호 검사
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}	
	//회원가입시 아이디 검사
	public boolean isSameUser(String user_name) {
        return this.user_name.equals(user_name);
    }
	
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", user_name=" + user_name + ", password=" + password + ", name="
				+ name + ", email=" + email + ", phone=" + phone + ", birth=" + birth + "]";
	}     
}
