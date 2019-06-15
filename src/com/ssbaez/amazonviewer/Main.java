package com.ssbaez.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ssbaez.amazonviewer.model.Book;
import com.ssbaez.amazonviewer.model.Chapter;
import com.ssbaez.amazonviewer.model.Film;
import com.ssbaez.amazonviewer.model.Movie;
import com.ssbaez.amazonviewer.model.Serie;

public class Main {
	
	/** 
	 * <h1>Amazon Viewer</h1>
	 * Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
	 * incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
	 * exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute 
	 * irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
	 * pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
	 * deserunt mollit anim id est laborum.
	 * 
	 * @author ssbaez
	 * @version 1.1
	 * @since 2019
	 *  **/
	
	public static void main(String[] args) {
		
		showMenu();
		
	}
	
	public static void showMenu() {
		
		Scanner input = new Scanner(System.in);
		
		int response = 0;
		do {
			System.out.println("BIENVENIDOS AMAZON VIEWER\n");
			System.out.println("Selecciona el n�mero de la opci�n deseada");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
			response = input.nextInt();
			
			switch(response) {
			case 0:
				// Salir
				break;
			case 1:
				showMovies();
				break;
			case 2:
				showSeries();
				break;
			case 3:
				showBooks();
				break;
			case 4:
				showMagazines();
				break;
			case 5:
				makeReport();
				break;
			case 6:
				makeReport(new Date());
				break;
				
			default:
				System.out.println("\n...��Selecciona una opcion pendejazo!!...\n");
				break;
			}
			
		}while(response != 0);
		
	}
	
	static ArrayList<Movie> movies = new ArrayList(); 
	public static void showMovies() {
		movies = Movie.makeMovieList();
		int response = 0;
		
		do {
			System.out.println("\n :: MOVIES ::\n");
			for (int i = 0; i < movies.size(); i++) 
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			
			System.out.println("0. Regresar al Menu\n");
			
			Scanner input = new Scanner(System.in);
			response = input.nextInt(); 
			Movie movieSelected; 
			if(response > 0 && response <= movies.size()) { 
				movieSelected = movies.get(response - 1);
				movieSelected.view();
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Seleccion erronea");
			
		}while(response != 0);
	}
	
	static ArrayList<Serie> series = Serie.makeSerieList();
	
	public static void showSeries() {
		int response = 0;
		do {
			System.out.println("\n :: SERIES ::\n");
			
			for(int i = 0; i < series.size(); i++)
				System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			
			System.out.println("0. Regresar al Menu\n");
			
			Scanner input = new Scanner(System.in);
			response =input.nextInt();
			
			if(response > 0 && response <= series.size()) {
				showChapters(series.get(response-1).getChapters()); // Esto envia un ArrayList<Chapter>
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Seleccion erronea");
			
		}while(response != 0);
	}
	
	public static void showChapters(ArrayList<Chapter> chapterOfSerieSelected) {
		int response = 0;
		do {
			System.out.println("\n :: CHAPTERS ::\n");
			
			for(int i = 0; i < chapterOfSerieSelected.size(); i++)
				System.out.println(i + 1 + "." + chapterOfSerieSelected.get(i).getTitle() + " Visto: " + chapterOfSerieSelected.get(i).isViewed());
			
			System.out.println("0.Regresar al Menu anterior\n");
			
			Scanner input = new Scanner(System.in);
			response =input.nextInt();
			
			Chapter chapterSelected;
			if(response > 0 && response <= chapterOfSerieSelected.size()) {
				chapterSelected = chapterOfSerieSelected.get(response - 1);
				chapterSelected.view();
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Seleccion erronea");
			
		}while(response != 0);
	}
	
	static ArrayList<Book> books = Book.makeBooksList();
	
	public static void showBooks() {
		int response = 0;
		do {
			System.out.println("\n :: BOOKS ::\n");
			
			for(int i=0; i < books.size(); i++) {
				System.out.println(i+1 + "." + books.get(i).getTitle() + " Leido:" + books.get(i).isRead());
			}
			
			System.out.println("0. Regresar al menu anterior");
			
			Scanner input = new Scanner(System.in);
			response = input.nextInt();
			
			if(response > 0 && response <= books.size()) {
				
				Book bookSelected = books.get(response - 1);
				bookSelected.read();
				
			}
			
		}while(response != 0);
	}
	
	public static void showMagazines() {
		int response = 0;
		do {
			System.out.println("\n :: MAGAZINES ::\n");
		}while(response != 0);
	}
	
	public static void makeReport() {
		
	}
	
	public static void makeReport(Date date) {
		
	}
}
