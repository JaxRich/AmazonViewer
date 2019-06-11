package com.ssbaez.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	
	// Solo contendra la declaracion de metodos, ninguna implementacion. Además se puede tener algunos
	// atributos constantes
	
	Date starToSee(Date dateI);
	
	Date stopToSee(Date dateI, Date dateF);
	
	// En java 8 se puede implementar comportamientos a los metodos con Default, solo sera accesible dentro de la interfaz
	// En java 9 se puede colocar el modifc de acceso private
	

}
