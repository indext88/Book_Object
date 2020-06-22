package cn.edu.svtcc.test.pojo;

public class PayDao {
	private String bname;
	private int num;
	private double price;
	private double sumprice;
	
	
	public PayDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PayDao [bname=" + bname + ", num=" + num + ", price=" + price + ", sumprice=" + sumprice + "]";
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSumprice() {
		return sumprice;
	}
	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	
	

}
