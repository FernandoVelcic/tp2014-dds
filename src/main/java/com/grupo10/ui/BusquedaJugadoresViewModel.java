package com.grupo10.ui;

import java.io.Serializable;
import java.util.List;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import com.grupo10.homes.HomeJugadores;
import com.grupo10.juego.Participante;

@Observable
public class BusquedaJugadoresViewModel implements Serializable{
	private String nombre;
	private String apodo;
	private List<Participante> resultados;
	private Participante participanteSeleccionado;

	public void search() {
		this.resultados = HomeJugadores.getInstance().search(this.nombre, this.apodo);
	}

	public void clear() {
		this.nombre = "";
		this.apodo = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public List<Participante> getResultados() {
		return resultados;
	}

	public void setResultados(List<Participante> resultados) {
		this.resultados = resultados;
	}

	public Participante getParticipanteSeleccionado() {
		return participanteSeleccionado;
	}

	public void setParticipanteSeleccionado(Participante participanteSeleccionado) {
		this.participanteSeleccionado = participanteSeleccionado;
	}
	
	public void verJugador(WindowOwner owner) {
		new JugadorView(owner, participanteSeleccionado).open();
	}
}
