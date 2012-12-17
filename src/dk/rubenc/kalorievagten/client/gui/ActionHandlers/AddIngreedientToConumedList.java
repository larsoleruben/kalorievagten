package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextBox;

import dk.rubenc.kalorievagten.client.gui.MealsPanel;
import dk.rubenc.kalorievagten.client.model.IngreedientsCli;

public class AddIngreedientToConumedList implements ClickHandler, KeyDownHandler {

	MealsPanel mealsPanel = null;
	IngreedientsCli ic = null;
	TextBox grams = null;
	DialogBox dialogBox = null;
	
	public AddIngreedientToConumedList( MealsPanel mealsPanel, IngreedientsCli ic, TextBox grams, DialogBox dialogBox){
		this.mealsPanel = mealsPanel;
		this.ic = ic;
		this.grams = grams;
		this.dialogBox = dialogBox;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		if(event.getSource() != grams){
		addTheIngreedient();
		}
		
	}

	@Override
	public void onKeyDown(KeyDownEvent event) {
		if( event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
			addTheIngreedient();
		}
		
	}
	
	private void addTheIngreedient(){
		ic.setGrams(Double.parseDouble(grams.getText()));
		mealsPanel.addConsumedIngreedientL(ic);
		dialogBox.hide();	
	}

}
