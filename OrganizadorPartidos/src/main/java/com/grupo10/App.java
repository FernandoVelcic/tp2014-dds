package com.grupo10;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import Modalidades.*;

public class App {

	public static void main(String[] args) {
        Administrador fer = new Administrador();
        Partido partidoHoy = fer.CrearPartido(new Date());
       
        Jugador martin = new Jugador();
       
        for(int i = 0; i < 9; i++)
        {
                System.out.println(i);
                boolean test2 = martin.inscribirmeAPartido(partidoHoy, new Estandar());
        }
       
        //martin solo va a jugar si hay 9 jugadores confirmados
        boolean test = martin.inscribirmeAPartido(partidoHoy, new Condicional() {
        @Override
        public boolean isPuedeJugar(Partido partido) {
                return partido.calcularConfirmados() == 9;
        }
    });
        System.out.println(test);
   
}
}