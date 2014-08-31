package com.grupo10.ui;

import java.awt.Color;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.juego.Participante;

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
		this.createResultsGrid(mainPanel);
	}

	private void searchFormPanel(Panel mainPanel) {
		
		mainPanel.setLayout(new VerticalLayout());
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(2));

		new Label(searchFormPanel).setText("Nombre comienza con");
		new TextBox(searchFormPanel).bindValueToProperty("nombre");

		new Label(searchFormPanel).setText("Apodo contiene");
		new TextBox(searchFormPanel).bindValueToProperty("apodo");
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		Table<Participante> table = new Table<Participante>(mainPanel, Participante.class);
		table.setHeigth(200);
		table.setWidth(450);

		table.bindItemsToProperty("resultados");
		table.bindValueToProperty("participanteSeleccionado");

		this.describeResultsGrid(table);
		
		//Deshabilitar el boton si no hay ningun elemento seleccionado en la grilla.
		NotNullObservable elementSelected = new NotNullObservable("participanteSeleccionado");
		
		new Button(mainPanel)
			.setCaption("Ver jugador seleccionado")
			.onClick(() -> getModelObject().verJugador(this))
			.bindEnabled(elementSelected);
	}
	
	protected void describeResultsGrid(Table<Participante> table) {
		new Column<Participante>(table)
			.setTitle("Nombre")
			.setFixedSize(150)
			.bindContentsToProperty("nombre");

		new Column<Participante>(table)
			.setTitle("Apodo")
			.setFixedSize(100)
			.bindContentsToProperty("apodo");
		
		new Column<Participante>(table)
			.setTitle("Handicap")
			.setFixedSize(100)
			.bindContentsToProperty("handicap");
		
		new Column<Participante>(table)
			.setTitle("Promedio")
			.setFixedSize(100)
			.bindContentsToProperty("promedio");
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
