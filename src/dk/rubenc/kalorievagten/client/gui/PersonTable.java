/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import dk.rubenc.kalorievagten.client.gui.ActionHandlers.SavePerson;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

/**
 * @author laoch
 *
 */
public class PersonTable extends Composite {
	
	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	FlexTable personTable = new FlexTable();
	final TextBox email = new TextBox();
	final TextBox fName = new TextBox();
	final TextBox sName = new TextBox();
	final TextBox city = new TextBox();
	final TextBox address = new TextBox();
	final TextBox zipCode = new TextBox();
	final ListBox sex = new ListBox();
	final TextBox bmi = new TextBox();
	final TextBox height = new TextBox();
	final TextBox weight = new TextBox();
	final RadioButton unitEnergyIso = new RadioButton("energyUnit", kvc.kilojoule());
	final RadioButton unitEnergyKcal = new RadioButton("energyUnit", kvc.kilocal());
	final Button saveButton = new Button(kvc.Save());
	final DatePicker datePicker = new DatePicker();
	
	private PersonTable(){
		
		sex.addItem(kvc.choose());
		sex.addItem(kvc.Female());
		sex.addItem(kvc.Male());
		sex.setHeight("25px");
		sex.setWidth("160px");
		saveButton.setWidth("73px");
		email.setEnabled(false);
		personTable.setText(0, 0, kvc.email());
		personTable.setText(1, 0, kvc.fName());
		personTable.setText(2, 0, kvc.sName());
		personTable.setText(3, 0, kvc.city());
		personTable.setText(4, 0, kvc.address());
		personTable.setText(5, 0, kvc.zip());
		personTable.setText(6, 0, kvc.sex());
		personTable.setText(7, 0, kvc.BMI());
		personTable.setText(8, 0, kvc.height());
		personTable.setText(0, 2, kvc.weight());
		personTable.setText(1, 2, kvc.unitEnergy());
		personTable.setWidget(0, 1, email);
		personTable.setWidget(1, 1, fName);
		personTable.setWidget(2, 1, sName);
		personTable.setWidget(3, 1, city);
		personTable.setWidget(4, 1, address);
		personTable.setWidget(5, 1, zipCode);
		personTable.setWidget(6, 1, sex);
		personTable.setWidget(7, 1, bmi);
		personTable.setWidget(8, 1, height);
		personTable.setWidget(9, 1, saveButton);
		personTable.setWidget(0, 3, weight);
		personTable.setWidget(1, 3, unitEnergyIso);
		personTable.setWidget(1, 4, unitEnergyKcal);
		personTable.setText(1, 5, kvc.explainUnit() );		
		personTable.setSize("100%", "100%");
		displayUserDetails();
		saveButton.addClickHandler(new SavePerson());
		initWidget(personTable);
	}
	
	public void displayUserDetails(){
		KalorieVagtenUser kvus = KalorieVagtenUser.getInstance();
		email.setText(kvus.getEmail());
		fName.setText(kvus.getfName());
		sName.setText(kvus.getsName());
		city.setText(kvus.getCity());
		address.setText(kvus.getAddress());
		zipCode.setText(kvus.getZipCode());
		sex.setSelectedIndex(kvus.getSex());
		bmi.setText(  String.valueOf(kvus.getBmi()));
		height.setText(  String.valueOf(kvus.getHeight()));
		weight.setText(  String.valueOf(kvus.getWeight()));
		unitEnergyIso.setValue(kvus.getUnitEnergyIso());
		unitEnergyKcal.setValue(kvus.getUnitEnergyKcal());
	}
	
	public void setUserDetails(){
		
		KalorieVagtenUser kvus = KalorieVagtenUser.getInstance();
		kvus.setEmail(email.getText());
		kvus.setfName(fName.getText());
		kvus.setsName(sName.getText());
		kvus.setCity(city.getText());
		kvus.setAddress(address.getText());
		kvus.setZipCode(zipCode.getText());
		kvus.setSex(sex.getSelectedIndex());
		kvus.setBmi(Float.parseFloat(bmi.getText()));
		kvus.setHeight(Float.parseFloat(height.getText()));
		kvus.setWeight(Float.parseFloat(weight.getText()));
		kvus.setUnitEnergyIso(unitEnergyIso.getValue());
		kvus.setUnitEnergyKcal(unitEnergyKcal.getValue());
	}
	//Singleton
	private static class PersonTableHolderHolder { 
	     public static final PersonTable INSTANCE = new PersonTable();
	}
	
	public static PersonTable getInstance() {
	     return PersonTableHolderHolder.INSTANCE;
	   }
}
