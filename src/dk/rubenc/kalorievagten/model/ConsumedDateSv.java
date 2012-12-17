package dk.rubenc.kalorievagten.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.appengine.api.datastore.Key;

@Entity(name = "ConsumedDateSv")
public class ConsumedDateSv implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Key id;
	
	@Temporal(TemporalType.DATE)
	Date consumedDate = null;
	@OneToMany(cascade=CascadeType.ALL)
	private LinkedList<IngreedientsSvEmbeddable> consumedList = new LinkedList<IngreedientsSvEmbeddable>();
	
	
	@Basic
	Double weight = null;
	@Basic
	String userId = null;
	
	public Key getId() { 
		return id;
	}
	public void setId(Key id) {
		this.id = id;
	}
	public Date getConsumedDate() {
		return consumedDate;
	}
	@OneToMany
	public void setConsumedDate(Date consumedDate) {
		this.consumedDate = consumedDate;
	}
	@OneToMany(cascade=CascadeType.ALL)
	public LinkedList<IngreedientsSvEmbeddable> getConsumedList() {
		return consumedList;
	}
	@OneToMany(cascade=CascadeType.ALL)
	public void setConsumedList(LinkedList<IngreedientsSvEmbeddable> consumedList) {
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
	
	public String toString(){
		return "I have been instantiated";
	}
	
	
}
