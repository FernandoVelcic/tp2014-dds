package com.grupo10.ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;

import com.grupo10.criteriosdivisionequipos.*;
import com.grupo10.criteriosordenequipos.*;

public class GenerarEquiposView extends SimpleWindow<GenerarEquiposViewModel> {

	public boolean generarEquipos = false;
	public int cantidadGenerarEquipos = 0;
	public int cantidadConfirmarEquipos = 0;

	public GenerarEquiposView(WindowOwner owner) {
		super(owner, new GenerarEquiposViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Generar Equipos");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Criterio de seleccion");
		Selector<CriterioDivision> selectCriterioDivision = new Selector<CriterioDivision>(mainPanel)
			.allowNull(false);
	
		selectCriterioDivision.bindValueToProperty("criterioDivision");
		selectCriterioDivision.bindItemsToProperty("listaCriteriosDivision");

		new Label(mainPanel).setText("Criterio de ordenamiento");
		Selector<CriterioOrden> selectCriterioOrden = new Selector<CriterioOrden>(mainPanel)
			.allowNull(false);
		
		selectCriterioOrden.bindValueToProperty("criterioOrden");
		selectCriterioOrden.bindItemsToProperty("listaCriteriosOrden");

		new Label(mainPanel).setText("Criterio de ordenamiento para Mix Criterios");
		Selector<CriterioOrden> selectCriterioOrdenParaMix = new Selector<CriterioOrden>(mainPanel);
		
		selectCriterioOrdenParaMix.bindEnabledToProperty("enableCriteriosMix");
		selectCriterioOrdenParaMix.bindValueToProperty("criterioOrdenParaMix");
		selectCriterioOrdenParaMix.bindItemsToProperty("listaCriteriosOrdenParaMix");
		
		new Button(mainPanel)
			.setCaption("Agregar")
			.onClick(() -> actionAgregarMixCriterios())
			.bindEnabledToProperty("enableCriteriosMix");

		this.addUltimosPartidosPanel(mainPanel);
		
		new Button(mainPanel)
			.setCaption("Generar equipos")
			.onClick(() -> actionGenerarEquipo())
			.bindEnabledToProperty("enableGenerarConfirmarEquipos");
		
		new Label(mainPanel).setText("Resultado: equipos generados");
		
		new Label(mainPanel).setText("Equipo 1:");
		new JugadoresGridBuilder().createResultsGrid(mainPanel, "equipo1", false);
		new Label(mainPanel).setText("Equipo 2:");
		new JugadoresGridBuilder().createResultsGrid(mainPanel, "equipo2", false);
		
		new Button(mainPanel)
			.setCaption("Confirmar equipos")
			.onClick(() -> actionConfirmarEquipos())
			.bindEnabledToProperty("enableGenerarConfirmarEquipos");
	}
	
	private void addUltimosPartidosPanel(Panel mainPanel){
		Panel addUltimosPartidosPanel = new Panel(mainPanel);
		addUltimosPartidosPanel.setLayout(new ColumnLayout(3));
		
		new Label(addUltimosPartidosPanel).setText("Cantidad de partidos:");
		
		TextBox cantidadPartidos = new TextBox(addUltimosPartidosPanel);
		cantidadPartidos.setWidth(50);
		cantidadPartidos.bindValueToProperty("cantidadPartidos");
		cantidadPartidos.bindEnabledToProperty("enableNPartidos");
	}
	
	public void actionAgregarMixCriterios(){
		getModelObject().mixCriterios.add(getModelObject().criterioOrdenParaMix);
	}
		
	public void actionGenerarEquipo(){
		cantidadGenerarEquipos += 1;
		getModelObject().validaciones();
		getModelObject().generarEquipos();
		generarEquipos = true;
		cantidadConfirmarEquipos = 0;
	}
	
	public void actionConfirmarEquipos(){
		cantidadConfirmarEquipos += 1;
		
		if (generarEquipos && cantidadGenerarEquipos >= cantidadConfirmarEquipos){
			new InformationPanel(this, "Confirmación", "       Partido creado correctamente      ").open();
			cantidadConfirmarEquipos += 1;
			getModelObject().confirmarEquipos();
			cantidadGenerarEquipos = 0;
			cantidadConfirmarEquipos = 0;
		}
		
		else if (!generarEquipos)
			throw new UserException("Debe generar los equipos para poder confirmar el partido");		
		
		else if (cantidadGenerarEquipos != cantidadConfirmarEquipos)
			throw new UserException("Este equipo ya ha sido creado");			
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

}
