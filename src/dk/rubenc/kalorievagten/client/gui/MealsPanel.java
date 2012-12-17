package dk.rubenc.kalorievagten.client.gui;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dk.rubenc.kalorievagten.client.gui.ActionHandlers.AddIngreedientToPopUp;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.DateHandler;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.GetConsumedDate;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.GetIngreedients;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.RemoveConsumed;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.SaveConsumedDate;
import dk.rubenc.kalorievagten.client.gui.ActionHandlers.ToolTipHandler;
import dk.rubenc.kalorievagten.client.model.IngreedientsCli;
import dk.rubenc.kalorievagten.shared.ConsumedSummator;
import dk.rubenc.kalorievagten.shared.KVUtil;
import dk.rubenc.kalorievagten.shared.KvConstants_dk;

public class MealsPanel extends Composite {

	/*
	 * Due to confusion everything that has to do with the collected ingreedient
	 * gets the leading letters svr_ And everything the has to do with daily
	 * consumption get the leading letters con_
	 */

	HorizontalPanel hp = new HorizontalPanel();
	VerticalPanel getAndAddIngreedients = new VerticalPanel();
	VerticalPanel con_vpDailyCons = new VerticalPanel();
	VerticalPanel summation = new VerticalPanel();

	TextBox svr_textBoxSearch = new TextBox();
	TextBox con_textBoxDate = new TextBox();

	Button svr_getDay = new Button("Hent Dag");
	Button con_saveDay = new Button("Gem dag");

	ListBox svr_listBoxIngreedients = new ListBox();
	ListBox con_listBoxIngreedients = new ListBox();
	FlexTable svr_flexTableIngreedients = new FlexTable();
	FlexTable con_flexTableConsumed = new FlexTable();
	FlexTable con_flexTableSummation = new FlexTable();

	KvConstants_dk kvConstants = (KvConstants_dk) GWT
			.create(KvConstants_dk.class);

	List<IngreedientsCli> svr_ingreedientListFromDb = new LinkedList<IngreedientsCli>();
	LinkedList<IngreedientsCli> con_ingreedientsList;
	
	class OurChangeEvent extends ChangeEvent {};

	public MealsPanel() {
		con_saveDay.addClickHandler(new SaveConsumedDate(this));
		svr_getDay.addClickHandler(new GetConsumedDate(this));
		con_saveDay.setWidth("94px");
		con_ingreedientsList = new LinkedList<IngreedientsCli>();
		con_textBoxDate.setReadOnly(true);
		/*
		 * TODO set text ind fra resource filen
		 * */
		con_textBoxDate.addMouseOverHandler(new ToolTipHandler("Klik for at indsætte dato fra kalendar", 1500, this.con_textBoxDate));
		con_textBoxDate.addClickHandler(new DateHandler(con_textBoxDate));
		con_textBoxDate.setText(DateTimeFormat.getFormat("dd-MM-yyyy").format(new Date()));
		con_textBoxDate.addChangeHandler(new GetConsumedDate(this));
		con_textBoxDate.setWidth("85px");
		con_listBoxIngreedients.setVisibleItemCount(20);
		con_listBoxIngreedients.setSize("200px", "252px");
		con_listBoxIngreedients.addDoubleClickHandler(new RemoveConsumed(this));
		con_flexTableConsumed.setText(0, 0, kvConstants.consumed());
		con_flexTableConsumed.setText(1, 0, "Dato: ");
		con_flexTableConsumed.setWidget(1, 1, con_textBoxDate);
		con_flexTableConsumed.setWidget(2, 0, svr_getDay);
		con_flexTableConsumed.setWidget(2, 1, con_saveDay);
		FlexCellFormatter formatter = con_flexTableConsumed
				.getFlexCellFormatter();
		formatter.setColSpan(3, 0, 2);
		con_flexTableConsumed.setWidget(3, 0, con_listBoxIngreedients);
		con_vpDailyCons.add(con_flexTableConsumed);
		FlexCellFormatter fcf = svr_flexTableIngreedients
				.getFlexCellFormatter();
		fcf.setColSpan(0, 0, 2);
		svr_textBoxSearch.setWidth("191px");
		svr_textBoxSearch.addKeyUpHandler(new GetIngreedients(this));
		svr_listBoxIngreedients.setVisibleItemCount(20);
		svr_listBoxIngreedients.setSize("200px", "280px");
		svr_listBoxIngreedients.addDoubleClickHandler(new AddIngreedientToPopUp(this));
		svr_flexTableIngreedients.setText(0, 0, kvConstants.ingreedients());
		svr_flexTableIngreedients.setText(1, 0, "Søge ord: ");
		svr_flexTableIngreedients.setWidget(1, 1, svr_textBoxSearch);
		svr_flexTableIngreedients.setWidget(2, 1, svr_listBoxIngreedients);
		getAndAddIngreedients.add(svr_flexTableIngreedients);
		con_flexTableSummation.setTitle("Totalt Indtag på områder");
		con_flexTableSummation.setText(0, 0, "Sum for dag");
		con_flexTableSummation.setText(1, 0, "Indtag af");
		con_flexTableSummation.setText(1, 1, "Sum");
		summation.add(con_flexTableSummation);
		hp.add(getAndAddIngreedients);
		hp.add(con_vpDailyCons);
		hp.add( summation );
		initWidget(hp);
		con_textBoxDate.fireEvent(new OurChangeEvent());
	}

	public TextBox getTbSearch() {
		return svr_textBoxSearch;
	}

	public ListBox getLbIngreedients() {
		return svr_listBoxIngreedients;
	}

	public List<IngreedientsCli> getIngreedientList() {
		return svr_ingreedientListFromDb;
	}

	public void setSvrIngreedientList(List<IngreedientsCli> svr_ingreedientList) {
		this.svr_ingreedientListFromDb.clear();
		this.svr_ingreedientListFromDb = svr_ingreedientList;
		this.svr_listBoxIngreedients.clear();
		for (IngreedientsCli ic : svr_ingreedientList) {
			this.svr_listBoxIngreedients.addItem(ic.getNameDanish(),
					String.valueOf(ic.getId()));
		}
	}

	public void addConsumedIngreedientL(IngreedientsCli ingreedient) {
		this.con_listBoxIngreedients.addItem( ingreedient.getGrams() + " gr. "
						+ ingreedient.getNameDanish() + " "
						+ ingreedient.getEnergy() * ingreedient.getGrams()
						/ 100 + " KJ", String.valueOf(ingreedient.getId()));
		con_ingreedientsList.add(ingreedient);
		updateSummatedValues();
	}

	public void removeConsumedIngreedient(int index, String id) {

		try {
			this.con_listBoxIngreedients.removeItem(index);
			for (IngreedientsCli ic : this.con_ingreedientsList) {
				if (ic.getId().equals(new Long(id))) {
					con_ingreedientsList.remove(ic);
				}
				updateSummatedValues();
			}
		} catch (Exception e) {
			//To avoid ConcurrentModificationException.
			//Must be an error in the framework?
			//Or it is not ment to be used like this?
			//TODO change to a button outside the listbox.
			System.out.println(e.toString());
		}
	}
	
	public void updateSummatedValues(){
		ConsumedSummator cs = new ConsumedSummator();
		cs.summate( con_ingreedientsList);
		con_flexTableSummation.setText(2, 0, "Energi");
		con_flexTableSummation.setText(2, 1, KVUtil.format(cs.getEnergy()));
		con_flexTableSummation.setText(2, 2, "kj");
		con_flexTableSummation.setText(3, 0, "Fedt");
		con_flexTableSummation.setText(3, 1, KVUtil.format(cs.getFat()));
		con_flexTableSummation.setText(3, 2, "gram");
		con_flexTableSummation.setText(4, 0, "Kulhydrater");
		con_flexTableSummation.setText(4, 1, KVUtil.format(cs.getCarbonHydrate()));
		con_flexTableSummation.setText(4, 2, "gram");
		con_flexTableSummation.setText(5, 0, "Protein");
		con_flexTableSummation.setText(5, 1, KVUtil.format(cs.getProtein()));
		con_flexTableSummation.setText(5, 2, "gram");
		con_flexTableSummation.setText(6, 0, "Alkohol");
		con_flexTableSummation.setText(6, 1, KVUtil.format(cs.getAlcohol()));
		con_flexTableSummation.setText(6, 2, "gram");
		con_flexTableSummation.setText(7, 0, "Vand");
		con_flexTableSummation.setText(7, 1, KVUtil.format(cs.getWater()));
		con_flexTableSummation.setText(7, 2, "gram");
		con_flexTableSummation.setText(8, 0, "Fibre");
		con_flexTableSummation.setText(8, 1, KVUtil.format(cs.getDietaryFibre()));
		con_flexTableSummation.setText(8, 2, "gram");
		con_flexTableSummation.setText(9, 0, "Kollesterol");
		con_flexTableSummation.setText(9, 1, KVUtil.format(cs.getCholesterol()));
		con_flexTableSummation.setText(9, 2, "milli-gram");
		con_flexTableSummation.setText(10, 0, "Mættede fedtsyrer");
		con_flexTableSummation.setText(10, 1, KVUtil.format(cs.getSaturatedFattyAcid()));
		con_flexTableSummation.setText(10, 2, "gram");
		con_flexTableSummation.setText(11, 0, "Monoumætt. fedtsyrer");
		con_flexTableSummation.setText(11, 1, KVUtil.format(cs.getMonoSaturatedFattyAcid()));
		con_flexTableSummation.setText(11, 2, "gram");
		con_flexTableSummation.setText(12, 0, "Polyumætt. fedtsyrer");
		con_flexTableSummation.setText(12, 1, KVUtil.format(cs.getPolySaturatedFattyAcid()));
		con_flexTableSummation.setText(12, 2, "gram");
		con_flexTableSummation.setText(12, 0, "Natrium");
		con_flexTableSummation.setText(12, 1, KVUtil.format(cs.getNatrium()));
		con_flexTableSummation.setText(12, 2, "milli-gram");
		con_flexTableSummation.setText(13, 0, "Kalium");
		con_flexTableSummation.setText(13, 1, KVUtil.format(cs.getPotassium()));
		con_flexTableSummation.setText(13, 2, "milli-gram");
		con_flexTableSummation.setText(14, 0, "Magnesium");
		con_flexTableSummation.setText(14, 1, KVUtil.format(cs.getMagnesium()));
		con_flexTableSummation.setText(14, 2, "micro-gram");
		con_flexTableSummation.setText(15, 0, "Jern");
		con_flexTableSummation.setText(15, 1, KVUtil.format(cs.getIron()));
		con_flexTableSummation.setText(15, 2, "micro-gram");
	}

	public ListBox getConsumedIngreedients() {
		return con_listBoxIngreedients;
	}

	public LinkedList<IngreedientsCli> getConsumedIngreedientsList() {
		return con_ingreedientsList;
	}

	public void setConsumedIngreedientsList(LinkedList<IngreedientsCli> consumedList) {
		this.con_ingreedientsList.clear();
		this.con_listBoxIngreedients.clear();
		// Expose them in the textarea
		for (IngreedientsCli icli : consumedList) {
			if (icli != null) {
				addConsumedIngreedientL(icli);
			}
		}
	}

	public TextBox getTbDate() {
		return con_textBoxDate;
	}

	public ListBox getCon_listBoxIngreedients() {
		return con_listBoxIngreedients;
	}

	public void setCon_listBoxIngreedients(ListBox con_listBoxIngreedients) {
		this.con_listBoxIngreedients = con_listBoxIngreedients;
	}
}
