package cn.edu.svtcc.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.svtcc.test.interfacee.BookService;
import cn.edu.svtcc.test.pojo.BookDo;
import cn.edu.svtcc.test.service.BookServiceImpl;
import cn.edu.svtcc.test.service.PageBean;

/**
 * Servlet implementation class BookSeverlet
 */
@WebServlet(value = { "/BookSeverlet", "/bookSeverlet" }, loadOnStartup = 1)
public class BookSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BookDo> books;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookSeverlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt = request.getParameter("opt");
		// 搜索书名
		if ("tname".equals(opt)) {
			title(request, response);
		}
		// 按照id查询
		if ("byCategory".equals(opt)) {
			listBooksByCagtegory(request, response);
		}
		// 分页
		if ("withPage".equals(opt)) {
			listBooksWithPage(request, response);
		}
		// 主页查询
		if ("title_a".equals(opt)) {
			title_a(request, response);
		}
		// 查询所有图书
		if ("book_all".equals(opt)) {
			book_all(request, response);
		}
		if ("titl_b".equals(opt)) {
			title_b(request, response);
		}

	}

	/***
	 * 搜索图书Android
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void title_b(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String tt = request.getParameter("tname");
		BookServiceImpl bService = new BookServiceImpl();
		books = bService.listBooksByTitle(tt);
		response.getWriter().write(JSON.toJSONString(books));
	}

	/***
	 * 安卓端查询所有图书
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void book_all(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		BookServiceImpl bService = new BookServiceImpl();
		books = bService.listBook();
		// 通过dao调用listBookByTitle,返回图书列表blist

		PageBean<BookDo> pbBooks = bService.listBooksWithPage(1, 15, books);
		response.getWriter().write(JSON.toJSONString(books));
		// 跳转
//		Gson gson=new Gson();
//		String gs=gson.toJson(pbBooks);
//		response.getWriter().write(gs);
	}

	/**
	 * 通过获取图书id查询图书种类
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listBooksByCagtegory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		response.setContentType("text/html;charset=UTF-8");
		String cid = request.getParameter("cid");
		int id = Integer.parseInt(cid);
		BookServiceImpl bService = new BookServiceImpl();
		books = bService.listBooksByCagtegoryId(id);
		// 通过dao调用listBookByTitle,返回图书列表blist

		PageBean<BookDo> pbBooks = bService.listBooksWithPage(1, 15, books);
		request.getSession().setAttribute("blist", pbBooks);
		// 跳转页面
		response.sendRedirect("web-page/book_query.jsp");
	}

	private void title(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求参数
		response.setContentType("text/html;charset=UTF-8");
		String tt = request.getParameter("tname");
		if (tt != null && !("".equals(tt))) {
//		//创建一个BookDaoimpl的对象dao
//		BookDaoimpl dao=new BookDaoimpl();
//		//通过dao调用listBooksByTitle,返回图书列表blist
//		List<BookDo> blist=dao.listBooksByTitle(tt);
			// 创建一个HttpSession的对象并且把blist放入集合中

			BookServiceImpl bService = new BookServiceImpl();
			books = bService.listBooksByTitle(tt);
			// 通过dao调用listBookByTitle,返回图书列表blist
			PageBean<BookDo> pbBooks = bService.listBooksWithPage(1, 15, books);
			// 创建一个HttpSession的对象
			request.getSession().setAttribute("blist", pbBooks);
			// 跳转页面
			response.sendRedirect("web-page/book_query.jsp");
		}
	}

	private void listBooksWithPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNumString = request.getParameter("pageNum");
		int pageNum = 1;
		if ("".equals(pageNumString)) {
			pageNum = 1;
		}
		pageNum = Integer.parseInt(pageNumString);
		BookService bService = new BookServiceImpl();
		// 通过dao调用listBooksBytitle,返回图书列表
		PageBean<BookDo> pbBooks = bService.listBooksWithPage(pageNum, 15, books);
		request.getSession().setAttribute("blist", pbBooks);
		// 跳转页面
		response.sendRedirect("web-page/book_query.jsp");
	}

	private void title_a(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		response.setContentType("text/html;charset=UTF-8");
//		//创建一个BookDaoimpl的对象dao
//		BookDaoimpl dao=new BookDaoimpl();
//		//通过dao调用listBooksByTitle,返回图书列表blist
//		List<BookDo> blist=dao.listBooksByTitle(tt);
		// 创建一个HttpSession的对象并且把blist放入集合中

		BookServiceImpl bService = new BookServiceImpl();
		books = bService.listBooksByTitle("C");
		// 通过dao调用listBookByTitle,返回图书列表blist

		PageBean<BookDo> pbBooks = bService.listBooksWithPage(1, 10, books);
		// 创建一个HttpSession的对象
		request.getSession().setAttribute("blist", pbBooks);
		// 跳转页面
		response.sendRedirect("web-page/index.jsp");
	}

}
