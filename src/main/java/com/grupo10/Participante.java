package com.grupo10;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Modalidades.*;

public class Participante implements Observador {
	private List<Participante> amigos = new ArrayList<Participante>();
	private List<Infraccion> infracciones = new ArrayList<Infraccion>();
	private Notificaciones emails = new Notificaciones();
	
	String nombre;
	Date fechaNacimiento;
	Modalidad modalidad;
	
	public void setModalidad(Modalidad modalidad){
		this.modalidad = modalidad;
	}
	
	public int getPrioridadModalidad() {
		return modalidad.getPrioridad();
	}
	
	public boolean getPuedeJugar(Partido partido) {
		return modalidad.isPuedeJugar(partido);
	}
	
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
	
	@Override
	public void notificarRechazo() {
		
	}
}
