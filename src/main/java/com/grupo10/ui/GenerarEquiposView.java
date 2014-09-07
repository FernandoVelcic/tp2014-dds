package com.grupo10.ui;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

import com.grupo10.criteriosdivisionequipos.*;
import com.grupo10.criteriosordenequipos.*;
import com.grupo10.juego.Participante;

public class GenerarEquiposView extends Window<GenerarEquiposViewModel> {

	public GenerarEquiposView(WindowOwner owner) {
		super(owner, new GenerarEquiposViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Generar Equipos");
		mainPanel.setLayout(new VerticalLayout());
		
		//
		new Label(mainPanel).setText("Criterio de seleccion");
		Selector<CriterioDivision> selectCriterioDivision = new Selector<CriterioDivision>(mainPanel)
			.allowNull(false);
	
		selectCriterioDivision.bindValueToProperty("criterioDivision");
		selectCriterioDivision.bindItemsToProperty("listaCriteriosDivision");

		//
		new Label(mainPanel).setText("Criterio de ordenamiento");
		Selector<CriterioOrden> selectCriterioOrden = new Selector<CriterioOrden>(mainPanel)
			.allowNull(false);
		
		selectCriterioOrden.bindValueToProperty("criterioOrden");
		selectCriterioOrden.bindItemsToProperty("listaCriteriosOrden");

		//Deshabilitar el boton si no hay ningun elemento seleccionado en la grilla.
		NotNullObservable elementSelected = new NotNullObservable("habilitarFormulario");

		//
		new Button(mainPanel)
			.setCaption("Generar equipos")
			.onClick(() -> getModelObject().generarEquipos())
			.bindEnabled(elementSelected);
		
		new Label(mainPanel).setText("Resultado: equipos generados");
		
		new Label(mainPanel).setText("Equipo 1:");
		new JugadoresGrid().createResultsGrid(this, mainPanel, "equipo1");
		new Label(mainPanel).setText("Equipo 2:");
		new JugadoresGrid().createResultsGrid(this, mainPanel, "equipo2");
		
		new Button(mainPanel)
			.setCaption("Confirmar equipos")
			.onClick(() -> getModelObject().confirmarEquipos())
			.bindEnabled(elementSelected);
	}

}
