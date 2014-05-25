package com.grupo10;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import Modalidades.*;

public class Participante implements Observador {
	public List<Participante> amigos = new ArrayList<Participante>();
	public List<Infraccion> infracciones = new ArrayList<Infraccion>();
	public List<String> notificaciones = new ArrayList<String>();
	
	String nombre;
	Date fechaNacimiento;
	Modalidad modalidad = new Estandar();
	
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
		amigos.forEach(amigo -> amigo.notificaciones.add(this +"se inscribió"));
	}

	@Override
	public void notificarPartidoConfirmado(){

	}

	@Override
	public void notificarFaltanJugadores(){
		
	}
	
	@Override
	public void notificarRechazo(){
		
	}
}
