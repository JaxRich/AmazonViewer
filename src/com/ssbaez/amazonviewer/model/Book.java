package com.ssbaez.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Book extends Publication {
	
	private int id;
	private String isbn;
	private boolean read;
	private int timeReaded;
	private ArrayList<Page> pages;

	public Book(String title, Date editionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, editionDate, editorial);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
		this.pages = pages;
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

	public String isRead() {
		String visto;
		if(getRead())
			visto = "Si";
		else
			visto = "No";
		
		return visto;
	}
	
	public boolean getRead() {
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
	
	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	public static ArrayList<Book> makeBooksList(){
		
		ArrayList<Book> books = new ArrayList();
		ArrayList<Page> pages = new ArrayList();
		
		int pagina = 0;
		for(int i = 0; i < 5; i++) {
			pagina = i+1;
			pages.add(new Book.Page(pagina, "contenido de la pagina " + pagina)); // sintaxis de clases estaticas
		}
		
		for(int i = 1; i <= 5; i++) {
			String[] authors = {"autor "+ i, "autor " + (i+1)};
			books.add(new Book("Libro " + i, new Date(), "Editorial " + i, authors, pages));
		}
		 return books; 
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String detailBook = "\n :: Book ::" + 
				"\n Title: " + getTitle() + 
				"\n Editorial: " + getEditorial() + 
				"\n Edition Date: " + getEdititonDate() + 
				"\n Authors:";
		
		for(int i = 0; i < getAuthors().length; i++) {
			detailBook += " " + getAuthors()[i];
			if(i+1 == getAuthors().length)
				detailBook += ".";
			else
				detailBook += ",";
		}
		
		return detailBook;
	}
	
	public void read() {
		
		setRead(true);
		int response = 0;
		int  pg = 0;
		
		do {
			System.out.println(".............");
			System.out.println("Pages " + getPages().get(pg).getNumberPag());
			System.out.println(getPages().get(pg).getContent()); // no olvidar instanciar el ArraytList de Pages
			System.out.println(".............");
			
			if (pg != 0) {
				System.out.println("1. Regresar Página");
			}
			
			System.out.println("2. Siguiente Pagina");
			System.out.println("0. Cerrar Libro");
			System.out.println();
			
			Scanner input = new Scanner(System.in);
			response = input.nextInt();
			
			if(response == 2)
				pg++;
			else if(response == 1)
				pg--;
			else if(response == 0)
				break; // se sale del if y del do while
			
		} while (pg <getPages().size());
		
		System.out.println("\n Leiste: \n" + toString());
		
	}
	
	public static class Page{
		
		private int id;
		private int numberPag;
		private String content;
		
		public Page(int numberPag, String content) {
			super();
			this.numberPag = numberPag;
			this.content = content;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumberPag() {
			return numberPag;
		}
		public void setNumberPag(int numberPag) {
			this.numberPag = numberPag;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		
		
	}

}
