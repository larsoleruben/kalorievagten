package dk.rubenc.kalorievagten.shared;

import java.util.LinkedList;

import dk.rubenc.kalorievagten.client.model.IngreedientsCli;

/**
 * @author lars
 * 
 */
public class ConsumedSummator {

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

	public ConsumedSummator() {

	}

	/**
	 * @param list
	 *            All the different stuff in the ingreedients are summetated to
	 *            show the user how much he or she has consumed
	 */
	public void summate(LinkedList<IngreedientsCli> list) {

		if (list == null || list.isEmpty()) {
			// sæt alt på 0
			energy = 0.0;
			protein = 0.0;
			fat = 0.0;
			saturatedFattyAcid = 0.0;
			monoSaturatedFattyAcid = 0.0;
			polySaturatedFattyAcid = 0.0;
			carbonHydrate = 0.0;
			dietaryFibre = 0.0;
			alcohol = 0.0;
			water = 0.0;
			vitaminA = 0.0;
			vitaminD = 0.0;
			vitaminE = 0.0;
			vitaminB1 = 0.0;
			vitaminB2 = 0.0;
			folat = 0.0;
			vitaminB12 = 0.0;
			vitaminC = 0.0;
			natrium = 0.0;
			potassium = 0.0;
			calcium = 0.0;
			magnesium = 0.0;
			phosphorus = 0.0;
			iron = 0.0;
			iodine = 0.0;
			selenium = 0.0;
			fructose = 0.0;
			glucose = 0.0;
			lactose = 0.0;
			maltose = 0.0;
			saccharose = 0.0;
			cholesterol = 0.0;
			grams = 0.0;

		} else {

			for (IngreedientsCli ic : list) {
				energy += KVUtil.nvlDouble(ic.getEnergy()) / 100
						* ic.getGrams();
				protein += KVUtil.nvlDouble(ic.getProtein()) / 100
						* ic.getGrams();
				fat += KVUtil.nvlDouble(ic.getFat()) / 100 * ic.getGrams();
				saturatedFattyAcid += KVUtil.nvlDouble(ic
						.getSaturatedFattyAcid()) / 100 * ic.getGrams();
				monoSaturatedFattyAcid += KVUtil.nvlDouble(ic
						.getMonoSaturatedFattyAcid()) / 100 * ic.getGrams();
				polySaturatedFattyAcid += KVUtil.nvlDouble(ic
						.getPolySaturatedFattyAcid()) / 100 * ic.getGrams();
				carbonHydrate += KVUtil.nvlDouble(ic.getCarbonHydrate()) / 100
						* ic.getGrams();
				dietaryFibre += KVUtil.nvlDouble(ic.getDietaryFibre()) / 100
						* ic.getGrams();
				alcohol += KVUtil.nvlDouble(ic.getAlcohol()) / 100
						* ic.getGrams();
				water += KVUtil.nvlDouble(ic.getWater()) / 100 * ic.getGrams();
				vitaminA += KVUtil.nvlDouble(ic.getVitaminA()) / 100
						* ic.getGrams();
				vitaminD += KVUtil.nvlDouble(ic.getVitaminD()) / 100
						* ic.getGrams();
				vitaminE += KVUtil.nvlDouble(ic.getVitaminE()) / 100
						* ic.getGrams();
				vitaminB1 += KVUtil.nvlDouble(ic.getVitaminB1()) / 100
						* ic.getGrams();
				vitaminB2 += KVUtil.nvlDouble(ic.getVitaminB2()) / 100
						* ic.getGrams();
				folat += KVUtil.nvlDouble(ic.getFolat()) / 100 * ic.getGrams();
				vitaminB12 += KVUtil.nvlDouble(ic.getVitaminB12()) / 100
						* ic.getGrams();
				vitaminC += KVUtil.nvlDouble(ic.getVitaminC()) / 100
						* ic.getGrams();
				natrium += KVUtil.nvlDouble(ic.getNatrium()) / 100
						* ic.getGrams();
				potassium += KVUtil.nvlDouble(ic.getPotassium()) / 100
						* ic.getGrams();
				calcium += KVUtil.nvlDouble(ic.getCalcium()) / 100
						* ic.getGrams();
				magnesium += KVUtil.nvlDouble(ic.getMagnesium()) / 100
						* ic.getGrams();
				phosphorus += KVUtil.nvlDouble(ic.getPhosphorus()) / 100
						* ic.getGrams();
				iron += KVUtil.nvlDouble(ic.getIron()) / 100 * ic.getGrams();
				iodine += KVUtil.nvlDouble(ic.getIodine()) / 100
						* ic.getGrams();
				selenium += KVUtil.nvlDouble(ic.getSelenium()) / 100
						* ic.getGrams();
				fructose += KVUtil.nvlDouble(ic.getFructose()) / 100
						* ic.getGrams();
				glucose += KVUtil.nvlDouble(ic.getGlucose()) / 100
						* ic.getGrams();
				lactose += KVUtil.nvlDouble(ic.getLactose()) / 100
						* ic.getGrams();
				maltose += KVUtil.nvlDouble(ic.getMaltose()) / 100
						* ic.getGrams();
				saccharose += KVUtil.nvlDouble(ic.getSaccharose()) / 100
						* ic.getGrams();
				cholesterol += KVUtil.nvlDouble(ic.getCholesterol()) / 100
						* ic.getGrams();
				grams += KVUtil.nvlDouble(ic.getGrams()) / 100 * ic.getGrams();

			}
		}
	}

	public Double getEnergy() {
		return energy;
	}

	public Double getProtein() {
		return protein;
	}

	public Double getFat() {
		return fat;
	}

	public Double getSaturatedFattyAcid() {
		return saturatedFattyAcid;
	}

	public Double getMonoSaturatedFattyAcid() {
		return monoSaturatedFattyAcid;
	}

	public Double getPolySaturatedFattyAcid() {
		return polySaturatedFattyAcid;
	}

	public Double getCarbonHydrate() {
		return carbonHydrate;
	}

	public Double getDietaryFibre() {
		return dietaryFibre;
	}

	public Double getAlcohol() {
		return alcohol;
	}

	public Double getWater() {
		return water;
	}

	public Double getVitaminA() {
		return vitaminA;
	}

	public Double getVitaminD() {
		return vitaminD;
	}

	public Double getVitaminE() {
		return vitaminE;
	}

	public Double getVitaminB1() {
		return vitaminB1;
	}

	public Double getVitaminB2() {
		return vitaminB2;
	}

	public Double getFolat() {
		return folat;
	}

	public Double getVitaminB12() {
		return vitaminB12;
	}

	public Double getVitaminC() {
		return vitaminC;
	}

	public Double getNatrium() {
		return natrium;
	}

	public Double getPotassium() {
		return potassium;
	}

	public Double getCalcium() {
		return calcium;
	}

	public Double getMagnesium() {
		return magnesium;
	}

	public Double getPhosphorus() {
		return phosphorus;
	}

	public Double getIron() {
		return iron;
	}

	public Double getIodine() {
		return iodine;
	}

	public Double getSelenium() {
		return selenium;
	}

	public Double getFructose() {
		return fructose;
	}

	public Double getGlucose() {
		return glucose;
	}

	public Double getLactose() {
		return lactose;
	}

	public Double getMaltose() {
		return maltose;
	}

	public Double getSaccharose() {
		return saccharose;
	}

	public Double getCholesterol() {
		return cholesterol;
	}

	public Double getGrams() {
		return grams;
	}
}
