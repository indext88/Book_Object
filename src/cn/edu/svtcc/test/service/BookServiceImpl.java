package cn.edu.svtcc.test.service;

import java.util.ArrayList;
import java.util.List;

import cn.edu.svtcc.test.dao.BookDaoimpl;
import cn.edu.svtcc.test.interfacee.BookDao;
import cn.edu.svtcc.test.interfacee.BookService;
import cn.edu.svtcc.test.pojo.BookDo;

public class BookServiceImpl implements BookService {
	List<BookDo> books;
	BookDao bDao;

	public BookServiceImpl() {
		// TODO Auto-generated constructor stub
		bDao = new BookDaoimpl();
	}

	/**
	 * 按书名查询图书
	 * 
	 * @param title
	 * @return
	 */
	public List<BookDo> listBooksByTitle(String title) {
		books = bDao.listBooksByTitle(title);
		return books;
	}

	/**
	 * 按图书编号查询图书
	 * 
	 * @param id
	 * @return
	 */
	public List<BookDo> listBooksByCagtegoryId(int id) {
		books = bDao.listBooksByCagtegoryId(id);
		return books;
	}

	/**
	 * 根据ISBN查询图书
	 * 
	 * @param isbn
	 * @return
	 */
	public BookDo getBookByIsbn(String isbn) {
		return bDao.getBookByIsbn(isbn);
	}

	public List<BookDo> listBook() {
		// TODO Auto-generated method stub
		return bDao.listbook();
	}

//	public List<BookDo>getBookByIsbn(String isbn) {
//		return  bDao.getBookByIsbn(isbn);
//	}

	@Override
	public PageBean<BookDo> listBooksWithPage(int pageNum, int pageSize, List<BookDo> books) {
		// TODO Auto-generated method stub

		int totalRecord = books.size();
		PageBean<BookDo> pBean = new PageBean<BookDo>(pageNum, pageSize, totalRecord, books);
		int startIndex = pBean.getStartIndex();
		List<BookDo> datas = new ArrayList<BookDo>();
		if (books.size() > pageSize) {
			for (int i = 0; i < pageSize && startIndex + i < pBean.getTotalRecord(); i++) {
				datas.add(books.get(startIndex + i));
			}
			pBean.setDatas(datas);
		} else {
			pBean.setDatas(books);
		}
		return pBean;
	}

}
