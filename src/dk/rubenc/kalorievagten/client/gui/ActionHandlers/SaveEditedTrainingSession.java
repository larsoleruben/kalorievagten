package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ListBox;
import dk.rubenc.kalorievagten.shared.KVUtil;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;
import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KVUtil;

public class SaveEditedTrainingSession implements ClickHandler {

	private KVTrainingSessionCli kvtc;
	private FlexTable trainingTable;
	private int row;
	
	public SaveEditedTrainingSession( KVTrainingSessionCli kvtc, FlexTable trainingTable, int row)
	{
		this.kvtc = kvtc;
		this.trainingTable = trainingTable;
		this.row = row;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
		kvtc.setAtTime(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 4)).getText()));
		kvtc.setDoneDate(KVUtil.getDate(((TextBox) trainingTable.getWidget(row, 0)).getText()));
		kvtc.setMaxTime(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 3)).getText()));
		kvtc.setPowerNumber(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 7)).getText()));
		kvtc.setStrengthTime(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 8)).getText()));
		kvtc.setSubAtTime(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 5)).getText()));
		kvtc.setTotalTimeMin(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 2)).getText()));
		kvtc.setTrainingType(((ListBox) trainingTable.getWidget(row, 1)).getSelectedIndex());
		kvtc.setComments(((TextBox) trainingTable.getWidget(row, 11)).getText());
		kvtc.setUserId(KalorieVagtenUser.getInstance().getUserId());
		kvtc.setBaseTime(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 6)).getText()));
		kvtc.setEnergy(KVUtil.nvlInt(((TextBox) trainingTable.getWidget(row, 10)).getText()));
		kvtc.setDistance(KVUtil.nvlFloat(((TextBox) trainingTable.getWidget(row, 9)).getText()));
		kvtc.setStringDoneDate(((TextBox) trainingTable.getWidget(row, 0)).getText());
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
        wh.onWait();
		final RpcServiceAsync rcpServiceAsync = Rpc.init();
		rcpServiceAsync.updateTrainingSession(kvtc,
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						InfoPanel ip = InfoPanel.getInstance();
						ip.setLoginText("Test Not saved");
						wh.onNoWait();
					}

					@Override
					public void onSuccess(String result) {
						InfoPanel ip = InfoPanel.getInstance();
						ip.setLoginText(result);
						wh.onNoWait();
					}

				});
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd-MM-yyyy");
		trainingTable.setText(row, 0, dtf.format( kvtc.getDoneDate()));
		trainingTable.setText(row, 1, ((ListBox) trainingTable.getWidget(row, 1)).getItemText(kvtc.getTrainingType()));
		trainingTable.setText(row, 2, String.valueOf(kvtc.getTotalTimeMin()));
		trainingTable.setText(row, 3, String.valueOf(kvtc.getMaxTime()));
		trainingTable.setText(row, 4, String.valueOf(kvtc.getAtTime()));
		trainingTable.setText(row, 5, String.valueOf(kvtc.getSubAtTime()));
		trainingTable.setText(row, 6, String.valueOf(kvtc.getBaseTime()));
		trainingTable.setText(row, 7, String.valueOf(kvtc.getPowerNumber()));
		trainingTable.setText(row, 8, String.valueOf(kvtc.getStrengthTime()));
		trainingTable.setText(row, 9, String.valueOf(kvtc.getDistance()));
		trainingTable.setText(row, 10, String.valueOf(kvtc.getEnergy()));
		trainingTable.setText(row, 11, kvtc.getComments());
		if(kvtc.getSessionId() != null ){
			trainingTable.setWidget(row, 12, new Label(String.valueOf(kvtc.getSessionId())));
			Button editButton = new Button(kvc.edit());
			editButton.setWidth("73px");
			EditTrainingSession ets = new EditTrainingSession(kvtc, trainingTable, row);
			HandlerRegistration hr = editButton.addClickHandler(ets);
			ets.setHr(hr);
			trainingTable.setWidget(row, 13, editButton);
		}

	}

}
