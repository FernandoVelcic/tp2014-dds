package com.grupo10.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import com.grupo10.homes.HomeJugadores;
import com.grupo10.juego.Participante;

@Observable
public class BusquedaJugadoresViewModel implements Serializable{
	private String nombre;
	private String apodo;
	private String fechaString;
	private Date fechaNacimientoHasta;
	private Integer handicapDesde, handicapHasta;
	private Double promedioDesde, promedioHasta;
	private boolean tieneInfracciones;
	private boolean noTieneInfracciones;

	private List<Participante> resultados;
	private Participante participanteSeleccionado;

	public void search() {
		this.resultados = HomeJugadores.getInstance().search(this.nombre, this.apodo, this.handicapDesde, this.handicapHasta, this.promedioDesde, this.promedioHasta, this.fechaString, this.tieneInfracciones, this.noTieneInfracciones);
	}

	public void clear() {
		this.nombre = "";
		this.apodo = "";
		this.fechaNacimientoHasta = null;
		this.handicapDesde = null;
		this.handicapHasta = null;
		this.promedioDesde = null;
		this.promedioHasta = null;
		this.tieneInfracciones = false;
		this.noTieneInfracciones = false;
		search();
	}

	public Date getFechaNacimientoHasta() {
		return fechaNacimientoHasta;
	}

	public void setFechaNacimientoHasta(Date fechaNacimientoHasta) {
		this.fechaNacimientoHasta = fechaNacimientoHasta;
	}

	public Integer getHandicapDesde() {
		return handicapDesde;
	}

	public void setHandicapDesde(Integer handicapDesde) {
		this.handicapDesde = handicapDesde;
	}

	public Integer getHandicapHasta() {
		return handicapHasta;
	}

	public void setHandicapHasta(Integer handicapHasta) {
		this.handicapHasta = handicapHasta;
	}

	public Double getPromedioDesde() {
		return promedioDesde;
	}

	public void setPromedioDesde(Double promedioDesde) {
		this.promedioDesde = promedioDesde;
	}

	public Double getPromedioHasta() {
		return promedioHasta;
	}

	public void setPromedioHasta(Double promedioHasta) {
		this.promedioHasta = promedioHasta;
	}
	
	public String getFechaString() {
		return fechaString;
	}

	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
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

	public boolean getTieneInfracciones() {
		return tieneInfracciones;
	}

	public void setTieneInfracciones(boolean tieneInfracciones) {
		this.tieneInfracciones = tieneInfracciones;
	}
	
	public boolean isNoTieneInfracciones() {
		return noTieneInfracciones;
	}

	public void setNoTieneInfracciones(boolean noTieneInfracciones) {
		this.noTieneInfracciones = noTieneInfracciones;
	}

}
