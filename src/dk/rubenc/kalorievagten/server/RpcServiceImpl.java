package dk.rubenc.kalorievagten.server;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

import dk.rubenc.kalorievagten.EMF;
import dk.rubenc.kalorievagten.client.model.ConsumedDateCli;
import dk.rubenc.kalorievagten.client.model.IngreedientsCli;
import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.RpcService;
import dk.rubenc.kalorievagten.model.ConsumedDateSv;
import dk.rubenc.kalorievagten.model.IngreedientsSv;
import dk.rubenc.kalorievagten.model.KVTrainingSessionSv;
import dk.rubenc.kalorievagten.model.KalorieVagtenUserSv;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class RpcServiceImpl extends RemoteServiceServlet implements RpcService {

	public KalorieVagtenUser checkLogin() {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		String navBar;
		// KalorieVagtenUserSv.DeleteUsers();
		// KVTrainingSessionSv.deleteTrainingSession();
		if (user == null) {
			KalorieVagtenUser kUser = KalorieVagtenUser.getInstance();
			navBar = "<p><h3>Velkommen! <a href=\""
					+ userService.createLoginURL("/")
					+ "\">Log ind eller lav en google konto</a> for at bruge Kalorievagten</h3></p>";

			kUser.setLoggedIn(false);
			kUser.setLogInUrl(navBar);
			return kUser;
		} else {
			KalorieVagtenUserSv kvus = KalorieVagtenUserSv.getKVUser(user
					.getUserId());
			KalorieVagtenUser kUser = KalorieVagtenUser.getInstance();
			if (kvus == null) {
				kUser.setLoggedIn(true);
				kUser.setEmail(user.getEmail());
				kUser.setLogInUrl("Du er logget ind");
				kUser.setUserId(user.getUserId());
				return kUser;
			} else {
				kUser.setAddress(kvus.getAddress());
				kUser.setBmi(kvus.getBmi());
				kUser.setCity(kvus.getCity());
				kUser.setEmail(kvus.getEmail());
				kUser.setfName(kvus.getfName());
				kUser.setsName(kvus.getsName());
				kUser.setHeight(kvus.getHeight());
				kUser.setLoggedIn(true);
				kUser.setLogInUrl("Du er logget ind med din google account");
				kUser.setSex(kvus.getSex());
				kUser.setZipCode(kvus.getZipCode());
				kUser.setUserId(user.getUserId());
				kUser.setWeight(kvus.getWeight());
				kUser.setPressure(kvus.getPressure());
				kUser.setUnitEnergyIso(kvus.getUnitEnergyIso());
				kUser.setUnitEnergyKcal(kvus.getUnitEnergyKcal());
				return kUser;
			}
		}
	}

	public String saveUserCredentials(KalorieVagtenUser kvus) {
		if (kvus.isLoggedIn()) {
			KalorieVagtenUserSv kUser = new KalorieVagtenUserSv();
			kUser.setAddress(kvus.getAddress());
			kUser.setBmi(kvus.getBmi());
			kUser.setCity(kvus.getCity());
			kUser.setEmail(kvus.getEmail());
			kUser.setfName(kvus.getfName());
			kUser.setsName(kvus.getsName());
			kUser.setHeight(kvus.getHeight());
			kUser.setLoggedIn(true);
			kUser.setLogInUrl("Du er logget ind med din google account");
			kUser.setSex(kvus.getSex());
			kUser.setZipCode(kvus.getZipCode());
			kUser.setUserId(kvus.getUserId());
			kUser.setWeight(kvus.getWeight());
			kUser.setPressure(kvus.getPressure());
			kUser.setUnitEnergyIso(kvus.getUnitEnergyIso());
			kUser.setUnitEnergyKcal(kvus.getUnitEnergyKcal());
			kUser.save();
			return "Dine oplysninger er gemt";
		} else {
			return "Kunne ikke gemme dine oplysninger";
		}
	}

	public String saveTrainingSession(KVTrainingSessionCli kvt) {
		try {
			KVTrainingSessionSv kvts = new KVTrainingSessionSv();
			kvts.setAtTime(kvt.getAtTime());
			kvts.setDoneDate(KVUtilSV.getDate(kvt.getStringDoneDate()));
			kvts.setMaxTime(kvt.getMaxTime());
			kvts.setPowerNumber(kvt.getPowerNumber());
			kvts.setStrengthTime(kvt.getStrengthTime());
			kvts.setSubAtTime(kvt.getSubAtTime());
			kvts.setBaseTime(kvt.getBaseTime());
			kvts.setTotalTimeMin(kvt.getTotalTimeMin());
			kvts.setTrainingType(kvt.getTrainingType());
			kvts.setUserId(kvt.getUserId());
			kvts.setDistance(kvt.getDistance());
			kvts.setEnergy(kvt.getEnergy());
			kvts.setComments(kvt.getComments());
			kvts.setStringDoneDate(kvt.getStringDoneDate());
			kvts.save();
			return "Tr¾ning er gemt";
		} catch (ParseException pe) {
			return "Upps, kunne ikke gemme";
		}
	}
	
	public String updateTrainingSession(KVTrainingSessionCli kvt) {
		EntityManager em = EMF.get().createEntityManager();
		try {
			em.getTransaction().begin();
			KVTrainingSessionSv kvts =em.find(KVTrainingSessionSv.class, kvt.getSessionId());
			kvts.setAtTime(kvt.getAtTime());
			kvts.setDoneDate(KVUtilSV.getDate(kvt.getStringDoneDate()));
			kvts.setMaxTime(kvt.getMaxTime());
			kvts.setPowerNumber(kvt.getPowerNumber());
			kvts.setStrengthTime(kvt.getStrengthTime());
			kvts.setSubAtTime(kvt.getSubAtTime());
			kvts.setBaseTime(kvt.getBaseTime());
			kvts.setTotalTimeMin(kvt.getTotalTimeMin());
			kvts.setTrainingType(kvt.getTrainingType());
			kvts.setUserId(kvt.getUserId());
			kvts.setDistance(kvt.getDistance());
			kvts.setEnergy(kvt.getEnergy());
			kvts.setComments(kvt.getComments());
			kvts.setStringDoneDate(kvt.getStringDoneDate());
			em.getTransaction().commit();
			return "Tr¾ning er gemt !!!";
		} catch (ParseException pe) {
			return "Upps, kunne ikke gemme";
		}catch( Exception e ){
			return e.toString();
		}
	}

	public List<KVTrainingSessionCli> getSavedTrainingObjects(String dateFrom,
			String dateTo, String userId, int maxResults) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		EntityManager em = EMF.get().createEntityManager();
		ArrayList<KVTrainingSessionCli> al = new ArrayList<KVTrainingSessionCli>();
		try {
			Query query = em
					.createQuery("select b from KVTrainingSessionSv b where  doneDate <= :dateTo and doneDate >= :dateFrom and userID = :uid order by doneDate desc ");

			query.setParameter("dateTo", KVUtilSV.getDate(dateTo),
					TemporalType.DATE);
			query.setParameter("dateFrom", KVUtilSV.getDate(dateFrom),
					TemporalType.DATE);
			if (userId == null) {
				query.setParameter("uid", user.getUserId());
			} else {
				query.setParameter("uid", userId);
			}
			query.setMaxResults(maxResults);
			@SuppressWarnings("unchecked")
			List<KVTrainingSessionSv> results = (List<KVTrainingSessionSv>) query
					.getResultList();
			for (KVTrainingSessionSv kvs : results) {
				KVTrainingSessionCli cli = new KVTrainingSessionCli();
				cli.setAtTime(kvs.getAtTime());
				cli.setComments(kvs.getComments());
				cli.setDoneDate(kvs.getDoneDate());
				cli.setMaxTime(kvs.getMaxTime());
				cli.setPowerNumber(kvs.getPowerNumber());
				cli.setSessionId(kvs.getSessionId());
				cli.setStrengthTime(kvs.getStrengthTime());
				cli.setSubAtTime(kvs.getSubAtTime());
				cli.setTotalTimeMin(kvs.getTotalTimeMin());
				cli.setTrainingType(kvs.getTrainingType());
				cli.setUserId(kvs.getUserId());
				cli.setBaseTime(kvs.getBaseTime());
				cli.setDistance(kvs.getDistance());
				cli.setEnergy(kvs.getEnergy());
				cli.setStringDoneDate(kvs.getStringDoneDate());
				al.add(cli);
			}
		} catch (ParseException pe) {
			al = null;
		}
		return al;
	}

	public List getIngreedients(String ingreedientName, int maxResults) {
		ArrayList<IngreedientsCli> al = new ArrayList<IngreedientsCli>();
		EntityManager em = EMF.get().createEntityManager();
		try {
			//Query query = em
			//		.createQuery("select b from IngreedientsSv b where b.nameDanish >= :ingreedient");
			Query query = em.createQuery("select b from IngreedientsSv b where b.nameDanish >= :1 and b.nameDanish < :2");
			query.setMaxResults(maxResults);
			String firstLetter = ingreedientName.substring(0, 1);
			String rest = ingreedientName.substring(1);
			//query.setParameter("ingreedient", firstLetter.toUpperCase() + rest);
			query.setParameter("1", firstLetter.toUpperCase() + rest);
			query.setParameter("2", firstLetter.toUpperCase() + rest + "\ufffd");
			List<IngreedientsSv> results = (List<IngreedientsSv>) query
					.getResultList();
			for (IngreedientsSv ingSv : results) {
				IngreedientsCli ingCli = new IngreedientsCli();
				ingCli.setId(ingSv.getId());
				ingCli.setAlcohol(ingSv.getAlcohol());
				ingCli.setCalcium(ingCli.getCalcium());
				ingCli.setCarbonHydrate(ingSv.getCarbonHydrate());
				ingCli.setCholesterol(ingSv.getCholesterol());
				ingCli.setDietaryFibre(ingSv.getDietaryFibre());
				ingCli.setEnergy(ingSv.getEnergy());
				ingCli.setFat(ingSv.getFat());
				ingCli.setFolat(ingSv.getFolat());
				ingCli.setFructose(ingSv.getFructose());
				ingCli.setGlucose(ingSv.getGlucose());
				ingCli.setIodine(ingSv.getIodine());
				ingCli.setIron(ingSv.getIron());
				ingCli.setLactose(ingSv.getLactose());
				ingCli.setMagnesium(ingSv.getMagnesium());
				ingCli.setMaltose(ingSv.getMaltose());
				ingCli.setMonoSaturatedFattyAcid(ingSv
						.getMonoSaturatedFattyAcid());
				ingCli.setNameDanish(ingSv.getNameDanish());
				ingCli.setNameEnglish(ingSv.getNameEnglish());
				ingCli.setNatrium(ingSv.getNatrium());
				ingCli.setPhosphorus(ingSv.getPhosphorus());
				ingCli.setPolySaturatedFattyAcid(ingSv
						.getPolySaturatedFattyAcid());
				ingCli.setPotassium(ingSv.getPotassium());
				ingCli.setProtein(ingSv.getProtein());
				ingCli.setSaccharose(ingSv.getSaccharose());
				ingCli.setSaturatedFattyAcid(ingSv.getSaturatedFattyAcid());
				ingCli.setSelenium(ingSv.getSelenium());
				ingCli.setVitaminA(ingSv.getVitaminA());
				ingCli.setVitaminB1(ingSv.getVitaminB1());
				ingCli.setVitaminB12(ingSv.getVitaminB12());
				ingCli.setVitaminB2(ingSv.getVitaminB2());
				ingCli.setVitaminC(ingSv.getVitaminC());
				ingCli.setVitaminD(ingSv.getVitaminD());
				ingCli.setVitaminE(ingSv.getVitaminE());
				ingCli.setWater(ingSv.getWater());
				ingCli.setOrigId(ingSv.getId());  // here the Key from the database, becomes the originalID The other ID changes when saved with an object.
				al.add(ingCli);
			}
		} catch (Exception e) {
			System.out.println( e.toString());
			al = null;
		}
			return al;
	}

	public String saveConsumedDate( ConsumedDateCli cdc ){
		String err = null;
		EntityManager em = EMF.get().createEntityManager();
		//check if it is an update or if it is new 
		try
		{
			ConsumedDateSv cds = null;
			em.getTransaction().begin();
			ConsumedDateCli local = getConsumedDate( cdc.getStringDate());
			if( local == null ){
				cds = new ConsumedDateSv();
				cds.setConsumedDate(KVUtilSV.getDate(cdc.getStringDate()));
				cds.setConsumedList( KVUtilSV.linkedListToEmbeddableLinkeList(cdc.getConsumedList()));
				cds.setWeight(cdc.getWeight());
				cds.setUserId(cdc.getUserId());
				em.persist(cds);
				em.getTransaction().commit();
				em.close();
				return "Data gemt med succes";
			}else //udate the consumed list
			{
				cds = em.find(ConsumedDateSv.class, local.getId());
				//cds.setConsumedDate(KVUtilSV.getDate(cdc.getStringDate()));
				cds.setConsumedList(KVUtilSV.addListsToOneEmbeddableList(cdc.getConsumedList()));
				em.getTransaction().commit();
				em.close();
				return "Data updated med succes";
			}
		}catch(Exception e)
		{
			return e.toString();
		}
	}
	
    
	
	public ConsumedDateCli getConsumedDate(String date) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		EntityManager em = EMF.get().createEntityManager();
		ConsumedDateCli cdc = new ConsumedDateCli();
		Query query = em
		.createQuery("select b from ConsumedDateSv b where b.userId = :uid and b.consumedDate = :date");
		try{
			query.setParameter("uid", user.getUserId());
			query.setParameter("date", KVUtilSV.getDate(date));
			ConsumedDateSv cds = (ConsumedDateSv) query.getSingleResult();
			cdc.setConsumedDate(cds.getConsumedDate());
			cdc.setConsumedList(KVUtilSV.embeddableLinkeListToCli( cds.getConsumedList()));
			cdc.setId(cds.getId().getId());
			cdc.setUserId(cds.getUserId());
			cdc.setWeight(cds.getWeight());
		}catch(NoResultException e){
		  cdc = null;
		}catch( Exception e){
			cdc = null;
		}
		return cdc;
	}
}
