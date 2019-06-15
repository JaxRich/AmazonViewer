package com.ssbaez.amazonviewer.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public interface IVisualizable {
	
	// Solo contendra la declaracion de metodos, ninguna implementacion. Además se puede tener algunos
	// atributos constantes
	
	// Todos los metodos declarados deben ser implementrtados en donse se implmenete IVisualizable
	 
	Date starToSee(Date dateI);
	
	Date stopToSee(Date dateI, Date dateF);
	
	// En java 8 se puede implementar comportamientos a los metodos con Default, solo sera accesible dentro de la interfaz
	// En java 9 se puede colocar el modifc de acceso private

}
