package top.inick.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	
	
	public static void main(String[] args) {
		//创建一个计时器对象
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println(new Date().toLocaleString());
			}
			
		}, 2000,1000);
	}
}
