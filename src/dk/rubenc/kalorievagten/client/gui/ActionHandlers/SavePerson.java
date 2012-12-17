/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.PersonTable;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;

/**
 * @author laoch
 *
 */
public class SavePerson implements ClickHandler, KeyUpHandler {

	private final RpcServiceAsync rcpServiceAsync = Rpc.init();
	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.KeyUpHandler#onKeyUp(com.google.gwt.event.dom.client.KeyUpEvent)
	 */
	@Override
	public void onKeyUp(KeyUpEvent event) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
	 */
	@Override
	public void onClick(ClickEvent event) {
		KalorieVagtenUser kvus = KalorieVagtenUser.getInstance();
		PersonTable pt = PersonTable.getInstance();
		//getting the user detail from table into the user object
		pt.setUserDetails();
		final WaitHandler wh = WaitHandler.getInstance();
		wh.setRootPanel(RootPanel.get("content"));
		wh.onWait();
		rcpServiceAsync.saveUserCredentials(kvus, new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				InfoPanel ip = InfoPanel.getInstance();
				ip.setLoginText(result);
				wh.onNoWait();
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				InfoPanel ip = InfoPanel.getInstance();
				ip.setLoginText("Ikke muligt at gemme");
				wh.onNoWait();
			}
		});
	}

}
