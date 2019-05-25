package com.ssbaez.amazonviewer.model;

import java.util.Date;

public class Book extends Publication {
	
	private int id;
	private String isbn;
	private boolean read;
	private int timeReaded;

	public Book(String title, Date editionDate, String editorial, String[] authors) {
		super(title, editionDate, editorial);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
	}
	
	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailBook = "\n :: Book ::" + 
				"\n Title: " + getTitle() + 
				"\n Editorial: " + getEditorial() + 
				"\n Edition Date: " + getEdititonDate() + 
				"\n Authors: ";
		
		for(int i = 0; i < getAuthors().length; i++)
			detailBook += "\t" + getAuthors()[i];
		
		return detailBook;
	}

}
