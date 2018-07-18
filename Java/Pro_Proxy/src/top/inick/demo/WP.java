package top.inick.demo;

public class WP implements KindWomen {

	private KindWomen kw;
	
	public WP(KindWomen kw) {
		this.kw = kw;
	}
	
	public void throwEye(double money) {
		this.kw.throwEye(money);
	}

	public void doSomething() {
		this.kw.doSomething();
	}

}
