package cn.edu.svtcc.test.shoppingcar;

import java.io.Serializable;

import cn.edu.svtcc.test.pojo.BookDo;

public class shoppingItem implements Serializable {
	/**
	 * 购物车中的商品
	 */
	private BookDo item;
	/**
	 * 放入购物车中的数量
	 */
	private int amout;

	public shoppingItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public shoppingItem(BookDo item, int amout) {
		super();
		this.item = item;
		this.amout = amout;
	}

	public void inAmount() {
		amout++;
	}

	public void deAmount() {
		amout--;
	}

	public BookDo getItem() {
		return item;
	}

	public void setItem(BookDo item) {
		this.item = item;
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}

}
