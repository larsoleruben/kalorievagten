/**
 * 
 */
package dk.rubenc.kalorievagten.shared.model;


/**
 * @author laoch
 *
 */
public interface KVUser {

	boolean loggedIn = false;
	String logInUrl = null;
	String email = null;
	String fName = null;
	String sName = null;
	String city = null;
	String address = null;
	String zipCode = null;
	String userId = null;
	int sex = 0;
	double bmi = 0;
	double height = 0;
	double weight = 0;
	boolean unitEnergyIso = true;
	boolean unitEnergyKcal = false;
	double pressure = 0;
	
	
	public void setWeight( double weight);
	
	public double getWeight();
	
	public void setPressure( double pressure);
	
	public double getPressure();
	
	public void setUnitEnergyIso( boolean unitEnergyIso);
	
	public boolean getUnitEnergyIso();
	
    public void setUnitEnergyKcal( boolean unitEnergyKcal);
	
	public boolean getUnitEnergyKcal();
	
	public boolean isLoggedIn();

	public void setLoggedIn(boolean loggedIn);

	public String getEmail();

	public void setEmail(String email);

	public String getfName();

	public void setfName(String fName);

	public String getsName();

	public void setsName(String sName);

	public String getCity();

	public void setCity(String city);

	public String getAddress();

	public void setAddress(String address);

	public String getZipCode();

	public void setZipCode(String zipCode);

	public int getSex();

	public void setSex(int sex);

	public double getBmi();

	public void setBmi(double bmi);

	public double getHeight();

	public void setHeight(double height);

	public String getLogInUrl();

	public void setLogInUrl(String logInUrl);
	
	public String getUserId();
	
	public void setUserId(  String userId );
}
