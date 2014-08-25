package com.grupo10.ui;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.*;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class GenerarEquiposView extends Window<GenerarEquiposViewModel> {

	public GenerarEquiposView(WindowOwner owner) {
		super(owner, new GenerarEquiposViewModel());
	}

	@Override
	public void createContents(Panel mainPanel) {
		setTitle("Generar Equipos");
		mainPanel.setLayout(new VerticalLayout());
		
		new Label(mainPanel).setText("Criterio de seleccion");
		new Selector(mainPanel);
		
		new Label(mainPanel).setText("Criterio de ordenamiento");
		new Selector(mainPanel);
		
		new Button(mainPanel)
			.setCaption("Generar equipos")
			.onClick(() -> getModelObject().generarEquipos());
		
		new Label(mainPanel).setText("Resultado: equipos generados");
		
		new Label(mainPanel).setText("Equipo 1:");
		new List(mainPanel);
		new Label(mainPanel).setText("Equipo 2:");
		new List(mainPanel);
		
		new Button(mainPanel)
			.setCaption("Confirmar equipos")
			.onClick(() -> getModelObject().confirmarEquipos());
		//new TextBox(mainPanel).bindValueToProperty("test");
	}

}
