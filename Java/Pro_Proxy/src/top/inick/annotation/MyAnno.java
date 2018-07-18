package top.inick.annotation;

public @interface MyAnno {
	
	//注解的属性, 
	int age() default 0;
	
	String name() default "";
	
	String sex() default "";
	
	//String value();
	
	String[] value();
	
}
