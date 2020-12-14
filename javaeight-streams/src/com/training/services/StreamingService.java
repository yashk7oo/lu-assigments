package com.training.services;

import com.training.model.CreditCard;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamingService {
	
	private List<CreditCard> cardList;
	
	public StreamingService() {
		CreditCardService service = new CreditCardService();
		cardList=service.findAll();
	}

 	public List<CreditCard> useFilter() {
      return cardList.stream().filter(element->element.getCreditLimit()>50000).collect(toList());
}
	
	public List<String> useFilterAndMap() {
		return cardList.stream().
				filter(element->element.getCreditLimit()>50000).
				map(element->element.getCardHolderName()).collect(toList());
	}
	
	public Map<String,Double> useFilterTransformToMap() {
		return cardList.stream().
				filter(element->element.getCreditLimit()>50000).
				collect(toMap(CreditCard::getCardHolderName,CreditCard::getCreditLimit));
	}
}
