package cn.edu.svtcc.test.interfacee;

import java.util.List;

import cn.edu.svtcc.test.pojo.BookDo;
import cn.edu.svtcc.test.service.PageBean;

public interface BookService {
	PageBean<BookDo>listBooksWithPage(int pageNum,int pageSize,List<BookDo>books);

}
