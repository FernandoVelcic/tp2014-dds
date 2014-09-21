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
	List<CriterioOrden> listaCriteriosOrden;
	
	Partido partido;
	List<Participante> equipo1;
	List<Participante> equipo2;

	public GenerarEquiposViewModel() {
		partido = HomeJugadores.getInstance().getPartido();
		MixCriterios mixCriterios = new MixCriterios()  {
			public String toString() {
				return "Calificaciones+handicap (MixCriterio)";
			}
		};
		mixCriterios.add(new Calificaciones());
		mixCriterios.add(new Handicap());
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
		listaCriteriosOrden.add(new Calificaciones() {
			public String toString() {
				return "Calificaciones";
			}
		});
		listaCriteriosOrden.add(new Handicap() {
			public String toString() {
				return "Handicap";
			}
		});
		listaCriteriosOrden.add(mixCriterios);
		listaCriteriosOrden.add(new Ncalificaciones(3) {
			public String toString() {
				return "Calificaciones 3 (Ncalificaciones)";
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
}
