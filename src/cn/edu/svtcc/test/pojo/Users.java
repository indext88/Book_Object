package cn.edu.svtcc.test.pojo;

public class Users implements java.io.Serializable {
	private static final String String = null;
	private String id;
	private String loginId;
	private String loginPwd;
	private String name;
	private String phone;
	private String address;
	private String mail;
	private String loginPwdd;
	private String userRoleId;
	private String userStateId;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", loginId=" + loginId + ", loginPwd=" + loginPwd + ", name=" + name + ", phone="
				+ phone + ", address=" + address + ", mail=" + mail + ", loginPwdd=" + loginPwdd + ", userRoleId="
				+ userRoleId + ", userStateId=" + userStateId + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLoginPwdd() {
		return loginPwdd;
	}
	public void setLoginPwdd(String loginPwdd) {
		this.loginPwdd = loginPwdd;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserStateId() {
		return userStateId;
	}
	public void setUserStateId(String userStateId) {
		this.userStateId = userStateId;
	}
	public static String getString() {
		return String;
	}
  
}