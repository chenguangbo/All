package cn.baidu.com;

public class User {

	private String name;

	private String password;

	private String part;

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", part=" + part + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
	
	
}
