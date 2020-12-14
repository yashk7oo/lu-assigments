package com.example.demo.services.ifaces;

public interface Calculate<T,R> {
	R apply(T t);
	
	default double offer() {
		return 2.0;
	}

}
