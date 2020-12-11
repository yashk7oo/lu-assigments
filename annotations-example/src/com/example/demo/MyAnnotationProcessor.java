package com.example.demo;
import com.example.demo.stereotypes.*;

public class MyAnnotationProcessor {

	public static void main(String[] args) {
		
		MyService obj = new MyService();
		Class cls= obj.getClass();
		
		MyBean bean = (MyBean)  cls.getAnnotation(MyBean.class);
		
		String objName = bean.name();
		System.out.println(objName);

		
		

	}

}
