package com.grupo10.ui;

import com.grupo10.homes.HomeJugadores;


/**
 * Correr esta clase con el siguiente argument
 * 
 * -Djava.system.class.loader=com.uqbar.apo.APOClassLoader
 */
public class OrganizadorPartidos {

	public static void main(String[] args) {
		HomeJugadores.getInstance();
		new HomeView().startApplication();
	}

}
