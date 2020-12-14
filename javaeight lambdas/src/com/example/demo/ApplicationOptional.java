package com.example.demo;
import java.util.Optional;
public class ApplicationOptional {
	
	public static String getString(int i) {
		return i<10?null:"hello";
	}

	public static void main(String[] args) {
	
		
		Optional<String> optional = Optional.ofNullable(getString(12));
		
		if(optional.isPresent()) {
			System.out.println(optional.get());
			
		} else {
			System.out.println("Invalid value- should be greater than 10");
		}
		
		optional.ifPresent(System.out::println);
		
		optional.orElseThrow(RuntimeException::new);

	}

}
