/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import dk.rubenc.kalorievagten.client.gui.ActionHandlers.CalculateEnergy;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.DateHandler;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.GetSessionBetweenDates;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.RefreshList;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.SaveTraningSession;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.ToolTipHandler;
import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.*;

/**
 * @author laoch
 * Changes can be written here
 * 
 */
public class TraningTable extends Composite {

	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	private final RpcServiceAsync rcpServiceAsync = Rpc.init();
	private FlexTable trainingTable = new FlexTable();
	private TextBox dateBox = new TextBox();
	private TextBox dateBoxFrom = new TextBox();
	private TextBox dateBoxTo = new TextBox();
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
	Button saveButton = new Button(kvc.add());
	Button refreshButton = new Button(kvc.refresh());
	Button getSessionsButton = new Button(kvc.getSessions());
	//Button editButton;
	

	private TraningTable() {
		typeBox.addItem(kvc.choose());
		typeBox.addItem(kvc.road());
		typeBox.addItem(kvc.mtb());
		typeBox.addItem(kvc.running());
		typeBox.addItem(kvc.skateing());
		typeBox.addItem(kvc.strength());
		typeBox.setWidth("95px");
		dateBox.setWidth("75px");
		dateBox.setReadOnly(true);
		dateBoxFrom.setWidth("65px");
		dateBoxFrom.addMouseOverHandler(new ToolTipHandler(kvc.toolTipDateFrom(), 1500, this.dateBoxFrom));
		dateBoxFrom.setReadOnly(true);
		dateBoxTo.setWidth("65px");
		dateBoxTo.addMouseOverHandler(new ToolTipHandler(kvc.toolTipDateTo(), 1500, this.dateBoxTo));
		dateBoxTo.setReadOnly(true);
		typeBox.setWidth("120px");
		timeBox.setWidth("30px");
		timeBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipTimeBox(), 1500, this.timeBox));
		maxBox.setWidth("30px");
		maxBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipMax(), 1500, this.maxBox));
		atBox.setWidth("30px");
		atBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipAt(), 1500, this.atBox));
		subAtBox.setWidth("30px");
		subAtBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipSubAt(), 1500, this.subAtBox));
		baseBox.setWidth("30px");
		baseBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipBase(), 1500, this.baseBox));
		powerBox.setWidth("30px");
		powerBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipPower(), 1500, this.powerBox));
		strenghtBox.setWidth("30px");
		strenghtBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipStrengt(), 1500, this.strenghtBox));
		distBox.setWidth("40px");
		distBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipDistance(), 1500, this.distBox));
		energyBox.setWidth("40px");
		energyBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipEnergy(), 1500, this.energyBox));
		commentBox.setWidth("230px");
		commentBox.addMouseOverHandler(new ToolTipHandler(kvc.toolTipCommments(), 1500, this.commentBox));
		saveButton.setWidth("73px");
		refreshButton.setWidth("130px");
		getSessionsButton.setWidth("120px");
        saveButton.addClickHandler(new SaveTraningSession());
        refreshButton.addClickHandler(new RefreshList());
        getSessionsButton.addClickHandler(new GetSessionBetweenDates(dateBoxFrom,dateBoxTo));
        dateBox.addClickHandler(new DateHandler( this.dateBox));
        dateBoxFrom.addClickHandler(new DateHandler(this.dateBoxFrom));
        dateBoxTo.addClickHandler(new DateHandler(this.dateBoxTo));
        commentBox.addKeyUpHandler(new SaveTraningSession());
        timeBox.addValueChangeHandler(new CalculateEnergy());
        dateBox.setText(DateTimeFormat.getFormat("dd-MM-yyyy").format(new Date()));
		trainingTable.setText(0, 0, kvc.date());
		trainingTable.setText(0, 1, kvc.type());
		trainingTable.setText(0, 2, kvc.time());
		trainingTable.setText(0, 3, kvc.max());
		trainingTable.setText(0, 4, kvc.at());
		trainingTable.setText(0, 5, kvc.sat());
		trainingTable.setText(0, 6, kvc.base());
		trainingTable.setText(0, 7, kvc.power());
		trainingTable.setText(0, 8, kvc.strength());
		trainingTable.setText(0, 9, kvc.distance());
		trainingTable.setText(0, 10, kvc.energy());
		trainingTable.setText(0, 11, kvc.comments());
		trainingTable.setText(0, 12, kvc.id());
		trainingTable.setText(0, 13, kvc.edit());
		trainingTable.setSize("100%", "100%");
		trainingTable.setWidget(1, 0, dateBox);
		trainingTable.setWidget(1, 1, typeBox);
		trainingTable.setWidget(1, 2, timeBox);
		trainingTable.setWidget(1, 3, maxBox);
		trainingTable.setWidget(1, 4, atBox);
		trainingTable.setWidget(1, 5, subAtBox);
		trainingTable.setWidget(1, 6, baseBox);
		trainingTable.setWidget(1, 7, powerBox);
		trainingTable.setWidget(1, 8, strenghtBox);
		trainingTable.setWidget(1, 9, distBox);
		trainingTable.setWidget(1, 10, energyBox);
		trainingTable.setWidget(1, 11, commentBox);
		trainingTable.setWidget(2, 0, saveButton);
		trainingTable.setWidget(2, 1, refreshButton);
		FlexCellFormatter fcf = trainingTable.getFlexCellFormatter();
		fcf.setColSpan(2, 2, 3);
		fcf.setColSpan(2, 4, 2);
		fcf.setColSpan(2, 6, 2);
		trainingTable.setWidget(2, 3, new Label(kvc.dateFrom()));
		trainingTable.setWidget(2, 5, new Label(kvc.dateTo()));
		trainingTable.setWidget(2, 2, getSessionsButton);
		trainingTable.setWidget(2, 4, dateBoxFrom);
		trainingTable.setWidget(2, 6, dateBoxTo);
		initWidget(trainingTable);
		if( KalorieVagtenUser.getInstance().isLoggedIn()){
			setLatest();
		}
		

	}

	private static class TraningTableHolder {
		public static final TraningTable INSTANCE = new TraningTable();
	}

	public static TraningTable getInstance() {
		return TraningTableHolder.INSTANCE;
	}
	
	public void addNewToTabel(KVTrainingSessionCli kvtsc ){
		int row = trainingTable.insertRow(3);
		trainingTable.setText(row, 0, kvtsc.getStringDoneDate());
		trainingTable.setText(row, 1, typeBox.getItemText(kvtsc.getTrainingType()));
		trainingTable.setText(row, 2, String.valueOf(kvtsc.getTotalTimeMin()));
		trainingTable.setText(row, 3, String.valueOf(kvtsc.getMaxTime()));
		trainingTable.setText(row, 4, String.valueOf(kvtsc.getAtTime()));
		trainingTable.setText(row, 5, String.valueOf(kvtsc.getSubAtTime()));
		trainingTable.setText(row, 6, String.valueOf(kvtsc.getBaseTime()));
		trainingTable.setText(row, 7, String.valueOf(kvtsc.getPowerNumber()));
		trainingTable.setText(row, 8, String.valueOf(kvtsc.getStrengthTime()));
		trainingTable.setText(row, 9, String.valueOf(kvtsc.getDistance()));
		trainingTable.setText(row, 10, String.valueOf(kvtsc.getEnergy()));
		trainingTable.setText(row, 11, kvtsc.getComments());
		trainingTable.setWidget(row, 12, new Label(String.valueOf(kvtsc.getSessionId())));
	}
	
	

	public void setLatestSessionstoTable(List list) {
		int row = 3;
		Iterator it = list.iterator();
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd-MM-yyyy");
		while( it.hasNext()){
			KVTrainingSessionCli kvtsc = (KVTrainingSessionCli) it.next();
			trainingTable.setText(row, 0, dtf.format( kvtsc.getDoneDate()));
			trainingTable.setText(row, 1, typeBox.getItemText(kvtsc.getTrainingType()));
			trainingTable.setText(row, 2, String.valueOf(kvtsc.getTotalTimeMin()));
			trainingTable.setText(row, 3, String.valueOf(kvtsc.getMaxTime()));
			trainingTable.setText(row, 4, String.valueOf(kvtsc.getAtTime()));
			trainingTable.setText(row, 5, String.valueOf(kvtsc.getSubAtTime()));
			trainingTable.setText(row, 6, String.valueOf(kvtsc.getBaseTime()));
			trainingTable.setText(row, 7, String.valueOf(kvtsc.getPowerNumber()));
			trainingTable.setText(row, 8, String.valueOf(kvtsc.getStrengthTime()));
			trainingTable.setText(row, 9, String.valueOf(kvtsc.getDistance()));
			trainingTable.setText(row, 10, String.valueOf(kvtsc.getEnergy()));
			trainingTable.setText(row, 11, kvtsc.getComments());
			if(kvtsc.getSessionId() != null ){
				trainingTable.setWidget(row, 12, new Label(String.valueOf(kvtsc.getSessionId())));
				Button editButton = new Button(kvc.edit());
				editButton.setWidth("73px");
				EditTrainingSession ets = new EditTrainingSession(kvtsc, trainingTable, row);
				HandlerRegistration hr = editButton.addClickHandler(ets);
				ets.setHr(hr);
				trainingTable.setWidget(row, 13, editButton);
			}
			row +=1;
		}
	}
	

	public void cleanFields() {
		dateBox.setText("");
		typeBox.setSelectedIndex(0);
		timeBox.setText("");
		maxBox.setText("");
		atBox.setText("");
		subAtBox.setText("");
		baseBox.setText("");
		powerBox.setText("");
		strenghtBox.setText("");
		distBox.setText("");
	    energyBox.setText("");
		commentBox.setText("");
	}
	
	public void cleanTable(){
		for( int rowCount = 3; rowCount < trainingTable.getRowCount();rowCount++ ){
			for( int colCount = 0; colCount < trainingTable.getCellCount(rowCount);colCount++ ){
				trainingTable.clearCell(rowCount, colCount);
			}
		}
	}
	
	public void setLatest(){
		cleanTable();
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd-MM-yyyy");
		String date = dtf.format(new Date());
		rcpServiceAsync.getSavedTrainingObjects("01-01-1900",date, KalorieVagtenUser.getInstance().getUserId(), 10, new AsyncCallback<List>(){
            final InfoPanel ip = InfoPanel.getInstance();
			@Override
			public void onFailure(Throwable caught) {
				ip.setLoginText(kvc.error()+": "+ caught.toString());
				
			}

			@Override
			public void onSuccess(List result) {
				TraningTable tt = TraningTable.getInstance();
				tt.setLatestSessionstoTable(result);
				ip.setLoginText(kvc.gotLastSessions());
			}});
	}

	public TextBox getDateBox() {
		return dateBox;
	}

	public void setDateBox(TextBox dateBox) {
		this.dateBox = dateBox;
	}

	public ListBox getTypeBox() {
		return typeBox;
	}

	public void setTypeBox(ListBox typeBox) {
		this.typeBox = typeBox;
	}

	public TextBox getTimeBox() {
		return timeBox;
	}

	public void setTimeBox(TextBox timeBox) {
		this.timeBox = timeBox;
	}

	public TextBox getMaxBox() {
		return maxBox;
	}

	public void setMaxBox(TextBox maxBox) {
		this.maxBox = maxBox;
	}

	public TextBox getAtBox() {
		return atBox;
	}

	public void setAtBox(TextBox atBox) {
		this.atBox = atBox;
	}

	public TextBox getSubAtBox() {
		return subAtBox;
	}

	public void setSubAtBox(TextBox subAtBox) {
		this.subAtBox = subAtBox;
	}

	public TextBox getPowerBox() {
		return powerBox;
	}

	public void setPowerBox(TextBox powerBox) {
		this.powerBox = powerBox;
	}

	public TextBox getStrenghtBox() {
		return strenghtBox;
	}

	public void setStrenghtBox(TextBox strenghtBox) {
		this.strenghtBox = strenghtBox;
	}

	public TextBox getCommentBox() {
		return commentBox;
	}

	public void setCommentBox(TextBox commentBox) {
		this.commentBox = commentBox;
	}
	
	public void showError(){
		
	}

	/**
	 * @return the baseBox
	 */
	public TextBox getBaseBox() {
		return baseBox;
	}

	/**
	 * @param baseBox the baseBox to set
	 */
	public void setBaseBox(TextBox baseBox) {
		this.baseBox = baseBox;
	}

	/**
	 * @return the distBox
	 */
	public TextBox getDistBox() {
		return distBox;
	}

	/**
	 * @param distBox the distBox to set
	 */
	public void setDistBox(TextBox distBox) {
		this.distBox = distBox;
	}

	/**
	 * @return the energyBox
	 */
	public TextBox getEnergyBox() {
		return energyBox;
	}

	/**
	 * @param energyBox the energyBox to set
	 */
	public void setEnergyBox(TextBox energyBox) {
		this.energyBox = energyBox;
	}
}
