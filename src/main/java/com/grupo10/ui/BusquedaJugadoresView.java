package com.grupo10.ui;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;


public class BusquedaJugadoresView extends Window<BusquedaJugadoresViewModel> {
	public BusquedaJugadoresView(WindowOwner owner) {
		super(owner, new BusquedaJugadoresViewModel());
		this.getModelObject().search();
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Busqueda de jugadores");
		this.searchFormPanel(mainPanel);
		this.addActions(mainPanel);
		new JugadoresGrid().createResultsGrid(this, mainPanel, "resultados");
		
		//Deshabilitar el boton si no hay ningun elemento seleccionado en la grilla.
		NotNullObservable elementSelected = new NotNullObservable("participanteSeleccionado");
		
		new Button(mainPanel)
			.setCaption("Ver jugador seleccionado")
			.onClick(() -> new JugadorView(this, getModelObject().getParticipanteSeleccionado()).open())
			.bindEnabled(elementSelected);
	}

	private void searchFormPanel(Panel mainPanel) {
		
		mainPanel.setLayout(new VerticalLayout());
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(2));

		new Label(searchFormPanel).setText("Nombre comienza con:");
		new TextBox(searchFormPanel).bindValueToProperty("nombre");

		new Label(searchFormPanel).setText("Apodo contiene:");
		new TextBox(searchFormPanel).bindValueToProperty("apodo");
	
		new Label(searchFormPanel).setText("Handicap desde:");
		new TextBox(searchFormPanel).bindValueToProperty("handicapDesde");
		
		new Label(searchFormPanel).setText("Handicap hasta:");
		TextBox textHandicapH = new TextBox(searchFormPanel);
		textHandicapH.bindValueToProperty("handicapHasta");
		
		new Label(searchFormPanel).setText("Promedio del ultimo partido desde:");
		new TextBox(searchFormPanel).bindValueToProperty("promedioDesde");
		
		new Label(searchFormPanel).setText("Promedio del ultimo partido hasta:");
		new TextBox(searchFormPanel).bindValueToProperty("promedioHasta");
	
		new Label(searchFormPanel).setText("Fecha de nacimiento anterior a:");
		new TextBox(searchFormPanel).bindValueToProperty("fechaString");
		new Label(searchFormPanel).setText("");
		new Label(searchFormPanel).setText("(mm/dd/yyyy)").setFontSize(8);
		
		new Label(searchFormPanel).setText("Posee Infracciones");
		new CheckBox(searchFormPanel).bindValueToProperty("tieneInfracciones");
		new Label(searchFormPanel).setText("No Posee Infracciones");
		new CheckBox(searchFormPanel).bindValueToProperty("noTieneInfracciones");
		
	}
	
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick(() -> getModelObject().search())
			.setAsDefault()
			.disableOnError();

		new Button(actionsPanel)
			.setCaption("Limpiar")
			.onClick(() -> getModelObject().clear());
	}
}
