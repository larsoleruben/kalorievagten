/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author laoch
 *
 */
public class TabPanelPart extends Composite {
	
	private VerticalPanel pWidget = new VerticalPanel();
	private TabbedPane tp = new TabbedPane();
	
	public TabPanelPart(){
		pWidget.add(tp);
		initWidget(pWidget);
		pWidget.setSize("100%", "100%");
	}

}
