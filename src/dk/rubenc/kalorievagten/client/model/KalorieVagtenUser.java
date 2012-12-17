/**
 * 
 */
package dk.rubenc.kalorievagten.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import dk.rubenc.kalorievagten.shared.model.KVUser;


/**
 * @author laoch
 *
 */

public class KalorieVagtenUser implements IsSerializable, KVUser  {
	
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
	private String userId;
	private boolean unitEnergyKcal;
	private boolean unitEnergyIso;
	private double weight;
	private double pressure;
	
	
	private KalorieVagtenUser(){}
	
	/**
	    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
	    * or the first access to SingletonHolder.INSTANCE, not before.
	*/

	private static class UserHolder { 
	     public static final KalorieVagtenUser INSTANCE = new KalorieVagtenUser();
	}
	
	public static KalorieVagtenUser getInstance() {
	     return UserHolder.INSTANCE;
	   }

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getLogInUrl() {
		return logInUrl;
	}

	public void setLogInUrl(String logInUrl) {
		this.logInUrl = logInUrl;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
		
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
