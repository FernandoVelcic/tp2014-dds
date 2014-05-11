package com.grupo10;

import java.util.Date;

public class Administrador {
	public Partido CrearPartido(Date datetime) {
		return new Partido(datetime);
	}
}
