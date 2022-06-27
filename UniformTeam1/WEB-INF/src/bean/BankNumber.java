package bean;

public class BankNumber {

	private int id;//振込先ID
	private String bankNumber;//口座番号

	public BankNumber() {
		this.id = 0;
		this.bankNumber = null;
	}

	public int getId() {
		return id;
	}
	public String getBankNumber() {
		return bankNumber;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

}
