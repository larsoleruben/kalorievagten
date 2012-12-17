/**
 * 
 */
package dk.rubenc.kalorievagten.shared.model;

/**
 * @author laoch
 *
 */

public interface Ingreedients {

	Long id = null;  
	String nameDanish = null;
	String nameEnglish = null;
	Double energy = null;
	Double protein = null;
	Double fat = null;
	Double saturatedFattyAcid = null;
	Double monoSaturatedFattyAcid = null;
	Double polySaturatedFattyAcid = null;
	Double carbonHydrate = null;
	Double dietaryFibre = null;
	Double alcohol = null;
	Double water = null;
	Double vitaminA = null;
	Double vitaminD = null;
	Double vitaminE = null;
	Double vitaminB1 = null;
	Double vitaminB2 = null;
	Double folat = null;
	Double vitaminB12 = null;
	Double vitaminC = null;
	Double natrium = null;
	Double potassium = null;
	Double calcium = null;
	Double magnesium = null;
	Double phosphorus = null;
	Double iron = null;
	Double iodine = null;
	Double selenium = null;
	Double fructose = null;
	Double glucose = null;
	Double lactose = null;
	Double maltose = null;
	Double saccharose = null;
	Double cholesterol = null;
	Double grams = null;
	
	Long getId();
	void setId( Long id);
	String getNameDanish();
	void setNameDanish(String nameDanish);
	Double getEnergy();
	void setEnergy( Double energy);
	Double getProtein();
	void setProtein( Double protein);
	Double getFat();
	void setFat(Double fat);
	Double getSaturatedFattyAcid();
	void setSaturatedFattyAcid(Double saturatedFattyAcid);
	Double getMonoSaturatedFattyAcid();
	void setMonoSaturatedFattyAcid(Double monoSaturatedFattyAcid);
	Double getPolySaturatedFattyAcid();
	void setPolySaturatedFattyAcid(Double polySaturatedFattyAcid);
	Double getCarbonHydrate();
	void setCarbonHydrate( Double carbonHydrate);
	Double getDietaryFibre();
	void setDietaryFibre(Double dietaryFibre);
	Double getAlcohol();
	void setAlcohol(Double alcohol);
	Double getWater();
	void setWater(Double water);
	Double getVitaminA();
	void setVitaminA(Double vitaminA);
	Double getVitaminD();
	void setVitaminD(Double vitaminD);
	Double getVitaminE();
	void setVitaminE(Double vitaminE);
	Double getVitaminB1();
	void setVitaminB1(Double vitaminB1);
	Double getVitaminB2();
	void setVitaminB2(Double vitaminB2);
	Double getFolat();
	void setFolat(Double folat);
	Double getVitaminB12();
	void setVitaminB12(Double vitaminB12);
	Double getVitaminC();
	void setVitaminC(Double vitaminC);
	Double getNatrium();
	void setNatrium(Double natrium);
	Double getPotassium();
	void setPotassium(Double potassium);
	Double getCalcium();
	void setCalcium(Double calsium);
	Double getMagnesium();
	void setMagnesium(Double magnesium);
	Double getPhosphorus();
	void setPhosphorus(Double phosphorus);
	Double getIron();
	void setIron( Double iron);
	Double getIodine();
	void setIodine(Double iodine);
	Double getSelenium();
	void setSelenium(Double selenium);
	Double getFructose();
	void setFructose(Double fructose);
	Double getGlucose();
	void setGlucose(Double glucose);
	Double getLactose();
	void setLactose(Double lactose);
	Double getMaltose();
	void setMaltose(Double maltose);
	Double getSaccharose();
	void setSaccharose( Double saccharose);
	Double getCholesterol();
	void setCholesterol(Double cholesterol);
	Double getGrams();
	void setGrams(Double grams);
	
	

}
