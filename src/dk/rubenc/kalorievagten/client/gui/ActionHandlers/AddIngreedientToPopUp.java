package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.Iterator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dk.rubenc.kalorievagten.client.gui.MealsPanel;
import dk.rubenc.kalorievagten.client.model.IngreedientsCli;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class AddIngreedientToPopUp implements  DoubleClickHandler {
    
	//tp get somenew stuff
	private MealsPanel mealsPanel;
	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	
	public AddIngreedientToPopUp(MealsPanel mealsPanel ){
		this.mealsPanel = mealsPanel;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onDoubleClick(DoubleClickEvent event) {
		IngreedientsCli ic = null;
		ListBox lbIngreedients = (ListBox)event.getSource();
		String id = lbIngreedients.getValue(lbIngreedients.getSelectedIndex());
		Iterator<IngreedientsCli> it = mealsPanel.getIngreedientList().iterator();
		while( it.hasNext()){
			ic = it.next();
			if( ic.getId() == Long.parseLong(id)  ){
				break;
			}
		}
		
		final Button closeButton = new Button("Fortryd!");
		final Button addButton = new Button("Tilføj");
		final FlexTable buttonTable = new FlexTable();
		buttonTable.setWidget(0,0,addButton);
		buttonTable.setWidget(0, 1, closeButton);
		final Label nameLabel = new Label("Fødevare: "+ic.getNameDanish());
		final Label energyLabel = new Label(String.valueOf(ic.getEnergy()) + " kJ pr 100 gram" );
		final Label weightLabel = new Label("Antal gram i dit måltid:");
		final TextBox tbWeight = new TextBox();
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setSize("200px", "200px");
		dialogBox.setText("Ingridienser");
		dialogBox.setAnimationEnabled(true);
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.add(nameLabel );
		dialogVPanel.add(energyLabel);
		dialogVPanel.add(weightLabel);
		dialogVPanel.add(tbWeight);
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_LEFT);
		dialogVPanel.add(buttonTable);
		addButton.addClickHandler(new AddIngreedientToConumedList(mealsPanel, ic, tbWeight, dialogBox));
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
		tbWeight.addKeyDownHandler(new AddIngreedientToConumedList(mealsPanel, ic, tbWeight, dialogBox));
		dialogBox.setWidget(dialogVPanel);
		dialogBox.setPopupPosition(lbIngreedients.getAbsoluteLeft(), lbIngreedients.getAbsoluteTop());
		dialogBox.show();
		
		DeferredCommand.addCommand(new Command() {
		      public void execute() {
		        tbWeight.setFocus(true);
		      }
		});
		
	}
	
}
