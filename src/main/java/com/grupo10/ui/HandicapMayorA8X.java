package com.grupo10.ui;

import com.grupo10.juego.Participante;
import java.awt.Color;
import com.uqbar.commons.collections.Transformer;

public class HandicapMayorA8X implements Transformer<Integer, Color>{
	@Override
	public Color transform(Integer handicap) {
		if (handicap > 8){
			return Color.BLUE;
		}
		return Color.WHITE;
	}
}
