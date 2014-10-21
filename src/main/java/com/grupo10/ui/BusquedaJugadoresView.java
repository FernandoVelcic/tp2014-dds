package com.grupo10.ui;

import java.time.LocalDate;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.UserException;


public class BusquedaJugadoresView extends SimpleWindow<BusquedaJugadoresViewModel> {
	public BusquedaJugadoresView(WindowOwner owner) {
		super(owner, new BusquedaJugadoresViewModel());
		this.getModelObject().search();
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Busqueda de jugadores");
		this.searchFormPanel(mainPanel);
		this.addActions(mainPanel);
		new JugadoresGridBuilder().createResultsGrid(mainPanel, "resultados", true);
		
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
		new TextBox(searchFormPanel).bindValueToProperty("criterioBusqueda.nombre");

		new Label(searchFormPanel).setText("Apodo contiene:");
		new TextBox(searchFormPanel).bindValueToProperty("criterioBusqueda.apodo");
	
		new Label(searchFormPanel).setText("Handicap desde:");
		new TextBox(searchFormPanel).bindValueToProperty("criterioBusqueda.handicapDesde");
		
		new Label(searchFormPanel).setText("Handicap hasta:");
		TextBox textHandicapH = new TextBox(searchFormPanel);
		textHandicapH.bindValueToProperty("criterioBusqueda.handicapHasta");
		
		new Label(searchFormPanel).setText("Promedio del ultimo partido desde:");
		new TextBox(searchFormPanel).bindValueToProperty("criterioBusqueda.promedioDesde");
		
		new Label(searchFormPanel).setText("Promedio del ultimo partido hasta:");
		new TextBox(searchFormPanel).bindValueToProperty("criterioBusqueda.promedioHasta");
	
		new Label(searchFormPanel).setText("Fecha de nacimiento anterior a:");
		new TextBox(searchFormPanel).bindValueToProperty("criterioBusqueda.fecha");
		new Label(searchFormPanel).setText("");
		new Label(searchFormPanel).setText("(yyyy-mm-dd)").setFontSize(8);
		
		new Label(searchFormPanel).setText("Posee Infracciones");
		new CheckBox(searchFormPanel).bindValueToProperty("criterioBusqueda.tieneInfracciones");
		new Label(searchFormPanel).setText("No Posee Infracciones");
		new CheckBox(searchFormPanel).bindValueToProperty("criterioBusqueda.noTieneInfracciones");
	}
	
	protected void addActions(Panel actionsPanel) {
		new Button(actionsPanel)
			.setCaption("Buscar")
			.onClick(() -> actionBuscar())
			.setAsDefault()
			.disableOnError();

		new Button(actionsPanel)
			.setCaption("Limpiar")
			.onClick(() -> getModelObject().getCriterioBusqueda().clear());
	}
	
	public void actionBuscar(){
		
		try {
			if(getModelObject().getCriterioBusqueda().fecha != null)
				LocalDate.parse(getModelObject().getCriterioBusqueda().fecha);
			getModelObject().search();
		}
		catch (Exception pe) {
			throw new UserException("Verifique la fecha ingresada por favor");
		}
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}
}
