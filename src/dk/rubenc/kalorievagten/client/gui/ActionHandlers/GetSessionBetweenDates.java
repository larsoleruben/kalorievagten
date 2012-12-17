package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.TraningTable;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class GetSessionBetweenDates implements ClickHandler {

	TextBox dateFrom = null;
	TextBox dateTo = null;
	KvConstants_dk kvConstants = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	public GetSessionBetweenDates( TextBox dateFrom, TextBox dateTo){
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		final RpcServiceAsync rcpServiceAsync = Rpc.init();
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
		wh.onWait();
		if (KalorieVagtenUser.getInstance().isLoggedIn()) {
			rcpServiceAsync.getSavedTrainingObjects(dateFrom.getText(), dateTo.getText(), KalorieVagtenUser
					.getInstance().getUserId(), 100, new AsyncCallback<List>() {
				final InfoPanel ip = InfoPanel.getInstance();

				@Override
				public void onFailure(Throwable caught) {
					ip.setLoginText(kvConstants.error() + caught.toString());
					wh.onNoWait();
				}

				@Override
				public void onSuccess(List result) {
					TraningTable tt = TraningTable.getInstance();
					tt.cleanTable();
					if (result != null) {
						tt.setLatestSessionstoTable(result);
						ip.setLoginText(kvConstants.trainingBetween()+dateFrom.getText()+ " og "+dateTo.getText());
					} else {
						ip.setLoginText(kvConstants.getSuccesful());
					}
					wh.onNoWait();
				}
			});
		}
	}

}
