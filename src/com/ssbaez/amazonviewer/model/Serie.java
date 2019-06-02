package com.ssbaez.amazonviewer.model;

import java.util.ArrayList;

public class Serie extends Film {
	
	private int id;
	private int sessionQty;
	private ArrayList<Chapter> chapters;

	public Serie(String title, String genre, String creator, int duration, int sessionQty) {
		super(title, genre, creator, duration);
		// TODO Auto-generated constructor stub
		this.setSessionQty(sessionQty);
	}

	public int getId() {
		return id;
	}

	public int getSessionQty() {
		return sessionQty;
	}

	public void setSessionQty(int sessionQty) {
		this.sessionQty = sessionQty;
	}

	public ArrayList<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(ArrayList<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	public static ArrayList<Serie> makeSerieList(){
		
		ArrayList<Serie> series = new ArrayList();
		
		for(int i = 1; i <= 5; i++) {
			Serie serie = new Serie("Serie "+i, "genero "+i, "creador "+i, 1200, 5);
			serie.setChapters(Chapter.makeChapterList(serie));
			series.add(serie);
		}
		
		return series;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + 
				"\n Session Qty: " + getSessionQty() + 
				"\n Chapters Qty: " + getChapters();
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
	}

	

}
