package com.grupo10.juego;

import java.util.Date;

public class Infraccion {
	private Date date;
	private String motivo;
	
	public Infraccion(String motivo) {
		date = new Date();
		this.motivo = motivo;
	}

}
