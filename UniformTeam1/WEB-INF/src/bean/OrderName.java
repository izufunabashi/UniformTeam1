package bean;

public class OrderName {

	private int id;//受注ID
	private String name;//購入者名
	private int total_price;//合計金額
	private String order_date;
	private String payment;//入金状態
	private String shipping;//発送状態

	public OrderName() {
		this.id = 0;
		this.name = null;
		this.total_price = 0;
		this.payment = null;
		this.shipping = null;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getTotal_price() {
		return total_price;
	}
	public String getPayment() {
		return payment;
	}
	public String getShipping() {
		return shipping;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

}
