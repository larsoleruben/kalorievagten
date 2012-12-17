package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.ConcurrentModificationException;

import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.ui.ListBox;

import dk.rubenc.kalorievagten.client.gui.MealsPanel;


public class RemoveConsumed implements DoubleClickHandler {

	MealsPanel mealsPanel = null;
	ListBox lb = null;
	
	public RemoveConsumed( MealsPanel mealsPanel){
		this.mealsPanel = mealsPanel;
	}
	

	@Override
	public void onDoubleClick(DoubleClickEvent event) {
		ListBox ci = (ListBox) event.getSource();
		String id = ci.getValue(ci.getSelectedIndex());
		mealsPanel.removeConsumedIngreedient(ci.getSelectedIndex(), id);
	}

}
