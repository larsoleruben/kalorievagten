package dk.rubenc.kalorievagten.client.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.Embeddable;

import dk.rubenc.kalorievagten.shared.model.ConsumedDate;

public class ConsumedDateCli implements ConsumedDate, Serializable{

	private Long id = null;
	Date consumedDate = null;
	LinkedList<IngreedientsCli> consumedList = new LinkedList();
	Double weight = null;
	String userId = null;
	String stringDate = null;
	
	public Long getId() { 
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getConsumedDate() {
		return consumedDate;
	}
	public void setConsumedDate(Date consumedDate) {
		this.consumedDate = consumedDate;
	}
	public LinkedList<IngreedientsCli> getConsumedList() {
		return consumedList;
	}
	public void setConsumedList(LinkedList<IngreedientsCli> consumedList) {
		this.consumedList = consumedList;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStringDate() {
		return stringDate;
	}
	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}
	
}
