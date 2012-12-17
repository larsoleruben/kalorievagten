package dk.rubenc.kalorievagten.shared;


import java.util.Date;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

public class KVUtil {

	public static Date getDate(String date) {
		DateTimeFormat dtf = DateTimeFormat.getFormat("dd-MM-yyyy HH:mm:ss");
		return dtf.parse(date + " 01:01:00");
	}

	public static int nvlInt(String nvlValue) {
		int val = 0;
		if (nvlValue == null) {
			val = 0;
		} else {
			try {
				val = Integer.parseInt(nvlValue);
			} catch (NumberFormatException nfe) {
				val = 0;
			}
		}
		return val;
	}
	
	public static float nvlFloat(String nvlValue) {
		float val = 0;
		if (nvlValue == null) {
			val = 0;
		} else {
			try {
				val = Float.parseFloat(nvlValue);
			} catch (NumberFormatException nfe) {
				val = 0;
			}
		}
		return val;
	}
	
	public static double nvlDouble( Double nvlValue){
		Double val = 0.0;
		if( nvlValue == null ){
			val = 0.0;
		}else
		{
			val = nvlValue;
		}
		
		return val;
	}
	
	public static String format( Double number ){
		NumberFormat formatter = NumberFormat.getFormat("#####.#");
		return formatter.format(number);
	}
}
