package bean;

public class Sale {

	private int id;//ユニフォームID
	private String uniformName;//ユニフォーム名
	private int price;//価格
	private int quantity;//数量
	private String image;//写真
	private String remark;//備考欄

	public Sale() {
		this.id = 0;
		this.uniformName = null;
		this.price = 0;
		this.quantity = 0;
		this.image = null;
		this.remark = null;
	}

	public int getId() {
		return id;
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
	public String getImage() {
		return image;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setImage(String image) {
		this.image = image;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}



}
