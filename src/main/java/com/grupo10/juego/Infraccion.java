package com.grupo10.juego;

import org.joda.time.LocalDate;

import org.uqbar.commons.utils.Observable;

@Observable
public class Infraccion {
	private LocalDate date;
	private String motivo;
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Infraccion(String motivo) {
		date = LocalDate.now();
		this.motivo = motivo;
	}

}
