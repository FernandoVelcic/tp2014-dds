package com.grupo10.juego;

public interface Observador {
	public void notificarPartidoConfirmado();
	public void notificarFaltanJugadores();
	public void notificarAamigos();
	public void notificarRechazo(String motivo);
}
