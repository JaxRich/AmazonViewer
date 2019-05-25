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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + 
				"\n Session Qty: " + getSessionQty() + 
				"\n Chapters Qty: " + getChapters();
	}

}
