package com.ssbaez.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.ssbaez.amazonviewer.dao.IMovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * */

public class Movie extends Film implements IVisualizable, IMovieDAO {
	
	private int id;
	private int timeViewed;
	
	public Movie() {
		
	}

	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
		setYear(year);
	}
	
	public void showData() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + 
				"\n Time Viewed: " + getTimeViewed();
	}
	
	public static ArrayList<Movie> makeMovieList(){
		Movie movie = new Movie();
		return movie.read();
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date starToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime() > dateI.getTime()) // getTime() metodo del objeto Date
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		else
			setTimeViewed(0);
		
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		
		Date dateI = starToSee(new Date()); // Aqui se manda el momento en el que se empezo a ver y se guarda en dateI
		
		// Simulacion de ver la pelicula
		for (int i = 0; i < 500 ; i++) {
			System.out.println(".....................................");
		}
		
		// Al terminar de ver la pelicula *****checar este comportamiento*****
		stopToSee(dateI, new Date());
		System.out.printf("%n%s%s %s%n", 
				"Viste: ", toString(), "milisegundos");
	}

}
