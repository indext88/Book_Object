package cn.edu.svtcc.severlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.edu.svtcc.test.dao.PayBookimpl;
import cn.edu.svtcc.test.pojo.PayDao;

/**
 * Servlet implementation class AnPayBookSeverlet
 */
@WebServlet("/AnPayBookSeverlet")
public class AnPayBookSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnPayBookSeverlet() {
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
		String opt = request.getParameter("opt");
		// 购物车插入
		if ("Binsert".equals(opt)) {
			Binsert(request, response);
		}
		// 购物车查询
		if ("Bselect".equals(opt)) {
			Bselect(request, response);
		}
		// 购物车删除
		if ("Bdel".equals(opt)) {
			Bdel(request, response);
		}
		// 数量修改
		if ("Bupdat".equals(opt)) {
			Bupdat(request, response);
		}

	}

	/***
	 * 购物车数量修改
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	private void Bupdat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("Bname");
		String num = request.getParameter("num");
		String price = request.getParameter("Bprice");

		double pricee = Double.parseDouble(price);
		int numm = Integer.parseInt(num);

		double sumprice = numm * pricee;

		PayBookimpl pay = new PayBookimpl();
		pay.addnum(numm, sumprice, name);

	}

	/***
	 * 购物车物品删除
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void Bdel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("Bname");
		PayBookimpl pay = new PayBookimpl();
		JSONObject code = new JSONObject();
		pay.getTitl(name);
	}

	/***
	 * 购物车查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void Bselect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PayBookimpl pay = new PayBookimpl();
		List<PayDao> mm = pay.listPay();
		response.getWriter().write(JSON.toJSONString(mm));
	}

	/***
	 * 购物车插入
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void Binsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("Bname");
		System.out.println(name);

		String price = request.getParameter("Bprice");
		System.out.println(price);

		String num = request.getParameter("num");
		System.out.println(num);
//		
//		String name="M";
//		String price="18.5";
//		String num="15";

		int numm = Integer.parseInt(num);
		double pricee = Double.parseDouble(price);
		double sumprice = numm * pricee;

		JSONObject code = new JSONObject();
		PayBookimpl pay = new PayBookimpl();
		if (pay.Sname(name)) {
			code.put("code", "ok");
			response.getWriter().write(JSON.toJSONString(code));
			return;
		} else if (pay.Payinsert(name, numm, pricee, sumprice)) {
			code.put("code", "okk");
			response.getWriter().write(JSON.toJSONString(code));
			return;
		} else {
			code.put("code", "no");
			response.getWriter().write(JSON.toJSONString(code));
			return;
		}

	}

}
