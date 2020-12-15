package com.training.services;

import com.training.model.CreditCard;
import java.util.*;
import java.util.function.Function;
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
	
	public Map<String,CreditCard> useFilterTransformToMap() {
		
		Function<CreditCard,CreditCard> valuePart = (card) -> {
			return new CreditCard(card.getCardNumber(),card.getCardHolderName(),card.getCreditLimit());
			
		};
		
		
	  // return cardList.stream().
			//	filter(element->element.getCreditLimit()>50000).
			//	collect(toMap(CreditCard::getCardHolderName,CreditCard::getCreditLimit));
				
				return cardList.stream().
				filter(element->element.getCreditLimit()>50000).
				collect(toMap(CreditCard::getCardHolderName,valuePart));
	}
	
	public List<CreditCard> sortedList() {
		return cardList.stream().sorted(Comparator.comparing(CreditCard::getCardHolderName))
				.collect(toList());
	}
	
	public double findMaxCreditLimit() {
		Optional<Double> maxValue= cardList.stream().map(element-> element.getCreditLimit())
				.max(Double::compareTo);
		
		if(maxValue.isPresent()) {
			return maxValue.get();
		} else {
			return 0;
		}
	}
}
