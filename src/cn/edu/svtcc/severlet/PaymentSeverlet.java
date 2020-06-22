package cn.edu.svtcc.severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;

import cn.edu.svtcc.test.dao.Dao;
import cn.edu.svtcc.test.dao.Orderimpl;
import cn.edu.svtcc.test.pojo.OrderDao;
import cn.edu.svtcc.test.shoppingcar.ShoppingCart;
import cn.edu.svtcc.test.shoppingcar.shoppingItem;

/**
 * Servlet implementation class PaymentSeverlet
 */
@WebServlet("/PaymentSeverlet")
public class PaymentSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int keyId = 0;
	private List<OrderDao> orderdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.getWriter().append("Served at: ").append(request.getContextPath());
    				
    		doPost(request, response);
    	}

    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		String opt=request.getParameter("opt");
    		//跳转订单页面
    		if("dingdan".equals(opt)) {
    			payment(request,response);
    		}
    		//进行支付宝支付
    		if("zhifu".equals(opt)) {
    			zhifu(request,response);
    		}
    		//订单页面
    		if("order_page".equals(opt)) {
    			order_page(request,response);
    		}
    		//订单删除
    		if("order_del".equals(opt)) {
    			order_del(request,response);
    		}
    	}
    	private void order_del(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
    		JSONObject object=new JSONObject();
    		//得到订单书籍的isbn集合
    		String order=request.getParameter("id");
            Orderimpl dao=new Orderimpl();
            System.out.println(order);
            if(dao.del_order(order)) {
            	object.put("code", 1);
    			response.getWriter().write(JSON.toJSONString(object));
    			return;
            }else {
            	object.put("code", 3);
    			response.getWriter().write(JSON.toJSONString(object));
    			return;
			}
         }
		/**
		 * 显示所有订单
		 * @param request
		 * @param response
		 * @throws IOException
		 */
		private void order_page(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
			response.setContentType("text/html;charset=UTF-8");	
    		JSONObject object=new JSONObject();
    		String username=(String)request.getSession().getAttribute("name");
    		System.out.println(username);
    		if(username==null) {
    			object.put("code", 1);
    			response.getWriter().write(JSON.toJSONString(object));
    			return;
    		}else {
    			
    			Dao us=new Dao();
        		//得到用户id
        		int id=us.getuserId(username);
        		System.out.println(id);
        		//判断用户id是否存在
        		Orderimpl ord=new Orderimpl();
        		orderdao=ord.listUserOrder(id);
        		request.getSession().setAttribute("order_page", orderdao);
        		object.put("code", 2);
        		response.getWriter().write(JSON.toJSONString(object));
        		return;
    		}
		}

		/***
    	 * 确定支付
    	 * @param request
    	 * @param response
    	 */
    	@SuppressWarnings("unchecked")
    	private void zhifu(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    		// TODO Auto-generated method stub
    		//获得初始化的AlipayClient
    		response.setContentType("text/html;charset=UTF-8");
    		double a=0.0;
    		PrintWriter out=response.getWriter();
    		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
    		
    		//设置请求参数
    		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
    		alipayRequest.setReturnUrl(AlipayConfig.return_url);
    		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
    		
    		int keyIdd = (int) request.getSession().getAttribute("keyId");
    		System.out.println(keyIdd);
    		
    		Orderimpl dao=new Orderimpl();
    		
    		OrderDao myOrderDO = dao.getOrder(keyIdd);
    		
    		Double mm=myOrderDO.getTotalPrice();
    		
    		System.out.println(mm);
    		
    		List<shoppingItem> list = new ArrayList<>();
    		list = (List<shoppingItem>) request.getSession().getAttribute("order");
    		System.out.println(list);
    		//商户订单号，商户网站订单系统中唯一订单号，必填
    		String out_trade_no = new String(String.valueOf(keyIdd).getBytes("ISO-8859-1"),"UTF-8");
    		System.out.println(out_trade_no);
    		//付款金额，必填
    		String total_amount = new String(myOrderDO.getTotalPrice().toString().getBytes("ISO-8859-1"),"UTF-8");
    		System.out.println(total_amount);
    		//订单名称，必填
    		String subject = new String(list.get(0).getItem().getTitle().getBytes("ISO-8859-1"),"UTF-8");
    		//商品描述，可空
    		String body = new String(list.get(0).getItem().getTitle().getBytes("ISO-8859-1"),"UTF-8");
    		
    		
    		
    		/***
//    		//商户订单号，商户网站订单系统中唯一订单号，必填
    		String out_trade_no = new String("11");
    		//付款金额，必填
    		String total_amount = new String("80");
    		//订单名称，必填
    		String subject = new String("2015");
    		//商品描述，可空
    		String body = new String("w");*/
    		
    		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
    				+ "\"total_amount\":\""+ total_amount +"\"," 
    				+ "\"subject\":\""+ subject +"\"," 
    				+ "\"body\":\""+ body +"\"," 
    				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
    		
    		
    		//请求
    		String result = "";
    		try {
    			result = alipayClient.pageExecute(alipayRequest).getBody();
    		} catch (AlipayApiException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    		//输出
    		response.getWriter().println(result);	
    	}
    	/***
    	 * 跳转支付页面
    	 * @param request
    	 * @param response
    	 * @throws ServletException
    	 * @throws IOException
    	 */

    	private void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out=response.getWriter();
    		//创建json对象
    		JSONObject object=new JSONObject();
    		//得到订单书籍的isbn集合
    		String order=request.getParameter("order");
    		//得到用户名
    		String username=(String)request.getSession().getAttribute("name");
    		System.out.println(username);
    		//判断用户是否登录
    		if(username==null) {
    			object.put("code", 1);
    			response.getWriter().write(JSON.toJSONString(object));
    			return;
    		}
    		Dao us=new Dao();
    		//得到用户id
    		int id=us.getuserId(username);
    		System.out.println(id);
    		//判断用户id是否存在
    		if(id==5) {
    			object.put("code", 2);
    			response.getWriter().write(JSON.toJSONString(object));
    			return;
    		}
    		//将字符串转化为数组
    		JSONArray obj=JSON.parseArray(order);
    		List<shoppingItem>list=new ArrayList<>();
    		for(int i=0;i<obj.size();i++) {
    			String isbn=(String) obj.get(i);
    			shoppingItem item=ShoppingCart.getShoppingItem(isbn);
    			list.add(item);
    		}
    		Orderimpl orderimpl=new Orderimpl();
    		int mm=orderimpl.insertOrder(id, list);
    		if(mm>0) {
    			keyId=mm;
    			object.put("code", 100);
    			request.getSession().setAttribute("keyId", mm);
    			request.getSession().setAttribute("order", list);
    			response.getWriter().write(JSON.toJSONString(object));
    			//request.getRequestDispatcher("Order.jsp").forward(request, response);
    		}else{
    			object.put("code", 3);
    			response.getWriter().write(JSON.toJSONString(object));
    		}
    		}
    		
    	}

