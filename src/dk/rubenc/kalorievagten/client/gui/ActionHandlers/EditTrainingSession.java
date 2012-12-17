package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class EditTrainingSession implements ClickHandler, KeyUpHandler {

	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	KVTrainingSessionCli kvtc;
	FlexTable trainingTable;
	int row;
	private HandlerRegistration hr;
	private TextBox dateBox = new TextBox();
	private ListBox typeBox = new ListBox();
	private TextBox  timeBox = new TextBox();
	private TextBox maxBox = new TextBox();
	private TextBox atBox = new TextBox();
	private TextBox subAtBox = new TextBox();
	private TextBox baseBox = new TextBox();
	private TextBox powerBox = new TextBox();
	private TextBox strenghtBox = new TextBox();
	private TextBox distBox = new TextBox();
	private TextBox energyBox = new TextBox();
	private TextBox commentBox = new TextBox();
	
	
	
	public EditTrainingSession( KVTrainingSessionCli kvtc, FlexTable trainingTable, int row)
	{
		this.kvtc = kvtc;
		this.trainingTable = trainingTable;
		this.row = row;
		
		typeBox.addItem(kvc.choose());
		typeBox.addItem(kvc.road());
		typeBox.addItem(kvc.mtb());
		typeBox.addItem(kvc.running());
		typeBox.addItem(kvc.skateing());
		typeBox.addItem(kvc.strength());
		typeBox.setWidth("95px");
		dateBox.setWidth("75px");
		typeBox.setWidth("120px");
		timeBox.setWidth("30px");
		timeBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipTimeBox(), 1000, this.timeBox));
		maxBox.setWidth("30px");
		maxBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipMax(), 1000, this.maxBox));
		atBox.setWidth("30px");
		atBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipAt(), 1000, this.atBox));
		subAtBox.setWidth("30px");
		subAtBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipSubAt(), 1000, this.subAtBox));
		baseBox.setWidth("30px");
		baseBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipBase(), 1000, this.baseBox));
		powerBox.setWidth("30px");
		powerBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipPower(), 1000, this.powerBox));
		strenghtBox.setWidth("30px");
		strenghtBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipStrengt(), 1000, this.strenghtBox));
		distBox.setWidth("40px");
		distBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipDistance(), 1000, this.distBox));
		energyBox.setWidth("40px");
		energyBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipEnergy(), 1000, this.energyBox));
		commentBox.setWidth("230px");
		commentBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipCommments(), 1000, this.commentBox));
		dateBox.addClickHandler(new DateHandler( this.dateBox));
	}
	
	@Override
	public void onKeyUp(KeyUpEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(ClickEvent event) {
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd-MM-yyyy");
		dateBox.setText(dtf.format(kvtc.getDoneDate()));
		typeBox.setItemSelected(kvtc.getTrainingType(), true);
		timeBox.setText(String.valueOf(kvtc.getTotalTimeMin()));
		maxBox.setText(String.valueOf(kvtc.getMaxTime()));
		atBox.setText(String.valueOf(kvtc.getAtTime()));
		subAtBox.setText(String.valueOf(kvtc.getAtTime()));
		baseBox.setText(String.valueOf(kvtc.getSubAtTime()));
		powerBox.setText(String.valueOf(kvtc.getPowerNumber()));
		strenghtBox.setText(String.valueOf(kvtc.getStrengthTime()));
		distBox.setText(String.valueOf(kvtc.getDistance()));
		energyBox.setText(String.valueOf(kvtc.getEnergy()));
		commentBox.setText(String.valueOf(kvtc.getComments()));
		trainingTable.setWidget(row, 0, dateBox);
		trainingTable.setWidget(row, 1, typeBox);
		trainingTable.setWidget(row, 2, timeBox);
		trainingTable.setWidget(row, 3, maxBox);
		trainingTable.setWidget(row, 4, atBox);
		trainingTable.setWidget(row, 5, subAtBox);
		trainingTable.setWidget(row, 6, baseBox);
		trainingTable.setWidget(row, 7, powerBox);
		trainingTable.setWidget(row, 8, strenghtBox);
		trainingTable.setWidget(row, 9, distBox);
		trainingTable.setWidget(row, 10, energyBox);
		trainingTable.setWidget(row, 11, commentBox);
		kvtc.setStringDoneDate(dateBox.getText());
		Button editButton = (Button) trainingTable.getWidget(row, 13);
		editButton.setText(kvc.Save());
		hr.removeHandler();
		editButton.addClickHandler(new SaveEditedTrainingSession(kvtc, trainingTable, row));
	}
	
	public HandlerRegistration getHr() {
		return hr;
	}

	public void setHr(HandlerRegistration hr) {
		this.hr = hr;
	}

}
