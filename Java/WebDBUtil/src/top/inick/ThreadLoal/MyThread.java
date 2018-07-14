package top.inick.ThreadLoal;

public class MyThread extends Thread {
	ThreadLocal tl = new ThreadLocal();
	
	public MyThread(ThreadLocal tl) {
		this.tl = tl;
	}
	
	@Override
	public void run() {
		System.out.println(tl.get() + "aaaaaaaaaaaaaaa");
	}
}
