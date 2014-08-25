package com.grupo10.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.MainWindow;

public class HomeView extends MainWindow<HomeViewModel> {
	public HomeView() {
		super(new HomeViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Organizador de Partidos");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("¿Que operacion desea realizar?");
		
		new Button(mainPanel)
			.setCaption("Generar equipos")
			.onClick(() -> getModelObject().generarEquipos(this));
		new Button(mainPanel)
			.setCaption("Busqueda de jugadores")
			.onClick(() -> getModelObject().busquedaJugadores(this));
	}

}
