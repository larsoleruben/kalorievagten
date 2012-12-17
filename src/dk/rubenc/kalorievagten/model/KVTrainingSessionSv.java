package dk.rubenc.kalorievagten.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dk.rubenc.kalorievagten.EMF;
import dk.rubenc.kalorievagten.shared.model.KVTrainingSession;

@Entity(name = "KVTrainingSessionSv" )
public class KVTrainingSessionSv implements KVTrainingSession, Serializable {

	
	private static final long serialVersionUID = 389585302930762596L;
	
	@Temporal(TemporalType.DATE)
	Date doneDate = null;
	String userID = null;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long sessionId = null;
	int trainingType = 0;
	int totalTimeMin= 0;
	int maxTime=0;
	int atTime=0;
	int subAtTime=0;
	int powerNumber=0;
	int strengthTime = 0;
	int baseTime = 0;
	float distance = 0;
	int energy = 0;
	String comments;
	String stringDoneDate;
	
	
	public static KVTrainingSessionSv getKVTrainingSessionSv( String sessionId ){
		KVTrainingSessionSv kvus = null;
		EntityManager em = EMF.get().createEntityManager();
		try{
			
			kvus = em.find(KVTrainingSessionSv.class, sessionId);
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
	
	public static void deleteTrainingSession( ){
		EntityManager em = EMF.get().createEntityManager();
		Query query = em.createQuery("DELETE FROM KVTrainingSessionSv");
		query.executeUpdate();
	}
	
	
	
	@Override
	public Date getDoneDate() {
		return doneDate;
	}

	@Override
	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;

	}

	@Override
	public int getTrainingType() {
		return trainingType;
	}

	@Override
	public void setTrainingType(int trainingType) {
		this.trainingType = trainingType;
	}

	@Override
	public int getTotalTimeMin() {
		return totalTimeMin;
	}

	@Override
	public void setTotalTimeMin(int totalTimeMin) {
		this.totalTimeMin = totalTimeMin;

	}

	@Override
	public int getMaxTime() {
		return maxTime;
	}

	@Override
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	@Override
	public int getAtTime() {
		return atTime;
	}

	@Override
	public void setAtTime(int atTime) {
		this.atTime = atTime;
	}

	@Override
	public int getSubAtTime() {
		return subAtTime;
	}

	@Override
	public void setSubAtTime(int subAtTime) {
		this.subAtTime = subAtTime;
	}

	@Override
	public int getPowerNumber() {
		return powerNumber;
	}

	@Override
	public void setPowerNumber(int powerNumber) {
		this.powerNumber = powerNumber;
	}

	@Override
	public int getStrengthTime() {
		return strengthTime;
	}

	@Override
	public void setStrengthTime(int strenghtTime) {
		this.strengthTime = strenghtTime;
	}

	@Override
	public String getUserId() {
		return userID;
	}

	@Override
	public void setUserId(String userId) {
		this.userID = userId;
	}

	@Override
	public Long getSessionId() {
		return sessionId;
	}

	@Override
	public void setSessionId( Long sessionId) {
		this.sessionId = sessionId;
	}


	/**
	 * @return the comments
	 */
	@Override
	public String getComments() {
		return comments;
	}


	/**
	 * @param comments the comments to set
	 */
	@Override
	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public int getBaseTime() {
			return baseTime;
	}


	@Override
	public void setBaseTime(int baseTime) {
		this.baseTime = baseTime;
	}


	@Override
	public float getDistance() {
		return distance;
	}


	@Override
	public void setDistance(float distance) {
		this.distance = distance;
	}


	@Override
	public int getEnergy() {
		return energy;
	}


	@Override
	public void setEnergy(int energy) {
		this.energy = energy;
	}

	@Override
	public String getStringDoneDate() {
		return stringDoneDate;
	}

	@Override
	public void setStringDoneDate(String stringDoneDate) {
		this.stringDoneDate = stringDoneDate;
		
	}
}
