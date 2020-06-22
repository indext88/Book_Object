package cn.edu.svtcc.test.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineNumbersListener
 *
 */
@WebListener
public class OnlineNumbersListener implements HttpSessionListener {
	private Integer counter;

	/**
	 * Default constructor.
	 */
	public OnlineNumbersListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */

	public void sessionCreated(HttpSessionEvent evt) {
		// 设置间隔时间为10单位秒
		evt.getSession().setMaxInactiveInterval(1000);
		// TODO Auto-generated method stub
		if (counter == null) {
			counter = new Integer(0);
		}
		counter = new Integer(counter.intValue() + 1);
		// 将在线人数保存到onlineNums中
		evt.getSession().getServletContext().setAttribute("onlineNums", counter);
		// 测试其生命周期的时间
		System.out.println("sessinCreated");
		System.out.println("time:" + evt.getSession().getMaxInactiveInterval());

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent evt) {
		// TODO Auto-generated method stub
		if (counter != null && counter.intValue() > 0) {
			counter = new Integer(counter.intValue() - 1);
			// 将在线人数保存到onlineNums中
			evt.getSession().getServletContext().setAttribute("onlineNums", counter);
		}
		System.out.println("sessionDestroyed");
		System.out.println("time:" + evt.getSession().getMaxInactiveInterval());
	}

}
