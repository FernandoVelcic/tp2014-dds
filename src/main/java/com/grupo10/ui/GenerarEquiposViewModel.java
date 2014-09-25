package com.grupo10.ui;

import java.util.ArrayList;
import java.util.List;

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
	int cantidadPartidos;
	
	Partido partido;
	List<Participante> equipo1;
	List<Participante> equipo2;
		
	boolean enableCriteriosMix = false;
	
	MixCriterios mixCriterios = new MixCriterios()  {
		public String toString() {
			return "MixCriterio";
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
		listaCriteriosOrden.add(new Ncalificaciones(cantidadPartidos){
			public String toString() {
				return "Calificaciones de ultimos partidos";
			}
		});
	}

	public void generarEquipos() {
		partido.generarJugadores();
		HomeJugadores.getInstance().getAdmin().generarEquiposTentativos(criterioOrden, criterioDivision);
		equipo1 = partido.equipo1;
		equipo2 = partido.equipo2;
	}
	
	public void confirmarEquipos() {
		HomeJugadores.getInstance().getAdmin().confirmarEquipos();
	}

	public CriterioDivision getCriterioDivision() {
		return criterioDivision;
	}
	
	public void setCriterioDivision(CriterioDivision criterioDivision) {
		this.criterioDivision = criterioDivision;
		actualizarFormulario();
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
		actualizarFormulario();
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
	
	//Para habilitar formulario
	HabilitarFormulario habilitarFormulario;
	
	public HabilitarFormulario getHabilitarFormulario() {
		return habilitarFormulario;
	}
	
	public void setHabilitarFormulario(HabilitarFormulario participante) {
		habilitarFormulario = participante;
	}
	
	public void actualizarFormulario() {
		if(criterioOrden != null && criterioDivision != null)
			setHabilitarFormulario(new HabilitarFormulario());
	}

	public CriterioOrden getcriterioOrdenParaMix() {
		return criterioOrdenParaMix;
	}

	public void setcriterioOrdenParaMix(CriterioOrden criterioOrdenParaMix) {
		this.criterioOrdenParaMix = criterioOrdenParaMix;
		actualizarFormulario();
	}

	public List<CriterioOrden> getListaCriteriosOrdenParaMix() {
		return listaCriteriosOrdenParaMix;
	}

	public void setListaCriteriosOrdenParaMix(
			List<CriterioOrden> listaCriteriosOrdenParaMix) {
		this.listaCriteriosOrdenParaMix = listaCriteriosOrdenParaMix;
	}

	public MixCriterios getMixCriterios() {
		return mixCriterios;
	}

	public void setMixCriterios(MixCriterios mixCriterios) {
		this.mixCriterios = mixCriterios;
	}

	public boolean isEnabled() {
		return enableCriteriosMix;
	}

	public void setEnabled(boolean enabled) {
		this.enableCriteriosMix = enabled;
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
}
