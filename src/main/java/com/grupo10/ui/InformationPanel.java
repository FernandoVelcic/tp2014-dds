package com.grupo10.ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public class InformationPanel extends GenerarEquiposView {

	String titulo;
	String informacion;
	
	public InformationPanel(WindowOwner owner, String titulo, String informacion) {
		super(owner);
		this.titulo = titulo;
		this.informacion = informacion;
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		setTitle(titulo);
		new Label(mainPanel).setText(informacion).setHeigth(16);
		
		new Button(mainPanel)
			.setCaption("Aceptar")
			.onClick(() -> this.close());
	}

}
