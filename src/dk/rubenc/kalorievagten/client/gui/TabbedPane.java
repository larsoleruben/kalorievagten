package dk.rubenc.kalorievagten.client.gui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.TabPanel;

import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class TabbedPane extends Composite {

	
	TabPanel tp = new DecoratedTabPanel();
	
	PersonTable personTable = PersonTable.getInstance();
	TraningTable trainingTable = TraningTable.getInstance() ;
	MealsPanel meals = new MealsPanel();
	
	public TabbedPane(){
		KvConstants_dk kvConstants = (KvConstants_dk) GWT.create(KvConstants_dk.class);
		personTable.setSize("100%", "100%");
		trainingTable.setSize("100%", "100%");
		tp.add(personTable, kvConstants.personalInformation());
		tp.add(trainingTable, kvConstants.Training());
		tp.add(meals, kvConstants.meals());
		tp.selectTab(0);
		initWidget(tp);
		tp.setSize("100%", "100%");
	}
}
