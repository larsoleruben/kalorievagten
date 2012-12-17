package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.Date;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.TextBox;

public class DatePickerHandler implements ValueChangeHandler {
	private DateHandler ddh;
	private TextBox textBox = null;
	class OurChangeEvent extends ChangeEvent {}
	
	public DatePickerHandler( DateHandler ddh, TextBox textBox){
		this.ddh = ddh;
		this.textBox = textBox;
	}
	
	@Override
	public void onValueChange(ValueChangeEvent event) {
		Date date = (Date) event.getValue();
		String dateString = DateTimeFormat.getFormat("dd-MM-yyyy").format(date);
		textBox.setText(dateString);
		textBox.setFocus(true);
		textBox.fireEvent( new OurChangeEvent());
        ddh.hideHandler();
	}

}
