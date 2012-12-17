/**
 * 
 */
package dk.rubenc.kalorievagten.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

/**
 * @author laoch
 *
 */
@Entity( name = "IngreedientsSvEmbeddable")
public class IngreedientsSvEmbeddable implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	private String nameDanish = "template";
	private String nameEnglish = "template";
	private Double energy = 0.0;
	private Double protein = 0.0;
	private Double fat = 0.0;
	private Double saturatedFattyAcid = 0.0;
	private Double monoSaturatedFattyAcid = 0.0;
	private Double polySaturatedFattyAcid = 0.0;
	private Double carbonHydrate = 0.0;
	private Double dietaryFibre = 0.0;
	private Double alcohol = 0.0;
	private Double water = 0.0;
	private Double vitaminA = 0.0;
	private Double vitaminD = 0.0;
	private Double vitaminE = 0.0;
	private Double vitaminB1 = 0.0;
	private Double vitaminB2 = 0.0;
	private Double folat = 0.0;
	private Double vitaminB12 = 0.0;
	private Double vitaminC = 0.0;
	private Double natrium = 0.0;
	private Double potassium = 0.0;
	private Double calcium = 0.0;
	private Double magnesium = 0.0;
	private Double phosphorus = 0.0;
	private Double iron = 0.0;
	private Double iodine = 0.0;
	private Double selenium = 0.0;
	private Double fructose = 0.0;
	private Double glucose = 0.0;
	private Double lactose = 0.0;
	private Double maltose = 0.0;
	private Double saccharose = 0.0;
	private Double cholesterol = 0.0;
	private Double grams = 0.0;
	private Long origId = null;
	
	//@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
	//private ConsumedDateSv cds;
	
	
	
	
	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getId()
	 */
	//@ManyToOne
	//public ConsumedDateSv getCds() {
	//	return cds;
	//}

	//public void setCds(ConsumedDateSv cds) {
	//	this.cds = cds;
	//}

	//@Override
	public Key getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setId(java.lang.Long)
	 */
	//@Override
	public void setId(Key id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getNameDanish()
	 */
	//@Override
	public String getNameDanish() {
		return nameDanish;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setNameDanish(java.lang.String)
	 */
	//@Override
	public void setNameDanish(String nameDanish) {
		this.nameDanish = nameDanish;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getEnergy()
	 */
	//@Override
	public Double getEnergy() {
		return energy;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setEnergy(java.lang.Double)
	 */
	//@Override
	public void setEnergy(Double energy) {
		this.energy = energy;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getProtein()
	 */
	//@Override
	public Double getProtein() {
		return protein;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setProtein(java.lang.Double)
	 */
	//@Override
	public void setProtein(Double protein) {
		this.protein = protein;

	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getFat()
	 */
	//@Override
	public Double getFat() {
		return fat;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setFat(java.lang.Double)
	 */
	//@Override
	public void setFat(Double fat) {
		this.fat = fat;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getSaturatedFattyAcid()
	 */
	//@Override
	public Double getSaturatedFattyAcid() {
		return saturatedFattyAcid;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setSaturatedFattyAcid(java.lang.Double)
	 */
	//@Override
	public void setSaturatedFattyAcid(Double saturatedFattyAcid) {
		this.saturatedFattyAcid = saturatedFattyAcid;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setMonoSaturatedFattyAcid()
	 */
	//@Override
	public Double getMonoSaturatedFattyAcid() {
		return monoSaturatedFattyAcid;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getMonoSaturatedFattyAcid(java.lang.Double)
	 */
	//@Override
	public void setMonoSaturatedFattyAcid(Double monoSaturatedFattyAcid) {
		this.monoSaturatedFattyAcid = monoSaturatedFattyAcid;

	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getPolySaturatedFattyAcid()
	 */
	//@Override
	public Double getPolySaturatedFattyAcid() {
		return polySaturatedFattyAcid;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setPolySaturatedFattyAcid(java.lang.Double)
	 */
	//@Override
	public void setPolySaturatedFattyAcid(Double polySaturatedFattyAcid) {
		this.polySaturatedFattyAcid = polySaturatedFattyAcid;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getCarbonHydrate()
	 */
	//@Override
	public Double getCarbonHydrate() {
		return carbonHydrate;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setCarbonHydrate(java.lang.Double)
	 */
	//@Override
	public void setCarbonHydrate(Double carbonHydrate) {
		this.carbonHydrate = carbonHydrate;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getDietaryFibre()
	 */
	//@Override
	public Double getDietaryFibre() {
		return dietaryFibre;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setDietaryFibre(java.lang.Double)
	 */
	//@Override
	public void setDietaryFibre(Double dietaryFibre) {
		this.dietaryFibre = dietaryFibre;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getAlcohol()
	 */
	//@Override
	public Double getAlcohol() {
		return alcohol;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setAlcohol(java.lang.Double)
	 */
	//@Override
	public void setAlcohol(Double alcohol) {
		this.alcohol = alcohol;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getWater()
	 */
	//@Override
	public Double getWater() {
		return water;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getWater(java.lang.Double)
	 */
	//@Override
	public void setWater(Double water) {
		this.water = water;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminA()
	 */
	//@Override
	public Double getVitaminA() {
		return vitaminA;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminA(java.lang.Double)
	 */
	//@Override
	public void setVitaminA(Double vitaminA) {
		this.vitaminA = vitaminA;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminD()
	 */
	//@Override
	public Double getVitaminD() {
		return vitaminD;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminD(java.lang.Double)
	 */
	//@Override
	public void setVitaminD(Double vitaminD) {
		this.vitaminD = vitaminD;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminE()
	 */
	//@Override
	public Double getVitaminE() {
		return vitaminE;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminE(java.lang.Double)
	 */
	//@Override
	public void setVitaminE(Double vitaminE) {
		this.vitaminE = vitaminE;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminB1()
	 */
	//@Override
	public Double getVitaminB1() {
		return vitaminB1;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminB1(java.lang.Double)
	 */
	//@Override
	public void setVitaminB1(Double vitaminB1) {
		this.vitaminB1 = vitaminB1;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminB2()
	 */
	//@Override
	public Double getVitaminB2() {
		return vitaminB2;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminB2(java.lang.Double)
	 */
	//@Override
	public void setVitaminB2(Double vitaminB2) {
		this.vitaminB2 = vitaminB2;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getFolat()
	 */
	//@Override
	public Double getFolat() {
		return folat;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setFolat(java.lang.Double)
	 */
	//@Override
	public void setFolat(Double folat) {
		this.folat = folat;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminB12()
	 */
	//@Override
	public Double getVitaminB12() {
		return vitaminB12;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminB12(java.lang.Double)
	 */
	//@Override
	public void setVitaminB12(Double vitaminB12) {
		this.vitaminB12 = vitaminB12;
	}

	public Double getGrams() {
		return grams;
	}

	public void setGrams(Double grams) {
		this.grams = grams;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getVitaminC()
	 */
	//@Override
	public Double getVitaminC() {
		return vitaminC;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setVitaminC(java.lang.Double)
	 */
	//@Override
	public void setVitaminC(Double vitaminC) {
		this.vitaminC = vitaminC;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getNatrium()
	 */
	//@Override
	public Double getNatrium() {
		return natrium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setNatrium(java.lang.Double)
	 */
	//@Override
	public void setNatrium(Double natrium) {
		this.natrium = natrium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getPotassium()
	 */
	//@Override
	public Double getPotassium() {
		return potassium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setPotassium(java.lang.Double)
	 */
	//@Override
	public void setPotassium(Double potassium) {
		this.potassium = potassium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getCalcium()
	 */
	//@Override
	public Double getCalcium() {
		return calcium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setCalcium(java.lang.Double)
	 */
	//@Override
	public void setCalcium(Double calsium) {
		this.calcium = calsium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getMagnesium()
	 */
	//@Override
	public Double getMagnesium() {
		return magnesium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setMagnesium(java.lang.Double)
	 */
	//@Override
	public void setMagnesium(Double magnesium) {
		this.magnesium = magnesium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getPhosphorus()
	 */
	//@Override
	public Double getPhosphorus() {
		return phosphorus;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setPhosphorus(java.lang.Double)
	 */
	//@Override
	public void setPhosphorus(Double phosphorus) {
		this.phosphorus = phosphorus;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getIron()
	 */
	//@Override
	public Double getIron() {
		return iron;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setIron(java.lang.Double)
	 */
	//@Override
	public void setIron(Double iron) {
		this.iron = iron;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getIodine()
	 */
	//@Override
	public Double getIodine() {
		return iodine;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setIodine(java.lang.Double)
	 */
	//@Override
	public void setIodine(Double iodine) {
		this.iodine = iodine;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getSelenium()
	 */
	//@Override
	public Double getSelenium() {
		return selenium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setSelenium(java.lang.Double)
	 */
	//@Override
	public void setSelenium(Double selenium) {
		this.selenium = selenium;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getFructose()
	 */
	//@Override
	public Double getFructose() {
		return fructose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setFructose(java.lang.Double)
	 */
	//@Override
	public void setFructose(Double fructose) {
		this.fructose = fructose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getGlucose()
	 */
	//@Override
	public Double getGlucose() {
		return glucose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setGlucose(java.lang.Double)
	 */
	//@Override
	public void setGlucose(Double glucose) {
		this.glucose = glucose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getLactose()
	 */
	//@Override
	public Double getLactose() {
		return lactose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setLactose(java.lang.Double)
	 */
	//@Override
	public void setLactose(Double lactose) {
		this.lactose = lactose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getMaltose()
	 */
	//@Override
	public Double getMaltose() {
		return maltose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setMaltose(java.lang.Double)
	 */
	//@Override
	public void setMaltose(Double maltose) {
		this.maltose = maltose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getSaccharose()
	 */
	//@Override
	public Double getSaccharose() {
		return saccharose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setSaccharose(java.lang.Double)
	 */
	//@Override
	public void setSaccharose(Double saccharose) {
		this.saccharose = saccharose;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#getCholesterol()
	 */
	//@Override
	public Double getCholesterol() {
		return cholesterol;
	}

	/* (non-Javadoc)
	 * @see dk.rubenc.kalorievagten.shared.model.Ingreedients#setCholesterol(java.lang.Double)
	 */
	//@Override
	public void setCholesterol(Double cholesterol) {
		this.cholesterol = cholesterol;
	}

	/**
	 * @return the nameEnglish
	 */
	public String getNameEnglish() {
		return nameEnglish;
	}

	/**
	 * @param nameEnglish the nameEnglish to set
	 */
	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}

	public void setOrigId(Long origId) {
		this.origId = origId;
	}

	public Long getOrigId() {
		return origId;
	}

}
