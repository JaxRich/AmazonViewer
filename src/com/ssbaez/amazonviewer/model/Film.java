package com.ssbaez.amazonviewer.model;

public abstract class Film {
	
	// clase abstracta, se utiliza para definir subclases, esta se hereda para 
	// utilizar y sobreescribir los metodos
	
	// no se pueden hacer instancias, solo se hereda, la herencia de metodos es lineal
	// es decir, de una clase padrew a una clase hijo, asi sucesivamente
	
	// se pueden ir heredando metodos abstractos y no abstractos
	
	// una clase abstracta sirve para redefinir nuevas clases sin crear nuevos objetos
	
	private String title;
	private String genre;
	private String creator;
	private int duration;
	private short year;
	private boolean viewed;
	
	public Film() {
		
	}
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public String isViewed() {
		String visto;
		if(viewed == true)
			visto = "Si";
		else
			visto = "No";
			
		return visto;
	}
	
	public boolean getViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	// comentario prueba
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n :: MOVIE/SERIE ::" 	+ 
				"\n Title: " 		+ getTitle() + 
				"\n Genero: " 		+ getGenre() + 
				"\n Year: " 		+ getYear() + 
				"\n Creator: " 		+ getCreator() + 
				"\n Duration: " 	+ getDuration();
	}
	
	/**
	 * {@code view()} es un metodo abstracto obligatorio de implementar
	 * */
	public abstract void view();
	

}
