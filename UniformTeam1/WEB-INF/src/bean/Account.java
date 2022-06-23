package bean;

public class Account {

	private int id;//
	private String name;
	private String email;
	private String postal_code;
	private String address;
	private String authority;

	public Account() {
		this.id = 0;
		this.name = null;
		this.email = null;
		this.postal_code = null;
		this.address = null;
		this.authority = null;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public String getAddress() {
		return address;
	}
	public String getAuthority() {
		return authority;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
