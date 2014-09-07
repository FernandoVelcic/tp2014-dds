package com.grupo10.juego;

import java.util.Date;

import org.uqbar.commons.utils.Observable;

@Observable
public class Infraccion {
	private Date date;
	private String motivo;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Infraccion(String motivo) {
		date = new Date();
		this.motivo = motivo;
	}

}
