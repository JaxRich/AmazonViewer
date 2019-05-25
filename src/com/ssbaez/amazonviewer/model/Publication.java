package com.ssbaez.amazonviewer.model;

import java.util.Date;

public class Publication {
	
	private String title;
	private Date edititonDate;
	private String editorial;
	private String[] authors;
	
	public Publication(String title, Date editionDate, String editorial) {
		super();
		this.title = title;
		this.edititonDate = editionDate;
		this.editorial = editorial;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getEdititonDate() {
		return edititonDate;
	}

	public void setEdititonDate(Date edititonDate) {
		this.edititonDate = edititonDate;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

}
