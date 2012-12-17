/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui.ActionHandlers;
import java.util.Calendar;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.MealsPanel;
import dk.rubenc.kalorievagten.client.model.ConsumedDateCli;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KVUtil;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

/**
 * @author lars
 *
 */
public class GetConsumedDate implements ClickHandler, ChangeHandler {

	MealsPanel mp = null;
	KvConstants_dk kvc = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	public GetConsumedDate( MealsPanel mp ){
		this.mp = mp;
	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
	 */
	@Override
	public void onClick(ClickEvent event) {
		updateUI();
	}
	
	
	//update the UI with the stuff that is consumed on this date
	public void updateUI(){
		final RpcServiceAsync rcpServiceAsync = Rpc.init();
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
		wh.onWait();
		rcpServiceAsync.getConsumedDate(mp.getTbDate().getText(), new AsyncCallback<ConsumedDateCli>() {

			@Override
			public void onFailure(Throwable caught) {
				InfoPanel ip = InfoPanel.getInstance();
				ip.setLoginText(kvc.notSaved());
				wh.onNoWait();
			}

			@Override
			public void onSuccess(ConsumedDateCli result) {
				InfoPanel ip = InfoPanel.getInstance();
				ip.setLoginText("Data hentet med succes");
				
				if( result != null && result.getConsumedList() != null && !result.getConsumedList().isEmpty()){
					mp.setConsumedIngreedientsList(result.getConsumedList());
				}else
				{
					mp.getConsumedIngreedients().clear();
					//TODO check om fejlen ligger her
					if( mp.getConsumedIngreedientsList() != null ){
						mp.getConsumedIngreedientsList().clear();
					}
					mp.updateSummatedValues();
				}
				wh.onNoWait();
					
			}});
	}

	@Override
	public void onChange(ChangeEvent event) {
		updateUI();
	}
}
