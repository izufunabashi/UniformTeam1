package bean;

/*
 * プログラム名：ユニフォーム受注管理システム SalesState
 * プログラムの説明：売上げ状況のデータを格納するDTOクラス
 * 作成者：佐久間優
 * 作成日：2022/06/27
 */

public class SalesState {

	private int order_detail_id;//受注詳細ID
	private String uniform_name;//ユニフォーム名
	private int price;//単価
	private int quantity;//数量
	private int total;//小計
	private String order_date;

	public SalesState() {
		this.order_detail_id = 0;
		this.uniform_name = null;
		this.price = 0;
		this.quantity = 0;
		this.total = 0;
		this.order_date = null;
	}
	public int getOrder_detail_id() {
		return order_detail_id;
	}
	public String getUniform_name() {
		return uniform_name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getTotal() {
		return total;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public void setUniform_name(String uniform_name) {
		this.uniform_name = uniform_name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

}
