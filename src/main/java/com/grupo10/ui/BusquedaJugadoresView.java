package com.grupo10.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class BusquedaJugadoresView extends Window<BusquedaJugadoresViewModel> {

	public BusquedaJugadoresView(WindowOwner owner) {
		super(owner, new BusquedaJugadoresViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Busqueda de jugadores");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Criterios de busqueda");
		new List(mainPanel);
		
	}

}
