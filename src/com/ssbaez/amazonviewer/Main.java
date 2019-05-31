package com.ssbaez.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ssbaez.amazonviewer.model.Chapter;
import com.ssbaez.amazonviewer.model.Film;
import com.ssbaez.amazonviewer.model.Movie;
import com.ssbaez.amazonviewer.model.Serie;

public class Main {
	
	public static void main(String[] args) {
		
		// Film film = new Movie("", "", "", 0, (short)1999);
		// Se pueden crear objetos del tipo film pero instanciados de tipo Movie
		// El objeto Film se va a comportar de la forma en la que es construido
		// Es decir, Film sera constuido como un objeto Movie	
		// film va a tener todos los metodos de movie
		// film.view();
		//Film film2 = new Chapter(title, genre, creator, duration, year, sessionNumberm, serie);
		//film2.view();
		
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
	
	static ArrayList<Movie> movies = Movie.makeMovieList(); //As� se llama a un metodo static sin crear un Objeto
	
	public static void showMovies() {
		
		int response = 0;
		
		do {
			
			System.out.println("\n :: MOVIES ::\n");
			
			for (int i = 0; i < movies.size(); i++) // Este for estara imprimiendo todos los datos dummy de movies 
				System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			
			System.out.println("0. Regresar al Menu\n");
			
			Scanner input = new Scanner(System.in);
			response = input.nextInt(); // Aqu� se recibe la seleccion
			Movie movieSelected; // ***************** Se crea una variable de tipo Movie *****************
			if(response > 0 && response <= movies.size()) { // Se evalua la seleccion
				movieSelected = movies.get(response - 1); //.get() es un metodo del objeto ArrayList
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
			
			Serie serieSelected;
			
			if(response > 0 && response <= series.size()) {
				serieSelected = series.get(response - 1);
				serieSelected.view();
				showChapters(serieSelected);
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Seleccion erronea");
			
		}while(response != 0);
	}
	
	public static void showChapters(Serie serieSelected) {
		int response = 0;
		do {
			System.out.println("\n :: CHAPTERS ::\n");
			
			ArrayList<Chapter> chapters = Chapter.makeChapterList(serieSelected);
			
			for(int i = 0; i < chapters.size(); i++)
				System.out.println(i + 1 + "." + chapters.get(i).getTitle() + " Visto: " + chapters.get(i).isViewed());
			
			System.out.println("0. Regresar al Menu anterior\n");
			
			Scanner input = new Scanner(System.in);
			response =input.nextInt();
			
			Chapter chapterSelected;
			if(response > 0 && response <= chapters.size()) {
				chapterSelected = chapters.get(response - 1);
				chapterSelected.view();
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Seleccion erronea");
			
		}while(response != 0);
	}
	
	public static void showBooks() {
		int response = 0;
		do {
			System.out.println("\n :: BOOKS ::\n");
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
