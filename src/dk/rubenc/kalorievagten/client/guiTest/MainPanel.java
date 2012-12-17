package dk.rubenc.kalorievagten.client.guiTest;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Image;

public class MainPanel extends Composite {
	public MainPanel() {
		
		DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.EM);
		initWidget(dockLayoutPanel);
		
		TextArea textArea = new TextArea();
		dockLayoutPanel.addWest(textArea, 7.7);
		
		Image image = new Image((String) null);
		dockLayoutPanel.addNorth(image, 7.7);
		
		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		dockLayoutPanel.add(decoratedTabPanel);
	}

}
