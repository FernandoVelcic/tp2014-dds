package com.grupo10;

import java.util.Date;

public class Infraccion {
	private Date date;
	private String motivo;
	
	public Infraccion(String motivo) {
		date = new Date();
		this.motivo = motivo;
	}

}
