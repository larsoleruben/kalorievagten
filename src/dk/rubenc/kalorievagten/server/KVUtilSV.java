package dk.rubenc.kalorievagten.server;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

import dk.rubenc.kalorievagten.client.model.IngreedientsCli;
import dk.rubenc.kalorievagten.model.IngreedientsSvEmbeddable;

public class KVUtilSV {

	public static Date getDate(String date) throws ParseException {
		Locale locale = new Locale("da");
		Date dateOBject = null;
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		dateOBject = df.parse(date);
		return dateOBject;
	}
	
	//Overs¾tte fra client object til server object. Eller kan det ikke gemmes
	public static IngreedientsSvEmbeddable ingredientCliToSvEmbeddable(IngreedientsCli ic ){
		IngreedientsSvEmbeddable iv = new IngreedientsSvEmbeddable();
		iv.setAlcohol(ic.getAlcohol());
		iv.setCalcium(ic.getCalcium());
		iv.setCarbonHydrate(ic.getCarbonHydrate());
		iv.setCholesterol(ic.getCholesterol());
		iv.setDietaryFibre(ic.getDietaryFibre());
		iv.setEnergy(ic.getEnergy());
		iv.setFat(ic.getFat());
		iv.setFolat(ic.getFolat());
		iv.setFructose(ic.getFructose());
		iv.setGlucose(ic.getGlucose());
		iv.setGrams(ic.getGrams());
		//iv.setId(ic.getId());
		iv.setIodine(ic.getIodine());
		iv.setIron(ic.getIron());
		iv.setLactose(ic.getLactose());
		iv.setMagnesium(ic.getMagnesium());
		iv.setMaltose(ic.getMaltose());
		iv.setMonoSaturatedFattyAcid(ic.getMonoSaturatedFattyAcid());
		iv.setNameDanish(ic.getNameDanish());
		iv.setNameEnglish(ic.getNameEnglish());
		iv.setNatrium(ic.getNatrium());
		iv.setPhosphorus(ic.getPhosphorus());
		iv.setPolySaturatedFattyAcid(ic.getPolySaturatedFattyAcid());
		iv.setPotassium(ic.getPotassium());
		iv.setProtein(ic.getProtein());
		iv.setSaccharose(ic.getSaccharose());
		iv.setSaturatedFattyAcid(ic.getSaturatedFattyAcid());
		iv.setSelenium(ic.getSelenium());
		iv.setVitaminA(ic.getVitaminA());
		iv.setVitaminB1(ic.getVitaminB1());
		iv.setVitaminB12(ic.getVitaminB12());
		iv.setVitaminB2(ic.getVitaminB2());
		iv.setVitaminC(ic.getVitaminC());
		iv.setVitaminD(ic.getVitaminD());
		iv.setVitaminE(ic.getVitaminE());
		iv.setWater(ic.getWater());
		iv.setOrigId(ic.getOrigId());
		return iv;
	}
	
	public static LinkedList<IngreedientsSvEmbeddable> linkedListToEmbeddableLinkeList( LinkedList<IngreedientsCli> ll ){
		LinkedList llEmbed = new LinkedList();
		
		for( int a = 0; a < ll.size(); a++){
			IngreedientsSvEmbeddable isve = ingredientCliToSvEmbeddable(ll.get(a));
			llEmbed.add(isve);
		}
		
		return llEmbed;
	}
	
	public static LinkedList<IngreedientsSvEmbeddable> addListsToOneEmbeddableList(LinkedList<IngreedientsCli> ll ){
		LinkedList<IngreedientsSvEmbeddable> llEmbeddable = new LinkedList<IngreedientsSvEmbeddable>();
		for( int a = 0; a < ll.size(); a++){
			IngreedientsSvEmbeddable isve = ingredientCliToSvEmbeddable(ll.get(a));
			llEmbeddable.add(isve);
		}
			return llEmbeddable;
	}
	
	public static LinkedList<IngreedientsCli> embeddableLinkeListToCli( LinkedList<IngreedientsSvEmbeddable> ll ){
		LinkedList cli = new LinkedList();
		
		for( int a = 0; a < ll.size(); a++){
			IngreedientsCli isve = ingredientSvToCliEmbeddable(ll.get(a));
			cli.add(isve);
		}
		
		return cli;
	}
	
	//Overs¾tte fra server object til client object.
	public static IngreedientsCli ingredientSvToCliEmbeddable(IngreedientsSvEmbeddable ic ){
		IngreedientsCli iv = new IngreedientsCli();
		iv.setAlcohol(ic.getAlcohol());
		iv.setCalcium(ic.getCalcium());
		iv.setCarbonHydrate(ic.getCarbonHydrate());
		iv.setCholesterol(ic.getCholesterol());
		iv.setDietaryFibre(ic.getDietaryFibre());
		iv.setEnergy(ic.getEnergy());
		iv.setFat(ic.getFat());
		iv.setFolat(ic.getFolat());
		iv.setFructose(ic.getFructose());
		iv.setGlucose(ic.getGlucose());
		iv.setGrams(ic.getGrams());
		//iv.setId(ic.getId());
		iv.setIodine(ic.getIodine());
		iv.setIron(ic.getIron());
		iv.setLactose(ic.getLactose());
		iv.setMagnesium(ic.getMagnesium());
		iv.setMaltose(ic.getMaltose());
		iv.setMonoSaturatedFattyAcid(ic.getMonoSaturatedFattyAcid());
		iv.setNameDanish(ic.getNameDanish());
		iv.setNameEnglish(ic.getNameEnglish());
		iv.setNatrium(ic.getNatrium());
		iv.setPhosphorus(ic.getPhosphorus());
		iv.setPolySaturatedFattyAcid(ic.getPolySaturatedFattyAcid());
		iv.setPotassium(ic.getPotassium());
		iv.setProtein(ic.getProtein());
		iv.setSaccharose(ic.getSaccharose());
		iv.setSaturatedFattyAcid(ic.getSaturatedFattyAcid());
		iv.setSelenium(ic.getSelenium());
		iv.setVitaminA(ic.getVitaminA());
		iv.setVitaminB1(ic.getVitaminB1());
		iv.setVitaminB12(ic.getVitaminB12());
		iv.setVitaminB2(ic.getVitaminB2());
		iv.setVitaminC(ic.getVitaminC());
		iv.setVitaminD(ic.getVitaminD());
		iv.setVitaminE(ic.getVitaminE());
		iv.setWater(ic.getWater());
		iv.setId(ic.getId().getId());
		iv.setOrigId(ic.getOrigId());
		return iv;
	}
}
