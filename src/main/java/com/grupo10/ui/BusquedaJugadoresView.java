package com.grupo10.ui;

import java.text.SimpleDateFormat;

import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.widgets.tables.*;
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

		new Label(searchFormPanel).setText("Nombre comienza con:");
		new TextBox(searchFormPanel).bindValueToProperty("nombre");

		new Label(searchFormPanel).setText("Apodo contiene:");
		new TextBox(searchFormPanel).bindValueToProperty("apodo");
	
		new Label(searchFormPanel).setText("Handicap desde:");
		new TextBox(searchFormPanel).bindValueToProperty("handicapDesde");
		
		new Label(searchFormPanel).setText("Handicap hasta:");
		new TextBox(searchFormPanel).bindValueToProperty("handicapHasta");
		
		new Label(searchFormPanel).setText("Promedio del ultimo partido desde:");
		new TextBox(searchFormPanel).bindValueToProperty("promedioDesde");
		
		new Label(searchFormPanel).setText("Promedio del ultimo partido hasta:");
		new TextBox(searchFormPanel).bindValueToProperty("promedioHasta");
	
		new Label(searchFormPanel).setText("Fecha de nacimiento anterior a:");
		new TextBox(searchFormPanel).bindValueToProperty("fechaString");
		new Label(searchFormPanel).setText("");
		new Label(searchFormPanel).setText("(mm/dd/yyyy)").setFontSize(8);
		
		new Label(searchFormPanel).setText("Infracciones");
		new Selector(searchFormPanel);//.bindValueToProperty("Tipo");
	}
	
	public void createResultsGrid(Panel mainPanel) {
		Table<Participante> table = new Table<Participante>(mainPanel, Participante.class);
		table.setHeigth(200);
		table.setWidth(600);

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
		
		new Column<Participante>(table)
		.setTitle("Fecha Nacimiento")
		.setFixedSize(150)
		.bindContentsToTransformer(new DateToStringTransformer());
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
