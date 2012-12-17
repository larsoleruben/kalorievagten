/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.MealsPanel;
import dk.rubenc.kalorievagten.client.model.ConsumedDateCli;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KVUtil;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

/**
 * @author lars
 *
 */
public class SaveConsumedDate implements ClickHandler {

	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
	 */
	MealsPanel mp = null;
	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	
	public SaveConsumedDate( MealsPanel mp ){
		this.mp = mp;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		ConsumedDateCli cdc = new ConsumedDateCli();
		cdc.setConsumedList(mp.getConsumedIngreedientsList());
		cdc.setUserId(KalorieVagtenUser.getInstance().getUserId());
		cdc.setConsumedDate(KVUtil.getDate(mp.getTbDate().getText()));
		cdc.setStringDate(mp.getTbDate().getText());
		final RpcServiceAsync rcpServiceAsync = Rpc.init();
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
		wh.onWait();
		rcpServiceAsync.saveConsumedDate(cdc, new AsyncCallback<String>() {

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
			}});
	}

}
