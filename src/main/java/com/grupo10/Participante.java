package com.grupo10;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Modalidades.*;

public class Participante implements Observador {
	public List<Participante> amigos = new ArrayList<Participante>();
	public List<Infraccion> infracciones = new ArrayList<Infraccion>();
	public List<String> notificaciones = new ArrayList<String>();
	public List<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	String nombre;
	Date fechaNacimiento;
	Modalidad modalidad;
	Partido partidoActualAjugar;
	
	public void setModalidad(Modalidad modalidad){
		this.modalidad = modalidad;
	}
	
	public int getPrioridadModalidad() {
		return modalidad.getPrioridad();
	}
	
	public boolean getPuedeJugar(Partido partido) {
		return modalidad.isPuedeJugar(partido);
	}
	
	public void agregarAmigo(Participante participante){
		amigos.add(participante);
	}
	
	public void hacerInfraccion(String motivo){
		infracciones.add(new Infraccion(motivo));
	}
	
	public void notificarAamigos(){
		amigos.forEach(amigo -> amigo.notificaciones.add(this +" se inscribió"));
	}
	
	public boolean calificarA(Participante jugador, int puntaje, String critica)
	{
		if ((jugador.equals(this)) || (!partidoActualAjugar.jugadores.contains(jugador))) return false;
		else
		{
			int posicionDelJugadorEnLaLista = partidoActualAjugar.participantes.indexOf(jugador);
			if(posicionDelJugadorEnLaLista != -1)
				partidoActualAjugar.participantes.get(posicionDelJugadorEnLaLista).calificaciones.add(new Calificacion(puntaje, critica, partidoActualAjugar));
			return true;
		}
	}

	@Override
	public void notificarPartidoConfirmado(){

	}

	@Override
	public void notificarFaltanJugadores(){
		
	}
	
	@Override
	public void notificarRechazo(String motivo){
		this.notificaciones.add("Rechazaron tu solicitud por: " + motivo);
	}
}
