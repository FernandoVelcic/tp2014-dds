package com.grupo10.ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import com.grupo10.criteriosdivisionequipos.CriterioDivision;
import com.grupo10.juego.Partido;

public class VerEquiposView extends SimpleWindow<VerEquiposViewModel>{

	public VerEquiposView(WindowOwner owner) {
		super(owner, new VerEquiposViewModel());
	}
	
	public void createContents(Panel mainPanel) {
		setTitle("Ver Partidos");
		
		new Label(mainPanel).setText("Elegir Partido");
		Selector<Partido> selectPartido = new Selector<Partido>(mainPanel).allowNull(false);
		selectPartido.bindValueToProperty("partido");
		selectPartido.bindItemsToProperty("selectPartido");
		
		new Label(mainPanel).setText("Equipo 1:");
		new JugadoresGridBuilder().createResultsGrid(mainPanel, "equipo1", false);
		
		new Label(mainPanel).setText("Equipo 2:");
		new JugadoresGridBuilder().createResultsGrid(mainPanel, "equipo2", false);
		
		new Button(mainPanel)
		.setCaption("Mostrar")
		.onClick(() -> getModelObject().mostrarEquipos());
		
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
