package com.grupo10.homes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.grupo10.juego.Administrador;
import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Infraccion;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

import java.util.Date;

public class HomeJugadores implements Serializable {
	private static HomeJugadores instance;
	private List<Participante> participantes = new ArrayList<Participante>();

	public static synchronized HomeJugadores getInstance() {
		if (instance == null) {
			instance = new HomeJugadores();
		}
		return instance;
	}

	private HomeJugadores() {
		Administrador admin = new Administrador();
		Partido partido = new Partido(new Date(), admin);
		Calificacion calificacion1 = new Calificacion(1,"",partido);
		Calificacion calificacion2 = new Calificacion(2,"",partido);
		Calificacion calificacion3 = new Calificacion(3,"",partido);
		Calificacion calificacion4 = new Calificacion(4,"",partido);
		Calificacion calificacion5 = new Calificacion(5,"",partido);
		Calificacion calificacion6 = new Calificacion(6,"",partido);
		Calificacion calificacion7 = new Calificacion(7,"",partido);
		Calificacion calificacion8 = new Calificacion(8,"",partido);
		Calificacion calificacion9 = new Calificacion(9,"",partido);
		Calificacion calificacion10 = new Calificacion(10,"",partido);
		Infraccion infraccion = new Infraccion("Pelea");
		
		participantes.add(new Participante("Franco", "Pancho", new Date(), 6, new ArrayList<Calificacion>(Arrays.asList(calificacion3,calificacion4)), new ArrayList<Infraccion>(Arrays.asList())));
		participantes.add(new Participante("Martin", "Tincho", new Date(), 8, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion6,calificacion8,calificacion6)), new ArrayList<Infraccion>(Arrays.asList(infraccion))));
		participantes.add(new Participante("Oscar", "Osqui", new Date(), 9, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion9,calificacion9)), new ArrayList<Infraccion>(Arrays.asList(infraccion))));
		participantes.add(new Participante("Fabian", "Fabi", new Date(), 10, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion10)), new ArrayList<Infraccion>(Arrays.asList())));
		participantes.add(new Participante("Pablo", "Paul", new Date(), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5)), new ArrayList<Infraccion>(Arrays.asList(infraccion))));
		participantes.add(new Participante("Jose", "Pepe", new Date(), 7, new ArrayList<Calificacion>(Arrays.asList(calificacion8)), new ArrayList<Infraccion>(Arrays.asList())));
	}
	
	public List<Participante> search(String nombre) {
		return this.search(nombre, null);
	}
	
	public List<Participante> search(String nombre, String apodo) {
		List<Participante> resultados = new ArrayList<Participante>();

		for (Participante participante : this.participantes) {
			if (matchStartsWith(nombre, participante.getNombre()) && matchLike(apodo, participante.getApodo())) {
				resultados.add(participante);
			}
		}
		return resultados;
	}

	private boolean matchStartsWith(Object expectedValue, Object realValue) {
		return expectedValue == null
				|| realValue.toString().toLowerCase().startsWith(expectedValue.toString().toLowerCase());
	}

	protected boolean matchLike(Object expectedValue, Object realValue) {
		return expectedValue == null
			|| realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
}