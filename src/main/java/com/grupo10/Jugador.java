package com.grupo10;

import java.util.ArrayList;
import java.util.List;

import Modalidades.*;

public class Jugador {
	private List<Jugador> amigos = new ArrayList<Jugador>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private Notificaciones emails = new Notificaciones();
	
	int prioridad;
	int nivel;
	
	public boolean inscribirmeAPartido(Partido partido, Modalidad modalidad) {
		amigos.stream().forEach(amigo -> amigo.notificarJuegaAmigo());
		return partido.inscribirJugador(this, modalidad);
	}
	
	public void notificarJuegaAmigo()
	{
		emails.notificar("Juega un amigo");
	}
	
	public void hacerInfraccion(String motivo)
	{
		infracciones.add(new Infraccion(motivo));
	}
}
