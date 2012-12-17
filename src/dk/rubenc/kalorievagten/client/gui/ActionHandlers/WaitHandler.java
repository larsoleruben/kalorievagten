package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

import dk.rubenc.kalorievagten.client.gui.GWTCGlassPanel;

public class WaitHandler {

	Panel panel;
	ClickEvent event;
	GWTCGlassPanel blurAll = new GWTCGlassPanel();
	
	public WaitHandler()
	{
	}
	
	
	private static class WaitHandlerHolderHolder { 
	     public static final WaitHandler INSTANCE = new WaitHandler();
	}
	
	public static WaitHandler getInstance() {
	     return WaitHandlerHolderHolder.INSTANCE;
	   }
	
	public void onWait()
	{
		blurAll.show();
		DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "wait");
	}
	
	public void onNoWait()
	{
		DOM.setStyleAttribute(RootPanel.getBodyElement(), "cursor", "default");
		blurAll.hide();
	}
	
	public Panel getRootPanel() {
		return panel;
	}

	public void setRootPanel(Panel panel) {
		this.panel = panel;
	}
	
	public ClickEvent getEvent() {
		return event;
	}

	public void setEvent(ClickEvent event) {
		this.event = event;
	}

	
}
