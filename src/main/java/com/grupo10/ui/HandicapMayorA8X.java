package com.grupo10.ui;

import com.grupo10.juego.Participante;
import com.uqbar.commons.collections.Transformer;

public class HandicapMayorA8X implements Transformer<Participante, String>{
	@Override
	public String transform(Participante participante) {
		if (participante.getHandicap() > 8){
			return "X";
		}
		else {
			return "-";
		}
	}
}
