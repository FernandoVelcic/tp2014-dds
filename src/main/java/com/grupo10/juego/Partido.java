package com.grupo10.juego;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.grupo10.modalidades.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Partido {
	@Id @GeneratedValue
	private Long id;
	
	@Transient
	public List<Participante> participantes = new ArrayList<Participante>();
	@Transient
	public List<Participante> jugadores = new ArrayList<Participante>();
	
	//@OneToMany
	@Transient
	public List<Participante> equipo1 = new ArrayList<Participante>();
	//@OneToMany
	@Transient
	public List<Participante> equipo2 = new ArrayList<Participante>();
	
	@Transient
	private List<Observador> observadores = new ArrayList<Observador>();

	private LocalDate fecha;

	public Partido(LocalDate fecha, Administrador admin) {
		this.fecha = fecha;
		addObservador(admin);
		admin.setPartido(this);
	}

	public void inscribirJugador(Participante participante) {
		participantes.add(participante);
		participante.notificarAamigos();
		participante.partidoActualAjugar = this;
	}
	
	private void removeJugador(Participante participante) {
		jugadores.remove(participante);
		participantes.remove(participante);
	}
	
	public void darBajaJugador(Participante participante) {
		removeJugador(participante);
		participante.hacerInfraccion("Por no asistir al partido ni proponer un reemplazo");
		observadores.forEach(observador -> observador.notificarFaltanJugadores());
	}
	
	public void darBajaJugadorYProponerReemplazo(Participante participante, Participante reemplazo) {
		removeJugador(participante);
		reemplazo.setModalidad(participante.modalidad);
		participantes.add(reemplazo);
	}

	public void generarJugadores() {
		jugadores = participantes.stream()
			.filter(p -> p.getPuedeJugar(this))
			.sorted((p1,p2) -> Integer.compare(p1.getPrioridadModalidad(), p2.getPrioridadModalidad()))
			.limit(10)
			.collect(Collectors.toList());
		
		notificarPartidoConfirmado();
	}
	
	public void notificarPartidoConfirmado() {
		if(jugadores.size() == 10)
			observadores.forEach(observador -> observador.notificarPartidoConfirmado());
	}
	
	public Integer calcularConfirmados() {
		return (int) obtenerConfirmados().count();
	}

	private Stream<Participante> obtenerConfirmados() {
		return participantes.stream().filter(p -> p.getPrioridadModalidad() == Prioridad.ESTANDAR.ordinal());
	}
	
	public void addObservador(Observador obs) {
		observadores.add(obs);
	}
}
