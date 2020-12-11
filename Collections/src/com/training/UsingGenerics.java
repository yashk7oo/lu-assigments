package com.training;
import java.io.PushbackReader;
import java.util.*;

import com.training.model.*;
import com.training.services.*;

public class UsingGenerics {
	
	public static void pushAndPull(List<? super Product> list,Product prod) {
		
		list.add(prod);
		list.get(1);
		
	}
	
public static void onlyPullNotPush(List<? extends ElectronicProduct> list,Product prod) {
		
		list.get(1);
		
	}
	
	
	
	
	public static void main(String args[]) {
		
		CatalogService service = new CatalogService();
		
		Product panner = new FoodProduct(1010,"panner",20.00);
		Product tv2 = new ElectronicProduct(4848,"Sony LED",45000,24);
			
		service.add(tv2);
		service.add(panner);
		
		List<Product> list= service.getAll();
		List<ElectronicProduct> list2=new ArrayList<>();
		pushAndPull(list, tv2);
		System.out.println(list);
		onlyPullNotPush(list2, tv2);
		
		
	}

}
