/**
 * 
 */
package dk.rubenc.kalorievagten.model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;

import com.google.gwt.user.client.rpc.IsSerializable;

import dk.rubenc.kalorievagten.EMF;
import dk.rubenc.kalorievagten.shared.model.KVUser;


/**
 * @author laoch
 *
 */
@Entity( name = "KalorieVagtenUserSv")
public class KalorieVagtenUserSv implements IsSerializable, KVUser  {
	

		
	@Id 
	private String userID;
	private boolean loggedIn = false;
	private String logInUrl;
	private String email;
	private String fName;
	private String sName;
	private String city;
	private String address;
	private String zipCode;
	private int sex = 0;
	private double bmi = 0;
	private double height = 0;
	private boolean unitEnergyKcal;
	private boolean unitEnergyIso;
	private double weight;
	private double pressure;
	
	
	public static KalorieVagtenUserSv getKVUser( String userID ){
		KalorieVagtenUserSv kvus = null;
		EntityManager em = EMF.get().createEntityManager();
		try{
			kvus = em.find(KalorieVagtenUserSv.class, userID);
			//if( kvus == null ){
			//	kvus = new KalorieVagtenUserSv();
			//}
		}catch( NullPointerException e){
			
		}
		finally{
			em.close();
		}
		return kvus;
	}
	
	
	public void save(){
		EntityManager em = EMF.get().createEntityManager();
		try{
			em.persist(this);
		}finally{
			em.close();
		}
	}
	
	public static void DeleteUsers( ){
		EntityManager em = EMF.get().createEntityManager();
		Query query = em.createQuery("DELETE FROM KalorieVagtenUserSv");
		query.executeUpdate();
	}

	


	@Override
	public boolean isLoggedIn() {
		return loggedIn;
	}

	@Override
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
		
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getfName() {
		return fName;
	}

	@Override
	public void setfName(String fName) {
		this.fName = fName;
		
	}

	@Override
	public String getsName() {
		return sName;
	}

	@Override
	public void setsName(String sName) {
		this.sName = sName; 
		
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
		
	}

	public String getLogInUrl() {
		return logInUrl;
	}

	public void setLogInUrl(String logInUrl) {
		this.logInUrl = logInUrl;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getUserId() {
		return userID;
	}

	public void setUserId(String userID) {
		this.userID = userID;
	}


	@Override
	public void setWeight(double weight) {
		this.weight = weight;
		
	}


	@Override
	public double getWeight() {
		return weight;
	}


	@Override
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}


	@Override
	public double getPressure() {
		return pressure;
	}


	@Override
	public void setUnitEnergyIso(boolean unitEnergyIso) {
		this.unitEnergyIso = unitEnergyIso;
	}


	@Override
	public boolean getUnitEnergyIso() {
		return unitEnergyIso;
	}


	@Override
	public void setUnitEnergyKcal(boolean unitEnergyKcal) {
		this.unitEnergyKcal=unitEnergyKcal;
	}


	@Override
	public boolean getUnitEnergyKcal() {
		return unitEnergyKcal;
	}

	
}
