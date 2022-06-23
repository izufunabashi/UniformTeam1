package bean;

public class OrderManagement {

	private int order_management_id;
	private int account_id;
	private int total_price;
	private String order_date;
	private String payment;
	private String shipping;

	public OrderManagement() {
		this.order_management_id = 0;
		this.account_id = 0;
		this.total_price = 0;
		this.order_date = null;
		this.payment = null;
		this.shipping = null;
	}

	public int getOrder_management_id() {
		return order_management_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public int getTotal_price() {
		return total_price;
	}
	public String getOrder_date() {
		return order_date;
	}
	public String getPayment() {
		return payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setOrder_management_id(int order_management_id) {
		this.order_management_id = order_management_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

}
