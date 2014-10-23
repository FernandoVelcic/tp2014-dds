package com.grupo10.homes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;

import com.grupo10.db.EntityManagerHelper;
import com.grupo10.juego.*;
import com.grupo10.modalidades.*;

public class HomeJugadores {
	private static HomeJugadores instance;
	public Administrador admin = new Administrador();
	public Partido partido = new Partido(LocalDate.now(), admin);
	
	public static HomeJugadores getInstance() {
		if (instance == null) {
			instance = new HomeJugadores();
		}
		return instance;
	}

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
		
		Participante martin = new Participante("Martin", "Tincho", LocalDate.of(1985, Month.JANUARY, 1), 9, Arrays.asList(calificacion10,calificacion6,calificacion8,calificacion6), Arrays.asList(infraccion1), new Condicional(true));
		Participante oscar = new Participante("Oscar", "Osqui", LocalDate.of(1988, Month.AUGUST, 10), 8, Arrays.asList(calificacion10,calificacion9,calificacion9), Arrays.asList(infraccion1), new Estandar());
		Participante franco = new Participante("Franco", "Pancho", LocalDate.of(1987, Month.JUNE, 21), 6, Arrays.asList(calificacion3,calificacion4), Arrays.asList(infraccion1, infraccion2, infraccion3), new Solidario());
		Participante fabian = new Participante("Fabian", "Fabi", LocalDate.of(1986, Month.DECEMBER, 30), 10, Arrays.asList(calificacion10,calificacion10), Arrays.asList(), new Condicional(false));
		Participante pablo = new Participante("Pablo", "Paul", LocalDate.of(1990, Month.SEPTEMBER, 21), 5, Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5), Arrays.asList(infraccion2), new Estandar());
		Participante jose = new Participante("Jose", "Pepe", LocalDate.of(1992, Month.FEBRUARY, 29), 7, Arrays.asList(calificacion8), Arrays.asList(), new Estandar());
		Participante marcelo = new Participante("Marcelo", "Marce", LocalDate.of(1989, Month.JULY, 11), 10, Arrays.asList(calificacion10), Arrays.asList(), new Solidario());
		Participante tomas = new Participante("Tomas", "Tomy", LocalDate.of(1985, Month.OCTOBER, 14), 2, Arrays.asList(calificacion1,calificacion3,calificacion3,calificacion2), Arrays.asList(infraccion3), new Solidario());
		Participante cristian = new Participante("Cristian", "Cris", LocalDate.of(1991, Month.APRIL, 29), 8, Arrays.asList(calificacion9, calificacion8), Arrays.asList(), new Estandar());
		Participante enrique = new Participante("Enrique", "Quique", LocalDate.of(1992, Month.NOVEMBER, 20), 5, Arrays.asList(calificacion7,calificacion3), Arrays.asList(), new Condicional(true));
		Participante marcos = new Participante("Marcos", "Mark", LocalDate.of(1990, Month.JULY, 22), 5, Arrays.asList(calificacion9,calificacion6,calificacion3,calificacion5), Arrays.asList(infraccion3), new Estandar());
		Participante federico = new Participante("Federico", "Fede", LocalDate.of(1988, Month.JUNE, 12), 9, Arrays.asList(calificacion9,calificacion8), Arrays.asList(), new Estandar());
		Participante miguel = new Participante("Miguel", "Migue", LocalDate.of(1989, Month.MARCH, 1), 7, Arrays.asList(calificacion7,calificacion6), Arrays.asList(infraccion3), new Condicional(true));
		Participante alejandro = new Participante("Alejandro", "Ale", LocalDate.of(1985, Month.MAY, 23), 5, Arrays.asList(calificacion5, calificacion6), Arrays.asList(), new Solidario());
		Participante fernando = new Participante("Fernando", "Fer", LocalDate.of(1988, Month.JANUARY, 3), 9, Arrays.asList(calificacion9,calificacion10), Arrays.asList(infraccion2, infraccion3), new Condicional(false));
		Participante roberto = new Participante("Roberto", "Robert", LocalDate.of(1985, Month.JUNE, 2), 10, Arrays.asList(calificacion9,calificacion10,calificacion10,calificacion9), Arrays.asList(), new Estandar());
		Participante carlos = new Participante("Carlos", "Carl", LocalDate.of(1989, Month.NOVEMBER, 13), 4, Arrays.asList(calificacion4,calificacion5), Arrays.asList(), new Condicional(true));
		
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

		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(franco);
		EntityManagerHelper.getEntityManager().persist(martin);
		EntityManagerHelper.getEntityManager().persist(oscar);
		EntityManagerHelper.getEntityManager().persist(fabian);
		EntityManagerHelper.getEntityManager().persist(pablo);
		EntityManagerHelper.getEntityManager().persist(jose);
		EntityManagerHelper.getEntityManager().persist(marcelo);
		EntityManagerHelper.getEntityManager().persist(tomas);
		EntityManagerHelper.getEntityManager().persist(cristian);
		EntityManagerHelper.getEntityManager().persist(enrique);
		EntityManagerHelper.getEntityManager().persist(marcos);
		EntityManagerHelper.getEntityManager().persist(federico);
		EntityManagerHelper.getEntityManager().persist(miguel);
		EntityManagerHelper.getEntityManager().persist(alejandro);
		EntityManagerHelper.getEntityManager().persist(fernando);
		EntityManagerHelper.getEntityManager().persist(roberto);
		EntityManagerHelper.getEntityManager().persist(carlos);
		EntityManagerHelper.commit();
	}
	
	
	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}
	
	public List<Participante> recuperarEquipo1(Partido partido) {
		List<Partido> partidos = EntityManagerHelper.getEntityManager().createQuery("from Partido p where p.id = :id").setParameter("id",partido.getId()).getResultList();
		if(partidos.isEmpty())
			return null;
		
		return partidos.get(0).equipo1;
	}
	
	public List<Participante> recuperarEquipo2(Partido partido) {
		List<Partido> partidos = EntityManagerHelper.getEntityManager().createQuery("from Partido p where p.id = :id").setParameter("id",partido.getId()).getResultList();
		if(partidos.isEmpty())
			return null;
		
		return partidos.get(0).equipo2;
	}

	public void confirmarEquipos() {
		getAdmin().confirmarEquipos();
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().persist(partido);
		EntityManagerHelper.commit();
		
	}
}