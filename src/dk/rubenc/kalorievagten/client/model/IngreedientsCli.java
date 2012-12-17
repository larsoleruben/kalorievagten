package dk.rubenc.kalorievagten.client.model;

import java.io.Serializable;

import dk.rubenc.kalorievagten.shared.model.Ingreedients;

public class IngreedientsCli implements Ingreedients, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id = null;  
	Long origId = null;
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
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameDanish() {
		return nameDanish;
	}
	public void setNameDanish(String nameDanish) {
		this.nameDanish = nameDanish;
	}
	public String getNameEnglish() {
		return nameEnglish;
	}
	public Long getOrigId() {
		return origId;
	}
	public void setOrigId(Long origId) {
		this.origId = origId;
	}
	public void setNameEnglish(String nameEnglish) {
		this.nameEnglish = nameEnglish;
	}
	public Double getEnergy() {
		return energy;
	}
	public void setEnergy(Double energy) {
		this.energy = energy;
	}
	public Double getProtein() {
		return protein;
	}
	public void setProtein(Double protein) {
		this.protein = protein;
	}
	public Double getFat() {
		return fat;
	}
	public void setFat(Double fat) {
		this.fat = fat;
	}
	public Double getSaturatedFattyAcid() {
		return saturatedFattyAcid;
	}
	public void setSaturatedFattyAcid(Double saturatedFattyAcid) {
		this.saturatedFattyAcid = saturatedFattyAcid;
	}
	public Double getMonoSaturatedFattyAcid() {
		return monoSaturatedFattyAcid;
	}
	public void setMonoSaturatedFattyAcid(Double monoSaturatedFattyAcid) {
		this.monoSaturatedFattyAcid = monoSaturatedFattyAcid;
	}
	public Double getPolySaturatedFattyAcid() {
		return polySaturatedFattyAcid;
	}
	public void setPolySaturatedFattyAcid(Double polySaturatedFattyAcid) {
		this.polySaturatedFattyAcid = polySaturatedFattyAcid;
	}
	public Double getCarbonHydrate() {
		return carbonHydrate;
	}
	public void setCarbonHydrate(Double carbonHydrate) {
		this.carbonHydrate = carbonHydrate;
	}
	public Double getDietaryFibre() {
		return dietaryFibre;
	}
	public void setDietaryFibre(Double dietaryFibre) {
		this.dietaryFibre = dietaryFibre;
	}
	public Double getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(Double alcohol) {
		this.alcohol = alcohol;
	}
	public Double getWater() {
		return water;
	}
	public void setWater(Double water) {
		this.water = water;
	}
	public Double getVitaminA() {
		return vitaminA;
	}
	public void setVitaminA(Double vitaminA) {
		this.vitaminA = vitaminA;
	}
	public Double getVitaminD() {
		return vitaminD;
	}
	public void setVitaminD(Double vitaminD) {
		this.vitaminD = vitaminD;
	}
	public Double getVitaminE() {
		return vitaminE;
	}
	public void setVitaminE(Double vitaminE) {
		this.vitaminE = vitaminE;
	}
	public Double getVitaminB1() {
		return vitaminB1;
	}
	public void setVitaminB1(Double vitaminB1) {
		this.vitaminB1 = vitaminB1;
	}
	public Double getVitaminB2() {
		return vitaminB2;
	}
	public void setVitaminB2(Double vitaminB2) {
		this.vitaminB2 = vitaminB2;
	}
	public Double getFolat() {
		return folat;
	}
	public void setFolat(Double folat) {
		this.folat = folat;
	}
	public Double getVitaminB12() {
		return vitaminB12;
	}
	public void setVitaminB12(Double vitaminB12) {
		this.vitaminB12 = vitaminB12;
	}
	public Double getGrams() {
		return grams;
	}
	public void setGrams(Double grams) {
		this.grams = grams;
	}
	public Double getVitaminC() {
		return vitaminC;
	}
	public void setVitaminC(Double vitaminC) {
		this.vitaminC = vitaminC;
	}
	public Double getNatrium() {
		return natrium;
	}
	public void setNatrium(Double natrium) {
		this.natrium = natrium;
	}
	public Double getPotassium() {
		return potassium;
	}
	public void setPotassium(Double potassium) {
		this.potassium = potassium;
	}
	public Double getCalcium() {
		return calcium;
	}
	public void setCalcium(Double calcium) {
		this.calcium = calcium;
	}
	public Double getMagnesium() {
		return magnesium;
	}
	public void setMagnesium(Double magnesium) {
		this.magnesium = magnesium;
	}
	public Double getPhosphorus() {
		return phosphorus;
	}
	public void setPhosphorus(Double phosphorus) {
		this.phosphorus = phosphorus;
	}
	public Double getIron() {
		return iron;
	}
	public void setIron(Double iron) {
		this.iron = iron;
	}
	public Double getIodine() {
		return iodine;
	}
	public void setIodine(Double iodine) {
		this.iodine = iodine;
	}
	public Double getSelenium() {
		return selenium;
	}
	public void setSelenium(Double selenium) {
		this.selenium = selenium;
	}
	public Double getFructose() {
		return fructose;
	}
	public void setFructose(Double fructose) {
		this.fructose = fructose;
	}
	public Double getGlucose() {
		return glucose;
	}
	public void setGlucose(Double glucose) {
		this.glucose = glucose;
	}
	public Double getLactose() {
		return lactose;
	}
	public void setLactose(Double lactose) {
		this.lactose = lactose;
	}
	public Double getMaltose() {
		return maltose;
	}
	public void setMaltose(Double maltose) {
		this.maltose = maltose;
	}
	public Double getSaccharose() {
		return saccharose;
	}
	public void setSaccharose(Double saccharose) {
		this.saccharose = saccharose;
	}
	public Double getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(Double cholesterol) {
		this.cholesterol = cholesterol;
	}

	
}
