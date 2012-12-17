package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ToolTipHandler implements MouseOverHandler{

	private String toolTip;
	private int delay;
	private Widget sender;
	private PopupPanel pop;
	public ToolTipHandler( String toolTip, int delay, Widget sender ){
		this.toolTip = toolTip;
		this.delay = delay;
		this.sender = sender;
	}
	
	@Override
	public void onMouseOver(MouseOverEvent event) {
		final PopupPanel pp = new PopupPanel();
		pp.add(new HTML(toolTip));
		TextBoxMouseOutHandler tmo = new TextBoxMouseOutHandler(pp);
		TextBox tb = (TextBox) sender;
		tb.addMouseOutHandler(tmo);
		//pp.setAnimationEnabled(true);
		pp.setPopupPosition(sender.getAbsoluteLeft()+sender.getOffsetWidth()+1, sender.getAbsoluteTop()-sender.getOffsetHeight()-15);
		pp.setStyleName("popups-Popup");
		pp.show();
		//popupHolder(pp);
		Timer t = new Timer(){

			@Override
			public void run() {
				pp.hide();
			}
		};
		t.schedule(delay);
		tmo = null;
		//System.gc();
	}
	
	private class TextBoxMouseOutHandler implements MouseOutHandler{
		
		private PopupPanel pop;
		public TextBoxMouseOutHandler( PopupPanel pop ){
			this.pop = pop;
		}
		
		@Override
		public void onMouseOut(MouseOutEvent event) {
			pop.hide();
		}
		
	}
}
