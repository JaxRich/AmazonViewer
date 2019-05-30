package com.ssbaez.amazonviewer.model;

import java.util.ArrayList;

public class Chapter extends Movie {
	
	private int id;
	private int sessionNumber;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSessionNumber(sessionNumber);
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: CHAPTER ::" + 
			"\n Title: " + getTitle() +
			"\n Year: " + getYear() + 
			"\n Creator: " + getCreator() +
			"\n Duration: " + getDuration();
	}
	
	public static ArrayList<Chapter> makeChapterList(Serie serie){
		
		ArrayList<Chapter> chapters = new ArrayList();
		
		for(int i=1; i<=5; i++)
			chapters.add(new Chapter("Capitulo " + i, "genero " + i, "creator " + i, 45, (short)2015, 05));
			
		return chapters;
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		
	}

}
