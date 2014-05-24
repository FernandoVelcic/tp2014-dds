package com.grupo10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador implements Observador {
	Notificaciones emails = new Notificaciones();
	
	@Override
	public void notificarPartidoConfirmado()
	{
		emails.notificar("Partido confirmado");
	}
	
	@Override
	public void notificarFaltanJugadores()
	{
		emails.notificar("Faltan jugadores");
	}

	@Override
	public void notificarJuegaAmigo() {
		
	}

	@Override
	public void notificarRechazo() {

	}
}
