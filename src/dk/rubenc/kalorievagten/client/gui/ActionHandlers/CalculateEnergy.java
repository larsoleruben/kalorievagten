/**
 * 
 */
package dk.rubenc.kalorievagten.client.gui.ActionHandlers;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.TextBox;

import dk.rubenc.kalorievagten.client.gui.TraningTable;
import dk.rubenc.kalorievagten.client.model.KalorieVagtenUser;



/**
 * @author laoch
 *
 */
public class CalculateEnergy implements ValueChangeHandler{

	@Override
	public void onValueChange(ValueChangeEvent event) {
	    int val = Integer.parseInt((( TextBox )event.getSource()).getText());
	    TextBox energyBox = TraningTable.getInstance().getEnergyBox();
	    int energy = 0;
	    switch( TraningTable.getInstance().getTypeBox().getSelectedIndex()){
	        case 0: energy = 0;
	        case 1: energy = 44 * val;
	    	case 2: energy = 44 * val;
	    	case 3: energy = 34 * val;
	    	case 4: energy = 34 * val;
	    	case 5: energy = 30 * val;
	    }
	    if ( KalorieVagtenUser.getInstance().getUnitEnergyIso()){
	    	energyBox.setText(String.valueOf(energy));
	    }else
	    {
	    	energyBox.setText(String.valueOf(energy/4));
	    }
	    
		
	}

}
