/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.MealsPanel;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

/**
 * @author LAOCH
 *
 */
public class GetIngreedients implements KeyUpHandler {

	private MealsPanel mealsPanel;
	KvConstants_dk kvConstants = (KvConstants_dk) GWT.create(KvConstants_dk.class);
	
	public GetIngreedients( MealsPanel mealsPanel ){
		this.mealsPanel = mealsPanel;
	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.KeyUpHandler#onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent)
	 */
	@Override
	public void onKeyUp(KeyUpEvent event) {
		if( event.getNativeKeyCode() == KeyCodes.KEY_ENTER && KalorieVagtenUser.getInstance().isLoggedIn()){
			getIngreedients();
		}
	}
	
	private void getIngreedients(){
		final RpcServiceAsync rcpServiceAsync = Rpc.init();
		final InfoPanel ip = InfoPanel.getInstance();
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
		wh.onWait();
		rcpServiceAsync.getIngreedients(mealsPanel.getTbSearch().getText(), 100,new AsyncCallback<List>() {

			@Override
			public void onFailure(Throwable caught) {
				ip.setLoginText(kvConstants.error() + caught.toString());
				wh.onNoWait();
			}

			@Override
			public void onSuccess(List result) {
			if( result == null || result.isEmpty() ){
				ip.setLoginText( "Ingen fødevarer matcher dine søgning" );
			}else{
				mealsPanel.setSvrIngreedientList(result);
			}
			wh.onNoWait();
				
			}});
	}

}
