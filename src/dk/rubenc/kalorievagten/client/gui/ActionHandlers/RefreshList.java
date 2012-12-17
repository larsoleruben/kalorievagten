package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.TraningTable;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class RefreshList implements ClickHandler, KeyUpHandler {
    
	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	
	@Override
	public void onKeyUp(KeyUpEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(ClickEvent event) {
		final RpcServiceAsync rcpServiceAsync = Rpc.init();
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd-MM-yyyy");
		String dateTo = dtf.format(new Date());
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
		wh.onWait();
		if (KalorieVagtenUser.getInstance().isLoggedIn()) {
			rcpServiceAsync.getSavedTrainingObjects("01-01-1900", dateTo, KalorieVagtenUser
					.getInstance().getUserId(), 10, new AsyncCallback<List>() {
				final InfoPanel ip = InfoPanel.getInstance();

				@Override
				public void onFailure(Throwable caught) {
					ip.setLoginText(kvc.error() + ": " + caught.toString());
					wh.onNoWait();
				}

				@Override
				public void onSuccess(List result) {
					TraningTable tt = TraningTable.getInstance();
					tt.cleanTable();
					if (result != null) {
						tt.setLatestSessionstoTable(result);
						ip.setLoginText(kvc.gotLastSessions());
					} else {
						ip.setLoginText(kvc.getUnsuccesful());
					}
					wh.onNoWait();
				}
			});
		}
	}
}
