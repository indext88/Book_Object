package cn.edu.svtcc.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.svtcc.test.dao.CategoriesDaoimpl;
import cn.edu.svtcc.test.pojo.BookDo;
import cn.edu.svtcc.test.pojo.CategoriesDo;
import cn.edu.svtcc.test.service.BookServiceImpl;
import cn.edu.svtcc.test.service.PageBean;

/**
 * Servlet implementation class InitSeverlet 设置启动时加载： loadOnStartup=大于一的数
 */
@WebServlet(value = { "/InitSeverlet" }, loadOnStartup = 1)
public class InitSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitSeverlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		BookServiceImpl bService = new BookServiceImpl();
		List<BookDo> books = bService.listBooksByTitle("C");
		// 通过dao调用listBookByTitle,返回图书列表blist
		PageBean<BookDo> pbBooks = bService.listBooksWithPage(1, 10, books);
		// 创建一个HttpSession的对象
		config.getServletContext().setAttribute("Booklist", pbBooks);
		CategoriesDaoimpl cataDao = new CategoriesDaoimpl();
		List<CategoriesDo> categories = cataDao.listCategories();
		config.getServletContext().setAttribute("categories", categories);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("web-page/index.jsp");
	}

}
