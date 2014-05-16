package com.grupo10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador {
	Notificaciones emails = new Notificaciones();
	
	public Partido CrearPartido(Date datetime) {
		return new Partido(datetime, this);
	}
	
	public void notificarPartidoConfirmado()
	{
		emails.notificar("Partido confirmado");
	}
	
	public void notificarFaltanJugadores()
	{
		emails.notificar("Faltan jugadores");
	}
}
