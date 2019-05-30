package com.ssbaez.amazonviewer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ssbaez.amazonviewer.model.Film;
import com.ssbaez.amazonviewer.model.Movie;
import com.ssbaez.amazonviewer.model.Serie;

public class Main {
	
	public static void main(String[] args) {
		
		//Movie movie = new Movie("Coco", "Fantasy", "Unknown", 120, (short)2017);
		//System.out.println(movie);
		
		Film film = new Movie("", "", "", 0, (short)1999);
		// Se pueden crear objetos del tipo film pero instanciados de tipo Movie
		// El objeto Film se va a comportar de la forma en la que es construido
		// Es decir, Film sera constuido como un objeto Movie	
		// film va a tener todos los metodos de movie
		film.view();
		
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
		
		// ArrayList<Movie> movies = Movie.makeMovieList(); //As� se llama a un metodo static sin crear un Objeto [con estatic se puede crear desde fuera del metodo]
		
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
				
				// -------------------------------------------------
				
				
			}
			else if(response == 0)
				System.out.println("---> Saliendo a Menu Principal");
			else
				System.out.println("Selecci�n err�nea");
			
		}while(response != 0);
	}
	
	public static void showSeries() {
		int response = 0;
		do {
			System.out.println("\n :: SERIES ::\n");
		}while(response != 0);
	}
	
	public static void showChapters() {
		int response = 0;
		do {
			System.out.println("\n :: CHAPTERS ::\n");
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
