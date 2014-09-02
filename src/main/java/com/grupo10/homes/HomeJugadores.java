package com.grupo10.homes;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.grupo10.juego.Administrador;
import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Infraccion;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.Estandar;

import java.util.Date;

public class HomeJugadores implements Serializable {
	private static HomeJugadores instance;
	private Administrador admin = new Administrador();
	private Partido partido = new Partido(new Date(), admin);

	public static synchronized HomeJugadores getInstance() {
		if (instance == null) {
			instance = new HomeJugadores();
		}
		return instance;
	}

	@SuppressWarnings("deprecation")
	public HomeJugadores() {
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
		Infraccion infraccion1 = new Infraccion("Pelea con contrincante");
		Infraccion infraccion2 = new Infraccion("Insulto al arbitro");
		Infraccion infraccion3 = new Infraccion("Pelea con compañero");

		partido.inscribirJugador(new Participante("Franco", "Pancho", new Date("10/10/1980"), 6, new ArrayList<Calificacion>(Arrays.asList(calificacion3,calificacion4)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
		partido.inscribirJugador(new Participante("Martin", "Tincho", new Date("01/12/1985"), 8, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion6,calificacion8,calificacion6)), new ArrayList<Infraccion>(Arrays.asList(infraccion1)), new Estandar()));
		partido.inscribirJugador(new Participante("Oscar", "Osqui", new Date("12/20/1984"), 9, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion9,calificacion9)), new ArrayList<Infraccion>(Arrays.asList(infraccion1)), new Estandar()));
		partido.inscribirJugador(new Participante("Fabian", "Fabi", new Date("04/15/1988"), 10, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion10)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
		partido.inscribirJugador(new Participante("Pablo", "Paul", new Date("02/24/1982"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5)), new ArrayList<Infraccion>(Arrays.asList(infraccion2)), new Estandar()));
		partido.inscribirJugador(new Participante("Jose", "Pepe", new Date("08/14/1987"), 7, new ArrayList<Calificacion>(Arrays.asList(calificacion8)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
		partido.inscribirJugador(new Participante("Marcelo", "Marce", new Date("11/28/1988"), 10, new ArrayList<Calificacion>(Arrays.asList(calificacion10)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
		partido.inscribirJugador(new Participante("Tomas", "Tomy", new Date("09/18/1985"), 2, new ArrayList<Calificacion>(Arrays.asList(calificacion1,calificacion3,calificacion3,calificacion2)), new ArrayList<Infraccion>(Arrays.asList(infraccion3)), new Estandar()));
		partido.inscribirJugador(new Participante("Cristian", "Cris", new Date("04/29/1986"), 8, new ArrayList<Calificacion>(Arrays.asList(calificacion9, calificacion8)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
		partido.inscribirJugador(new Participante("Enrique", "Quique", new Date("05/17/1984"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion7,calificacion3)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
		partido.inscribirJugador(new Participante("Marcos", "Mark", new Date("08/07/1982"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5)), new ArrayList<Infraccion>(Arrays.asList(infraccion3)), new Estandar()));
		partido.inscribirJugador(new Participante("Federico", "Fede", new Date("07/06/1984"), 9, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion8)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar()));
	}
	
	public List<Participante> search(String nombre, String apodo, Integer handicapDesde, Integer handicapHasta, Double promedioDesde, Double promedioHasta, String fechaString) {
		List<Participante> resultados = new ArrayList<Participante>();

		for (Participante participante : partido.participantes) {
			if (matchStartsWith(nombre, participante.getNombre()) 
					&& matchLike(apodo, participante.getApodo()) 
					&& matchIntegerFrom(handicapDesde, participante.getHandicap())
					&& matchIntegerTo(handicapHasta, participante.getHandicap())
					&& matchDoubleFrom(promedioDesde, participante.getPromedio())
					&& matchDoubleTo(promedioHasta, participante.getPromedio())
					&& matchDateFrom(fechaString, participante.getFechaNacimiento())) {
				resultados.add(participante);
			}
		}
		return resultados;
	}
	
	private Date convertirStringAFecha(String fechaString){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateFormat = null;
		try {
			dateFormat = formatter.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormat;
	}

	private boolean matchDateFrom(String fechaString, Date fechaNacimiento) {
		return fechaString == null
				|| convertirStringAFecha(fechaString).after(fechaNacimiento);
	}

	private boolean matchStartsWith(Object expectedValue, Object realValue) {
		return expectedValue == null
				|| realValue.toString().toLowerCase().startsWith(expectedValue.toString().toLowerCase());
	}

	protected boolean matchLike(Object expectedValue, Object realValue) {
		return expectedValue == null
			|| realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase());
	}
	
	private boolean matchDoubleFrom(Double expectedValue, Double realValue) {
		return expectedValue == null
				|| realValue >= expectedValue;
	}
	
	private boolean matchDoubleTo(Double expectedValue, Double realValue) {
		return expectedValue == null
				|| realValue <= expectedValue;
	}
	
	private boolean matchIntegerFrom(Integer expectedValue, Integer realValue) {
		return expectedValue == null
				|| realValue >= expectedValue;
	}
	
	private boolean matchIntegerTo(Integer expectedValue, Integer realValue) {
		return expectedValue == null
				|| realValue <= expectedValue;
	}
	
	public Partido getPartido() {
		return partido;
	}
	
	public Administrador getAdmin() {
		return admin;
	}
}