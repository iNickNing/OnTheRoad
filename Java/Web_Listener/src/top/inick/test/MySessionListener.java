package top.inick.test;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		//得到application对象中的list集合
		ServletContext application = session.getServletContext();
		//得到session,并存入list集合中
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("sessions");
		//创建计时器对象
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("开始扫描");
				for(Iterator<HttpSession> iterator = list.iterator();iterator.hasNext();) {
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000) {	//如果间隔事件大于5秒.则session销毁
						System.out.println("开始移除session:" + session.getId());
						session.invalidate();
						iterator.remove();
					}
				}
				
			}
		}, 1000, 5000);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {

	}

}
