package cn.edu.svtcc.severlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import cn.edu.svtcc.test.dao.BookDaoimpl;
import cn.edu.svtcc.test.pojo.BookDo;
import cn.edu.svtcc.test.shoppingcar.ShoppingCart;
import cn.edu.svtcc.test.shoppingcar.shoppingItem;

/**
 * Servlet implementation class shoppingSevelet
 */
@WebServlet("/shoppingSevelet")
public class shoppingSevelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public shoppingSevelet() {
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

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 如果opt为 add:添加购物车 showcart:查看购物车 del:删除 clear:清空 update:修改数量 buy:确定添加
		 */
		String opt = request.getParameter("opt");
		// 添加图书到购物车
		if ("add".equals(opt)) {
			addCart(request, response);
		}
		// 查看购物车
		if ("showcart".equals(opt)) {
			showcart(request, response);
		}
		// 删除图书
		if ("del".equals(opt)) {
			delCart(request, response);
		}
		// 添加到购物车
		if ("buy".equals(opt)) {
			buy(request, response);
		}
		// 清空购物车
		if ("clear".equals(opt)) {
			clearCart(request, response);

		}
		// 修改数量
		if ("jia".equals(opt)) {
			jia(request,response);
		}
		if("jian".equals(opt)) {
			jian(request,response);
		}

	}
	
	/***
	 * 修改数量的减
	 * @param request
	 * @param response
	 */
	private void jian(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String isbn=request.getParameter("isbn");
		System.out.println(isbn);
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.jian(isbn);
	}

	/***
	 * 修改图书的数量的加
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void jia(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String isbn = request.getParameter("isbn");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		cart.jia(isbn);
		}
	/***
	 * 清空购物车
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (cart != null) {
			cart.clear();
			Collection<shoppingItem> siCollection = cart.getItems();
			session.setAttribute("collection", siCollection);
			double total = cart.getTotalReal();
			session.setAttribute("totaReal", total);
		}
		response.sendRedirect("web-page/showcart.jsp");
		
	}

	/***
	 * 删除指定的书籍
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	private void delCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String isbn = request.getParameter("isbn");
		HttpSession session = request.getSession();
		if (!"".equals(isbn) && isbn != null) {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			if (cart != null) {
				cart.del(isbn);
				Collection<shoppingItem> siCollection = cart.getItems();
				session.setAttribute("collection", siCollection);
				double total = cart.getTotalReal();
				session.setAttribute("totaReal", total);
			}
			response.sendRedirect("web-page/showcart.jsp");
		}

	}

	/***
	 * 
	 * 确定添加购物车
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	private void buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// 获得数量
		String numString = request.getParameter("num");
		BookDo book = (BookDo) request.getSession().getAttribute("blist");
		if (!"".equals(numString)) {
			int num = Integer.parseInt(numString);
			// 从session里获取购物车对象
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			if (cart == null) {
				cart = new ShoppingCart();
			}
			// 把图书添加到购物车
			cart.add(book, num);
			request.getSession().setAttribute("cart", cart);
		}
		// 页面跳转到index页面
		response.sendRedirect("web-page/add.jsp");

	}

	/**
	 * 添加图书到购物车
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void showcart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		if (cart != null) {
			Collection<shoppingItem> siCollection = cart.getItems();
			session.setAttribute("collection", siCollection);
			double total = cart.getTotalReal();
			session.setAttribute("totaReal", total);
		}
		response.sendRedirect("web-page/showcart.jsp");

	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String isbn = request.getParameter("isbn");
		if (!"".equals(isbn) && isbn != null) {
			BookDaoimpl dao = new BookDaoimpl();
			BookDo blist = dao.getBookByIsbn(isbn);
			if (blist != null) {
				request.getSession().setAttribute("blist", blist);
				response.sendRedirect("web-page/add.jsp");
			}

		} else {
			response.sendRedirect("web-page/index.jsp");
		}

	}

}
