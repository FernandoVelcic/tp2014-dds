package com.grupo10;

import java.util.ArrayList;
import java.util.List;

import Modalidades.*;

public class Jugador implements Observador {
	private List<Jugador> amigos = new ArrayList<Jugador>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private Notificaciones emails = new Notificaciones();
	public Participante participante;
	
	public void hacerInfraccion(String motivo)
	{
		infracciones.add(new Infraccion(motivo));
	}
	
	public void notificarAamigos()
	{
		amigos.forEach(a -> a.notificarJuegaAmigo());
	}
	
	@Override
	public void notificarJuegaAmigo()
	{
		emails.notificar("Juega un amigo");
	}

	@Override
	public void notificarPartidoConfirmado() {

	}

	@Override
	public void notificarFaltanJugadores() {
		
	}
}
