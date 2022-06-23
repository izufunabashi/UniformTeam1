package bean;

public class Registrant {

	private String registrant_id;//登録者ID
	private int account_id;//アカウントID
	private String password;//パスワード
	private String authority;//権限

	public Registrant() {
		this.registrant_id = null;
		this.account_id = 0;
		this.password = null;
		this.authority = null;
	}

	public String getRegistrant_id() {
		return registrant_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public String getPassword() {
		return password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setRegistrant_id(String registrant_id) {
		this.registrant_id = registrant_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}


}
