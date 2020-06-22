package cn.edu.svtcc.test.interfacee;

import java.util.List;

import cn.edu.svtcc.test.pojo.BookDo;

public interface BookDao {
	/**
	 * 根据图书馆的Isbn,获得图书信息
	 * 
	 * @param isbn:查询图书的ISBN
	 * @return 如果没有这本书，返回null 否则返回该本书
	 */
	BookDo getBookByIsbn(String isbn);

//    根据书名title，返回包含书名title的图书列表
	// @param title
	// @return
	List<BookDo> listBooksByTitle(String title);

	// 按id，返回书的图书列表
	List<BookDo> listBooksByCagtegoryId(int id);

	List<BookDo> listbook();

}
