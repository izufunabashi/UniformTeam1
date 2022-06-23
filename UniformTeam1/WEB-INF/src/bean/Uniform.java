package bean;

public class Uniform {

	private int id;//ユニフォームID
	private String uniformName;//ユニフォーム名
	private int price;//価格
	private int stock;//在庫
	private String image;//画像
	private String description;//説明

	public Uniform() {
		this.id = 0;
		this.uniformName = null;
		this.price = 0;
		this.stock = 0;
		this.image = null;
		this.description = null;
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

	public int getStock() {
		return stock;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
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

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
