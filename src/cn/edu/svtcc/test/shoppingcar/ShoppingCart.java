package cn.edu.svtcc.test.shoppingcar;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import cn.edu.svtcc.test.pojo.BookDo;

/**
 * 购物车类,用Map集合表示购物车 提供了添加购物车、删除购物车中的商品 修改购物车中的，得到购物车中所有的商品 清空购物车等功能
 * 
 * @author indext
 *
 */

public class ShoppingCart implements Serializable {
	/**
	 * 用Map实现购物车
	 */
	private static Map<String, shoppingItem> items = new LinkedHashMap<>();
	/**
	 * 购物车中商品的种类数
	 */
	private int itemAmout;

	/**
	 * 无参构造方法
	 */
	public ShoppingCart() {
		items = new HashMap<String, shoppingItem>();
		itemAmout = 0;
	}

	/**
	 * 往购物车中添加一类书
	 * 
	 * @param book 添加的图书对象
	 * @param num  添加的图书数量
	 */
	public synchronized void add(BookDo book, int num) {
		// 如果购物车已经有了这种图书
		if (items.containsKey(book.getIsbn())) {
			// 从购物车中获得这种图书
			shoppingItem item = items.get(book.getIsbn());
			// 添加图书的数量
			item.setAmout(item.getAmout() + num);
		} else {
			shoppingItem item = new shoppingItem(book, num);
			// 把item添加到购物车
			items.put(book.getIsbn(), item);
			itemAmout++;
		}
	}

	/**
	 * 返回购物车中所有的图书列表
	 * 
	 * @return
	 */
	public synchronized static Collection<shoppingItem> getItems() {
		return items.values();
	}

	/***
	 * 返回购物车中符合的图书列表
	 * 
	 * @return
	 */
	public synchronized static shoppingItem getShoppingItem(String isbn) {
		return items.get(isbn);
	}

	/**
	 * 返回购物车中所有图书的总价
	 * 
	 * @return
	 */
	public synchronized double getTotalReal() {
		double total = 0.0;
		Iterator<shoppingItem> it = getItems().iterator();// 创建一个迭代器
		while (it.hasNext()) {
			shoppingItem si = it.next();
			BookDo book = si.getItem();
			total += book.getUntiPrice() * si.getAmout();
		}

		return total;
	}

	/**
	 * 清空购物车
	 */
	public synchronized void clear() {
		items.clear();
	}

	/**
	 * 删除购物车中指定的isbn
	 * 
	 * @param isbn
	 */
	public synchronized void del(String isbn) {
		// 判断购物车中书是否存在，使用containsKey()查找键值
		if (items.containsKey(isbn)) {
			items.remove(isbn);
		}
	}

	public void setItems(Map<String, shoppingItem> items) {
		this.items = items;
	}

	/***
	 * 总的数量
	 * 
	 * @return
	 */
	public int getTotalNumber() {
		int total = 0;
		for (shoppingItem item : items.values()) {
			total += item.getAmout();
		}
		return total;
	}

	/***
	 * 加数量
	 * 
	 * @param isbn
	 */
	public void jia(String isbn) {
		shoppingItem sc = items.get(isbn);
		sc.setAmout(sc.getAmout() + 1);
	}

	/**
	 * 数量的减
	 * 
	 * @param isbn
	 */
	public void jian(String isbn) {
		shoppingItem sc = items.get(isbn);
		sc.setAmout(sc.getAmout() - 1);
	}

}
