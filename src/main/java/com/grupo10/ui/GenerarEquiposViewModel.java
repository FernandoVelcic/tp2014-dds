package com.grupo10.ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import com.grupo10.criteriosdivisionequipos.*;
import com.grupo10.criteriosordenequipos.*;
import com.grupo10.homes.HomeJugadores;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

@Observable
public class GenerarEquiposViewModel {
	CriterioDivision criterioDivision;
	List<CriterioDivision> listaCriteriosDivision;

	CriterioOrden criterioOrden;
	CriterioOrden criterioOrdenParaMix;
	List<CriterioOrden> listaCriteriosOrden;
	List<CriterioOrden> listaCriteriosOrdenParaMix;
	int cantidadPartidos = 3;
	
	Partido partido;
	List<Participante> equipo1 = HomeJugadores.getInstance().recuperarEquipo1();
	List<Participante> equipo2 = HomeJugadores.getInstance().recuperarEquipo2();
		
	boolean enableCriteriosMix = false;
	boolean enableNPartidos = false;
	boolean enableGenerarConfirmarEquipos = false;
	
	MixCriterios mixCriterios = new MixCriterios(){
		public String toString() {
			return "MixCriterio";
		}
	};
	
	Ncalificaciones nCalificaciones = new Ncalificaciones(cantidadPartidos){
		public String toString() {
			return "Calificaciones de ultimos partidos";
		}
	};
	
	public GenerarEquiposViewModel() {
		partido = HomeJugadores.getInstance().getPartido();
				
		listaCriteriosDivision = new ArrayList<CriterioDivision>();
		listaCriteriosDivision.add(new ParImpar() {
			public String toString() {
				return "ParImpar";
			}
		});
		listaCriteriosDivision.add(new TresUno() {
			public String toString() {
				return "TresUno";
			}
		});
		
		listaCriteriosOrden = new ArrayList<CriterioOrden>();
		listaCriteriosOrdenParaMix = new ArrayList<CriterioOrden>();
		
		listaCriteriosOrdenParaMix.add(new Calificaciones(){
			public String toString() {
				return "Calificaciones";
			}
		});
		
		listaCriteriosOrdenParaMix.add(new Handicap(){
			public String toString() {
				return "Handicap";
			}
		});
		
		listaCriteriosOrden.addAll(listaCriteriosOrdenParaMix);
		listaCriteriosOrden.add(mixCriterios);
		listaCriteriosOrden.add(nCalificaciones);
	}

	public void generarEquipos() {
		partido.generarJugadores();
		HomeJugadores.getInstance().getAdmin().generarEquiposTentativos(criterioOrden, criterioDivision);
		equipo1 = partido.equipo1;
		equipo2 = partido.equipo2;
		HomeJugadores.getInstance().guardarPartido(equipo1, equipo2);
	}
	
	public void confirmarEquipos() {
		HomeJugadores.getInstance().getAdmin().confirmarEquipos();
	}

	public CriterioDivision getCriterioDivision() {
		return criterioDivision;
	}
	
	public void setCriterioDivision(CriterioDivision criterioDivision) {
		this.criterioDivision = criterioDivision;
		activarBotonGenerarEquipos();
	}

	public CriterioOrden getCriterioOrden() {
		return criterioOrden;
	}
	
	public void setCriterioOrden(CriterioOrden criterioOrden) {
		this.criterioOrden = criterioOrden;
		if (criterioOrden == mixCriterios){
			enableCriteriosMix = true;
		}
		else enableCriteriosMix = false;
		
		if (criterioOrden == nCalificaciones){
			enableNPartidos = true;
		}
		else enableNPartidos = false;
		activarBotonGenerarEquipos();
	}
	
	public List<CriterioDivision> getListaCriteriosDivision() {
		return listaCriteriosDivision;
	}

	public List<CriterioOrden> getListaCriteriosOrden() {
		return listaCriteriosOrden;
	}
	
	public List<Participante> getEquipo1() {
		return equipo1;
	}
	
	public List<Participante> getEquipo2() {
		return equipo2;
	}
	
	public void activarBotonGenerarEquipos() {
		if(criterioOrden != null && criterioDivision != null)
			enableGenerarConfirmarEquipos = true;
	}

	public CriterioOrden getCriterioOrdenParaMix() {
		return criterioOrdenParaMix;
	}

	public void setCriterioOrdenParaMix(CriterioOrden criterioOrdenParaMix) {
		this.criterioOrdenParaMix = criterioOrdenParaMix;
	}

	public List<CriterioOrden> getListaCriteriosOrdenParaMix() {
		return listaCriteriosOrdenParaMix;
	}

	public void setListaCriteriosOrdenParaMix(List<CriterioOrden> listaCriteriosOrdenParaMix) {
		this.listaCriteriosOrdenParaMix = listaCriteriosOrdenParaMix;
	}

	public MixCriterios getMixCriterios() {
		return mixCriterios;
	}

	public void setMixCriterios(MixCriterios mixCriterios) {
		this.mixCriterios = mixCriterios;
	}

	public boolean isEnableCriteriosMix() {
		return enableCriteriosMix;
	}

	public void setEnableCriteriosMix(boolean enableCriteriosMix) {
		this.enableCriteriosMix = enableCriteriosMix;
	}

	public int getCantidadPartidos() {
		return cantidadPartidos;
	}

	public void setCantidadPartidos(int cantidadPartidos) {
		this.cantidadPartidos = cantidadPartidos;
	}

	public boolean isEnableNPartidos() {
		return enableNPartidos;
	}

	public void setEnableNPartidos(boolean enableNPartidos) {
		this.enableNPartidos = enableNPartidos;
	}

	protected void validaciones() {
		if (criterioOrden == mixCriterios && mixCriterios.getMix().isEmpty()){
			throw new UserException("La lista de criterios no puede ser vacía");
		}
		
	}

	public boolean enableGenerarConfirmarEquipos() {
		return enableGenerarConfirmarEquipos;
	}

	public void enableGenerarConfirmarEquipos(boolean enableGenerarConfirmarEquipos) {
		this.enableGenerarConfirmarEquipos = enableGenerarConfirmarEquipos;
	}
}
