package cn.edu.svtcc.test.pojo;

public class OrderDao {
	private Integer id;
	private String orderDate;
	private Integer userId;
	private Double totalPrice;
	
	public OrderDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDao [id=" + id + ", orderDate=" + orderDate + ", userId=" + userId + ", totalPrice=" + totalPrice
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}