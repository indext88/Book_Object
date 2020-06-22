package cn.edu.svtcc.severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.svtcc.test.dao.BookDaoimpl;
import cn.edu.svtcc.test.dao.Dao;
import cn.edu.svtcc.test.interfacee.BookDao;
import cn.edu.svtcc.test.pojo.BookDo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Servlet implementation class telSeverlet
 */
//urlPatterns={"/telSeverlet","/TelSeverlet"}可以匹配{}中的任意一个都行
@WebServlet(urlPatterns={"/HomePageSeverlet","/homepageseverlet"})
public class HomePageSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取opt的值
		String opt=request.getParameter("opt");
		if("tel".equals(opt)) {
			tel(request, response);
		}
		if("zuce".equals(opt)) {
			zuce(request, response);
		}
		if("zuce_b".equals(opt)) {
			zuceTest(request,response);
		}
		if("zuce_c".equals(opt)) {
			zuce_c(request,response);
		}
	}
	/***
	 * 安卓端的注册信息
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void zuce_c(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String loginId=request.getParameter("loginId");
		String loginPwd=request.getParameter("loginPwd");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String mail=request.getParameter("mail");
		String address=request.getParameter("address");
		Dao dao=new Dao();
		JSONObject code = new JSONObject();
		if (dao.zuce_b(loginId)) {
			code.put("code", "no");
			response.getWriter().write(JSON.toJSONString(code));
			return;
		}
		boolean result=dao.addusers(loginId, loginPwd, name, phone, mail, address);
		if(result) {
			code.put("code", "ok");
			response.getWriter().write(JSON.toJSONString(code));
			return;
		}else {
			code.put("code", "non");
			response.getWriter().write(JSON.toJSONString(code));
			return;
		}
		
		
	}

	private void zuceTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		// 获得请求参数
		String userName = request.getParameter("name");
		System.out.println(userName);
		// 调用登录方法 判断用户是否存在 并跳转
		Dao dao = new Dao();
		if (dao.zuce_b(userName)) {
			// 为session添加属性并赋值
			JSONObject code = new JSONObject();
			code.put("code", "ok");
			// 跳转
			response.getWriter().write(JSON.toJSONString(code));
			//response.sendRedirect("Welcome.jsp");
		} else {
			response.getWriter().write(JSON.toJSONString("{code:error}"));
		}
		
	}

	private void tel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		//获取输入框的内容并赋值给name和password
		String name=request.getParameter("Uname");
		String password=request.getParameter("pwdd");
		//调用Dao中的tel()方法
		Dao dao=new Dao();
		boolean result=dao.tel(name,password);
		
		//3.根据返回值实现页面跳转
		if(result) {						
			session.setAttribute("name",request.getParameter("Uname"));
			JSONObject code = new JSONObject();
			code.put("code", "ok");
			// 跳转
			response.getWriter().write(JSON.toJSONString(code));
		} else {
			JSONObject code = new JSONObject();
			code.put("code", "no");
			// 跳转
			response.getWriter().write(JSON.toJSONString(code));
			//response.getWriter().write(JSON.toJSONString("{code:error}"));
		}
	}
	
	
	private void zuce(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String loginId=request.getParameter("loginId");
		String loginPwd=request.getParameter("loginPwd");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String mail=request.getParameter("mail");
		String address=request.getParameter("address");
		
		Dao dao=new Dao();
		boolean result=dao.addusers(loginId, loginPwd, name, phone, mail, address);
		
		if(result) {
			out.print("<script language='javaScript'> alert('注册成功');</script>");
			response.setHeader("refresh", "0.5;url=web-page/tel.jsp");
		}else {
			 
			 out.print("<script language='javaScript'> alert('注册失败!!输入框为空或用户已经注册');</script>");
			 response.setHeader("refresh", "0;url=web-page/zuce.jsp");
		
		}
		
	}
	
}
