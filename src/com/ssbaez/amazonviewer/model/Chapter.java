package com.ssbaez.amazonviewer.model;

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

}
