package model;

public class Member {
    private int member_id;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String birth;
    
    public Member() {
        member_id = -1;
        password = "0000"; 
        name = "성춘향";
        email = "chun@naver.com";
        phone = "010-0000-0000";
        birth = "";
    }
    
    public Member(int member_id, String password, String name, String email, String phone, String birth) {
        super();
        this.member_id = member_id;
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
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    
    @Override
    public String toString() {
        return "MemberDTO [member_id=" + member_id + ", password=" + password + ", name=" + name + ", email=" + email
                + ", phone=" + phone + ", birth=" + birth + ", toString()=" + super.toString() + "]";
    }  
    
}
