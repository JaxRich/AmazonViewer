package com.ssbaez.amazonviewer.model;

import java.util.ArrayList;
import java.util.List;

public class Chapter extends Movie {
	
	private int id;
	private int sessionNumber;
	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumberm, Serie serie) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}
	
	public int getId() {
		return id;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: CHAPTER ::" + 
			"\n Title: " + getSerie().getTitle() +
			"\n Year: " + getYear() + 
			"\n Creator: " + getCreator() +
			"\n Duration: " + getDuration();
	}
	
	public static ArrayList<Chapter> makeChapterList(Serie serie){
		
		ArrayList<Chapter> chapters = new ArrayList();
		
		for(int i=1; i<=5; i++)
			chapters.add(new Chapter("Capitulo " + i, "genero " + i, "creator " + i, 45, (short)(2015+i), i, serie));
			
		return chapters;
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		
		ArrayList<Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		for(Chapter chapter:chapters)
			if(chapter.getViewed())
				chapterViewedCounter++;
		
		if(chapterViewedCounter == chapters.size())
			getSerie().view();
		
	}

}
