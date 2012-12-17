package dk.rubenc.kalorievagten.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.InfoPanel;
import dk.rubenc.kalorievagten.client.gui.MainPanel;
import dk.rubenc.kalorievagten.client.gui.PersonTable;
import dk.rubenc.kalorievagten.client.gui.TraningTable;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.WaitHandler;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;
import dk.rubenc.kalorievagten.client.rpc.Rpc;
import dk.rubenc.kalorievagten.client.rpc.RpcServiceAsync;

public class Kalorievagten implements EntryPoint {

	private final RpcServiceAsync rcpServiceAsync = Rpc.init();

	public void onModuleLoad() {
		final WaitHandler wh = WaitHandler.getInstance();
        wh.setRootPanel(RootPanel.get("content"));
        wh.onWait();
		final MainPanel mainPanel = new MainPanel();
		RootPanel.get("content").add(mainPanel);
		final InfoPanel ip = InfoPanel.getInstance();
		final PersonTable pt = PersonTable.getInstance();
		final TraningTable tt = TraningTable.getInstance();
		rcpServiceAsync.checkLogin(new AsyncCallback<KalorieVagtenUser>() {
			
			KalorieVagtenUser kUser = KalorieVagtenUser.getInstance();

			public void onFailure(Throwable caught) {
				// RootPanel.get("loginContainer").add(new
				// HTML("Not logged in or connected"));
				ip.setLoginText("Der mangler desværre forbindelse til Kalorievagtens server");
				wh.onNoWait();
			}

			public void onSuccess(KalorieVagtenUser result) {
				kUser.setLoggedIn(result.isLoggedIn());
				kUser.setEmail(result.getEmail());
				kUser.setAddress(result.getAddress());
				kUser.setBmi(result.getBmi());
				kUser.setCity(result.getCity());
				kUser.setfName(result.getfName());
				kUser.setHeight(result.getHeight());
				kUser.setLogInUrl(result.getLogInUrl());
				kUser.setSex(result.getSex());
				kUser.setsName(result.getsName());
				kUser.setZipCode(result.getZipCode());
				kUser.setUserId(result.getUserId());
				kUser.setWeight(result.getWeight());
				kUser.setPressure(result.getPressure());
				kUser.setUnitEnergyIso(result.getUnitEnergyIso());
				kUser.setUnitEnergyKcal(result.getUnitEnergyKcal());
				if (result.isLoggedIn()) {
					ip.setLoginText("Hej \n" + result.getEmail()
							+ "\nDu er logget ind på din google konto");
					pt.displayUserDetails();
					tt.setLatest();
					
				} else {
					RootPanel.get("loginContainer").add(
							new HTML(result.getLogInUrl()));
					ip.setLoginText("Du skal logge ind på din google konto ved at følge linket øverste på siden");
				}
				wh.onNoWait();
			}
		});
	}

}
