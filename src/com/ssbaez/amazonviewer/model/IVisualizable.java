package com.ssbaez.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	
	// Solo contendra la declaracion de metodos, ninguna implementacion. Además se puede tener algunos
	// atributos constantes
	
	Date starToSee(Date dateI);
	
	Date stopToSee(Date dateI, Date dateF);

}
