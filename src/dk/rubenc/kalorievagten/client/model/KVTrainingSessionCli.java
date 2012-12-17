package dk.rubenc.kalorievagten.client.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import dk.rubenc.kalorievagten.shared.model.KVTrainingSession;

public class KVTrainingSessionCli implements KVTrainingSession, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4429032858648453426L;
	Long sessionId = null;
	@Temporal(TemporalType.DATE)
	Date doneDate = null;
	String userID = null;
	int trainingType = 0;
	int totalTimeMin= 0;
	int maxTime=0;
	int atTime=0;
	int subAtTime=0;
	int baseTime = 0;
	int powerNumber=0;
	float distance = 0;
	int energy = 0;
	int strengthTime = 0;
	String comments = null;
	String stringDoneDate = null;
	
	
	
	
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

	@Override
	public String getComments() {
		return comments;
	}
	@Override
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the baseTime
	 */
	@Override
	public int getBaseTime() {
		return baseTime;
	}

	/**
	 * @param baseTime the baseTime to set
	 */
	@Override
	public void setBaseTime(int baseTime) {
		this.baseTime = baseTime;
	}

	/**
	 * @return the distance
	 */
	@Override
	public float getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	@Override
	public void setDistance(float distance) {
		this.distance = distance;
	}

	/**
	 * @return the energy
	 */
	public int getEnergy() {
		return energy;
	}

	/**
	 * @param energy the energy to set
	 */
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
