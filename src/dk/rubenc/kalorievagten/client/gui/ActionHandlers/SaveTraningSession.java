package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.TraningTable;
import dk.rubenc.kalorievagten.client.model.KVTrainingSessionCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.FieldVerifier;
import dk.rubenc.kalorievagten.shared.KVUtil;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class SaveTraningSession implements ClickHandler, KeyUpHandler {
	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);

	public SaveTraningSession() {
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		if( event.getNativeKeyCode() == KeyCodes.KEY_ENTER){
			saveTraining();
		}

	}

	@Override
	public void onClick(ClickEvent event) {
		saveTraining();
	}
	
	
	private void saveTraining(){
		KVTrainingSessionCli kvts = new KVTrainingSessionCli();
		TraningTable tt = TraningTable.getInstance();
		if (tt.getDateBox().getText() != null
				&& FieldVerifier.isDateValid(tt.getDateBox().getText())
				&& tt.getTypeBox().getSelectedIndex() != 0) {
			kvts.setAtTime(KVUtil.nvlInt(tt.getAtBox().getText()));
			kvts.setDoneDate(KVUtil.getDate(tt.getDateBox().getText()));
			kvts.setMaxTime(KVUtil.nvlInt(tt.getMaxBox().getText()));
			kvts.setPowerNumber(KVUtil.nvlInt(tt.getPowerBox().getText()));
			kvts.setStrengthTime(KVUtil.nvlInt(tt.getStrenghtBox().getText()));
			kvts.setSubAtTime(KVUtil.nvlInt(tt.getSubAtBox().getText()));
			kvts.setTotalTimeMin(KVUtil.nvlInt(tt.getTimeBox().getText()));
			kvts.setTrainingType(tt.getTypeBox().getSelectedIndex());
			kvts.setComments(tt.getCommentBox().getText());
			kvts.setUserId(KalorieVagtenUser.getInstance().getUserId());
			kvts.setBaseTime(KVUtil.nvlInt(tt.getBaseBox().getText()));
			kvts.setEnergy(KVUtil.nvlInt(tt.getEnergyBox().getText()));
			kvts.setDistance(KVUtil.nvlFloat(tt.getDistBox().getText()));
			kvts.setStringDoneDate(tt.getDateBox().getText());
			final RpcServiceAsync rcpServiceAsync = Rpc.init();
			final WaitHandler wh = WaitHandler.getInstance();
			wh.setRootPanel(RootPanel.get("content"));
			wh.onWait();
			rcpServiceAsync.saveTrainingSession(kvts,
					new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable caught) {
							InfoPanel ip = InfoPanel.getInstance();
							ip.setLoginText(kvc.notSaved());
							wh.onNoWait();
						}

						@Override
						public void onSuccess(String result) {
							InfoPanel ip = InfoPanel.getInstance();
							ip.setLoginText(result);
							wh.onNoWait();
						}

					});
			ArrayList<KVTrainingSessionCli> al = new ArrayList<KVTrainingSessionCli>();
			al.add(kvts);
			tt.addNewToTabel(kvts);
			tt.cleanFields();
			tt.getDateBox().setText(DateTimeFormat.getFormat("dd-MM-yyyy").format(new Date()));
			tt.getDateBox().setFocus(true);
		} else {
			final Button closeButton = new Button(kvc.close());
			final DialogBox dialogBox = new DialogBox();
			dialogBox.setText(kvc.upss());
			dialogBox.setAnimationEnabled(true);
			VerticalPanel dialogVPanel = new VerticalPanel();
			dialogVPanel.addStyleName("dialogVPanel");
			dialogVPanel.add(new HTML(kvc.fillError1()));
			dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
			dialogVPanel.add(closeButton);
			closeButton.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					dialogBox.hide();
				}
			});
			dialogBox.setWidget(dialogVPanel);
			dialogBox.setPopupPosition(tt.getAbsoluteLeft(), tt.getAbsoluteTop());
			dialogBox.show();
		}
	}

}
