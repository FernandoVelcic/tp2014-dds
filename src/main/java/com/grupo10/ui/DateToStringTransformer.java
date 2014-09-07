package com.grupo10.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringTransformer {
	
	public String convertirFechaAString(Date fecha){
		String patron = "dd/MM/yyyy";
	    SimpleDateFormat formato = new SimpleDateFormat(patron);
	    formato.format(fecha);
		return formato.format(fecha);
	}
}
