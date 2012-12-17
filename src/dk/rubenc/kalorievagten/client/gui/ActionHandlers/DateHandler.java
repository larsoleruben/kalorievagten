package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import dk.rubenc.kalorievagten.client.gui.TraningTable;

public class DateHandler implements ClickHandler {

	private TextBox textBox = null;
	
	public DateHandler( TextBox textBox ){
		this.textBox = textBox;
	}
	
	private PopupPanel popupPanel = null;
	@Override
	public void onClick(ClickEvent event) {	
		showDatePicker();
	}
	
	public void hideHandler(){
		this.popupPanel.hide();
	}

	
	private void showDatePicker(){
		popupPanel = new PopupPanel(true);
		DatePicker datePicker = new DatePicker();
		datePicker.addValueChangeHandler(new DatePickerHandler(this, textBox));
		popupPanel.add(datePicker);
		//TraningTable tt = TraningTable.getInstance();
		//TextBox tb = tt.getDateBox();
		popupPanel.setPopupPosition(textBox.getAbsoluteLeft()+textBox.getOffsetWidth()+2, textBox.getAbsoluteTop());
		popupPanel.show();
	}


}
