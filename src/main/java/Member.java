
public class Member {
	private String yname,email,password,rpassword;

	public Member(String yname, String email, String password, String rpassword) {
		super();
		this.yname = yname;
		this.email = email;
		this.password = password;
		this.rpassword = rpassword;
	}

	public Member() {
		super();
	}

	public String getYname() {
		return yname;
	}

	public void setYname(String yname) {
		this.yname = yname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	@Override
	public String toString() {
		return "Member [yname=" + yname + ", email=" + email + ", password=" + password + ", rpassword=" + rpassword
				+ "]";
	}
	

}