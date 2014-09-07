package com.grupo10.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.grupo10.juego.Participante;
import com.uqbar.commons.collections.Transformer;

public final class DateToStringTransformer implements Transformer<Participante, String>{
	
	public String convertirFechaAString(Date fecha){
		String patron = "dd/MM/yyyy";
	    SimpleDateFormat formato = new SimpleDateFormat(patron);
	    formato.format(fecha);
		return formato.format(fecha);
	}
	
	@Override
	public String transform(Participante participante) {
		return convertirFechaAString(participante.getFechaNacimiento());
	}
}
