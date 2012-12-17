/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;

/**
 * @author laoch
 *
 */
public class MainPanel extends Composite {

	private DockPanel dp = new DockPanel();
	
	private InfoPanel lai = InfoPanel.getInstance() ;
	private TabPanelPart tpp = new TabPanelPart();
	
	public MainPanel(){
		dp.add(lai, DockPanel.WEST);
		dp.add(tpp, DockPanel.EAST);
		initWidget(dp);
		dp.setCellWidth(lai, "150px");
		dp.setCellHeight(lai, "600px");
		dp.setCellWidth(tpp, "900px");
		dp.setCellHeight(tpp, "600px");
		dp.setBorderWidth(0);
		//dp.setTitle("Kalorie og Træningsvagt");
	}

	public InfoPanel getLai() {
		return lai;
	}

	public void setLai(InfoPanel lai) {
		this.lai = lai;
	}
	
	
}
