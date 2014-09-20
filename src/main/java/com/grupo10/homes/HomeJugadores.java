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
import com.grupo10.modalidades.Condicional;
import com.grupo10.modalidades.Estandar;
import com.grupo10.modalidades.Solidario;
import com.grupo10.ui.BusquedaJugadoresViewModel;

import java.util.Date;

public class HomeJugadores {
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
	private HomeJugadores() {
		
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
		
		Participante martin = new Participante("Martin", "Tincho", new Date("01/12/1985"), 8, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion6,calificacion8,calificacion6)), new ArrayList<Infraccion>(Arrays.asList(infraccion1)), new Condicional(true));
		Participante oscar = new Participante("Oscar", "Osqui", new Date("12/20/1984"), 9, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion9,calificacion9)), new ArrayList<Infraccion>(Arrays.asList(infraccion1)), new Estandar());
		Participante franco = new Participante("Franco", "Pancho", new Date("10/10/1980"), 6, new ArrayList<Calificacion>(Arrays.asList(calificacion3,calificacion4)), new ArrayList<Infraccion>(Arrays.asList(infraccion1, infraccion2, infraccion3)), new Solidario());
		Participante fabian = new Participante("Fabian", "Fabi", new Date("04/15/1988"), 10, new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion10)), new ArrayList<Infraccion>(Arrays.asList()), new Condicional(false));
		Participante pablo = new Participante("Pablo", "Paul", new Date("02/24/1982"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5)), new ArrayList<Infraccion>(Arrays.asList(infraccion2)), new Estandar());
		Participante jose = new Participante("Jose", "Pepe", new Date("08/14/1987"), 7, new ArrayList<Calificacion>(Arrays.asList(calificacion8)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar());
		Participante marcelo = new Participante("Marcelo", "Marce", new Date("11/28/1988"), 10, new ArrayList<Calificacion>(Arrays.asList(calificacion10)), new ArrayList<Infraccion>(Arrays.asList()), new Solidario());
		Participante tomas = new Participante("Tomas", "Tomy", new Date("09/18/1985"), 2, new ArrayList<Calificacion>(Arrays.asList(calificacion1,calificacion3,calificacion3,calificacion2)), new ArrayList<Infraccion>(Arrays.asList(infraccion3)), new Solidario());
		Participante cristian = new Participante("Cristian", "Cris", new Date("04/29/1986"), 8, new ArrayList<Calificacion>(Arrays.asList(calificacion9, calificacion8)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar());
		Participante enrique = new Participante("Enrique", "Quique", new Date("05/17/1984"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion7,calificacion3)), new ArrayList<Infraccion>(Arrays.asList()), new Condicional(true));
		Participante marcos = new Participante("Marcos", "Mark", new Date("08/07/1982"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5)), new ArrayList<Infraccion>(Arrays.asList(infraccion3)), new Estandar());
		Participante federico = new Participante("Federico", "Fede", new Date("07/06/1984"), 9, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion8)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar());
		Participante miguel = new Participante("Miguel", "Migue", new Date("09/10/1982"), 7, new ArrayList<Calificacion>(Arrays.asList(calificacion7,calificacion6)), new ArrayList<Infraccion>(Arrays.asList(infraccion3)), new Condicional(true));
		Participante alejandro = new Participante("Alejandro", "Ale", new Date("09/21/1980"), 5, new ArrayList<Calificacion>(Arrays.asList(calificacion5, calificacion6)), new ArrayList<Infraccion>(Arrays.asList()), new Solidario());
		Participante fernando = new Participante("Fernando", "Fer", new Date("09/06/1991"), 9, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion10)), new ArrayList<Infraccion>(Arrays.asList(infraccion2, infraccion3)), new Condicional(false));
		Participante roberto = new Participante("Roberto", "Robert", new Date("12/12/1984"), 10, new ArrayList<Calificacion>(Arrays.asList(calificacion9,calificacion10,calificacion10,calificacion9)), new ArrayList<Infraccion>(Arrays.asList()), new Estandar());
		Participante carlos = new Participante("Carlos", "Carl", new Date("11/16/1989"), 4, new ArrayList<Calificacion>(Arrays.asList(calificacion4,calificacion5)), new ArrayList<Infraccion>(Arrays.asList()), new Condicional(true));
		
		partido.inscribirJugador(franco);
		partido.inscribirJugador(martin);
		partido.inscribirJugador(oscar);
		partido.inscribirJugador(fabian);
		partido.inscribirJugador(pablo);
		partido.inscribirJugador(jose);
		partido.inscribirJugador(marcelo);
		partido.inscribirJugador(tomas);
		partido.inscribirJugador(cristian);
		partido.inscribirJugador(enrique);
		partido.inscribirJugador(marcos);
		partido.inscribirJugador(federico);
		partido.inscribirJugador(miguel);
		partido.inscribirJugador(alejandro);
		partido.inscribirJugador(fernando);
		partido.inscribirJugador(roberto);
		partido.inscribirJugador(carlos);
		
		franco.agregarAmigo(martin);
		franco.agregarAmigo(oscar);
		martin.agregarAmigo(franco);
		martin.agregarAmigo(fabian);
		martin.agregarAmigo(tomas);
		oscar.agregarAmigo(pablo);
		fabian.agregarAmigo(pablo);
		fabian.agregarAmigo(franco);
		fabian.agregarAmigo(jose);
		pablo.agregarAmigo(jose);
		pablo.agregarAmigo(federico);
		pablo.agregarAmigo(miguel);
		pablo.agregarAmigo(alejandro);
		pablo.agregarAmigo(roberto);
		marcos.agregarAmigo(pablo);
		marcos.agregarAmigo(franco);
		marcos.agregarAmigo(martin);
		marcos.agregarAmigo(carlos);
		marcos.agregarAmigo(fernando);
		
	}
	
	public List<Participante> search(String nombre, String apodo, Integer handicapDesde, Integer handicapHasta, Double promedioDesde, Double promedioHasta, String fechaString, boolean tieneInfracciones, boolean noTieneInfracciones) {
		List<Participante> resultados = new ArrayList<Participante>();
		for (Participante participante : partido.participantes) {
			if (matchStartsWith(nombre, participante.getNombre()) 
					&& matchLike(apodo, participante.getApodo()) 
					&& matchIntegerFrom(handicapDesde, participante.getHandicap())
					&& matchIntegerTo(handicapHasta, participante.getHandicap())
					&& matchDoubleFrom(promedioDesde, participante.getPromedio())
					&& matchDoubleTo(promedioHasta, participante.getPromedio())
					&& matchDateFrom(fechaString, participante.getFechaNacimiento())
					&& (matchTieneInfracciones(tieneInfracciones, participante.getInfracciones())
					|| matchNoTieneInfracciones(noTieneInfracciones, participante.getInfracciones()))) {
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
	
	private boolean matchTieneInfracciones(boolean tieneInfracciones, List<Infraccion> list) {
		return tieneInfracciones == (list.size() > 0);
	}
	
	private boolean matchNoTieneInfracciones(boolean noTieneInfracciones, List<Infraccion> list) {
		return noTieneInfracciones == (list.size() == 0);
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