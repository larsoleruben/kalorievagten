/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui;

import com.google.gwt.i18n.client.LocalizableResource.DefaultLocale;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author laoch
 *
 */

public class InfoPanel extends Composite {
	
	private VerticalPanel pWidget = new VerticalPanel();
	
	private TextArea loginsStatus = new TextArea( );;
	private InfoPanel( )
	{
		pWidget.add(loginsStatus);
		loginsStatus.setWidth("140px");
		loginsStatus.setHeight("350px");
		loginsStatus.setEnabled(false);
		loginsStatus.setTitle("Information");
		initWidget(pWidget);
	}
	
	private static class InfoPanelHolderHolder { 
	     public static final InfoPanel INSTANCE = new InfoPanel();
	}
	
	public static InfoPanel getInstance() {
	     return InfoPanelHolderHolder.INSTANCE;
	   }

	public String getLoginText() {
		return loginsStatus.getText();
	}



	public void setLoginText(String loginText) {
		this.loginsStatus.setText(loginText + "\n" + "------" + "\n" + loginsStatus.getText());
	}
	
	

}
