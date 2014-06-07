package com.grupo10.juego;

import java.util.Date;

public class Rechazo {
	String motivo;
	Date date;
	Participante participante;
	
	public Rechazo(Participante participante, String motivo)
	{
		this.participante = participante;
		this.date = new Date();
		this.motivo = motivo;
	}
}
