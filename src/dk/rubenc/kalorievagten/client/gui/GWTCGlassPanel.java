package dk.rubenc.kalorievagten.client.gui;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.*;

/**
 * <p><b>A panel that covers the document area with a semitransparent 
 * layer in order to avoid user interaction with the application's elements.</b></p>
 * 
 * @author Manuel Carrasco Mo̱ino
 * 
 * <h3>CSS Style Rules</h3> 
 * <ul> 
 *  <li>.GWTCGlassPanel { Panel }</li> 
 *  <li>size and z-index are setted by code</li> 
 * </ul>
 * 
 */

public class GWTCGlassPanel extends FocusPanel {


	  private String style = "GWTCGlassPanel";
	  private int zIndex = 998;

	  public GWTCGlassPanel() {
	    super();
	    addStyleName(style);
	    setZIndex(zIndex);
	  }

	  /**
	   * Show the layer and maximizes it into all available area
	   */
	  public void show() {
	    if (!isAttached()) {
	      RootPanel.get().add(this, 0, 0);
	    }
	    setVisible(true);
	    GWTCHelper.maximizeWidget(this);
	  }

	  /**
	   * Hide the layer
	   */
	  public void hide() {
	    setSize("0px", "0px");
	    setVisible(false);
	  }

	  /**
	   * Set the zIndex value
	   * 
	   * @param z
	   */
	  public void setZIndex(int z) {
	    DOM.setStyleAttribute(getElement(), "zIndex", String.valueOf(zIndex));
	  }
	}
