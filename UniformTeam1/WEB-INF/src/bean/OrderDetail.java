package bean;

public class OrderDetail {

	private int order_detail_id;//
	private int order_management_id;
	private String uniformName;//
	private int price;//価格
	private int quantity;//数量
	private String remark;//備考欄

	public OrderDetail() {
		this.order_detail_id = 0;
		this.order_management_id = 0;
		this.uniformName = null;
		this.price = 0;
		this.quantity = 0;
		this.remark = null;
	}

	public int getOrder_management_id() {
		return order_management_id;
	}

	public void setOrder_management_id(int order_management_id) {
		this.order_management_id = order_management_id;
	}

	public int getOrder_detail_id() {
		return order_detail_id;
	}
	public String getUniformName() {
		return uniformName;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}

	public String getRemark() {
		return remark;
	}
	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public void setUniformName(String uniformName) {
		this.uniformName = uniformName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
