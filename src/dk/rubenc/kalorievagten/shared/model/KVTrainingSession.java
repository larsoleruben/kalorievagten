package dk.rubenc.kalorievagten.shared.model;

import java.util.Date;

public interface KVTrainingSession {

	Date doneDate = null;
	String userID = null;
	String sessionId = null;
	int trainingType = 0;
	int totalTimeMin= 0;
	int maxTime=0;
	int atTime=0;
	int subAtTime=0;
	int baseTime=0;
	int powerNumber=0;
	int strengthTime = 0;
	float distance = 0;
	int energy = 0;
	String comments = null;
	String stringDoneDate = null;
	
	Date getDoneDate();
	void setDoneDate(Date doneDate);
	int getTrainingType();
	void setTrainingType(int trainingType);
	int getTotalTimeMin();
	void setTotalTimeMin( int totalTimeMin);
	int getMaxTime();
	void setMaxTime( int maxTime);
	int getAtTime();
	void setAtTime( int atTime);
	int getSubAtTime();
	void setSubAtTime( int subAtTime);
	int getPowerNumber();
	void setPowerNumber( int powerNumber);
	int getStrengthTime();
	void setStrengthTime( int strenghtTime);
	String getUserId();
	void setUserId( String userId);
	Long getSessionId();
	void setSessionId(Long sessionId);
	String getComments();
	void setComments( String comments);
	int getBaseTime();
	void setBaseTime( int baseTime);
	float getDistance();
	void setDistance( float distance);
	int getEnergy();
	void setEnergy( int energy );
	String getStringDoneDate();
	void setStringDoneDate( String stringDoneDate);
}
