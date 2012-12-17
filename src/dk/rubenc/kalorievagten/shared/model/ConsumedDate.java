package dk.rubenc.kalorievagten.shared.model;

import java.util.Date;
import java.util.LinkedList;


import dk.rubenc.kalorievagten.client.model.IngreedientsCli;

public interface ConsumedDate {

	Date consumedDate = null;
	LinkedList<IngreedientsCli> consumedList = null;
	Double weight = null;
	String userId =  null;
	
	void setConsumedDate(Date consumedDate );
	Date getConsumedDate();
	void setConsumedList( LinkedList<IngreedientsCli> consumedList);
	LinkedList<IngreedientsCli> getConsumedList();
    void setWeight(Double weight);
    Double getWeight();
    void setUserId(String userId);
    String getUserId();
	
}
